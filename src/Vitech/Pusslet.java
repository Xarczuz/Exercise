package Vitech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Pusslet {
//    pusselenkel.txt // indata.txt
//    1
//    RRRR
//
//    2
//    RURR
//    RRRI
//
//    4
//    RUUR
//    RRUI
//    IIRR
//    IRRU

    public static void main(String[] args) throws IOException {
        // ArrayList<String> arr = readFile("./src/Vitech/supersimpletestcase.txt");
        ArrayList<String> arr = readFile("./src/Vitech/pusselMedel.txt");

        //  ArrayList<String> arr = readFile("./src/Vitech/indata.txt");

//        ArrayList<String> arr = readFile("./src/Vitech/pusselenkel.txt");
        int sizeOfMatrix = Integer.parseInt(arr.remove(0));
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            if (s.charAt(0) == 'R' && s.charAt(3) == 'R') {
                arr.remove(i);
                matrix[0][0] = s;
                int amountOfSolutions = findSolutions(s, matrix, 0, 0, arr);
                System.out.println(amountOfSolutions);
                break;
            }
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int findSolutions(String puzzleInPlace, String[][] matrix, int x, int y, ArrayList<String> arr) {

        int total = 0;
        printMatrix(matrix);
        System.out.println(arr);
        if (arr.size() == 1) {
            return 1;
        }

        for (int i = 0; i < arr.size(); i++) {
            String puzzleToPlace = arr.get(i);

            String s = puzzleMatch(puzzleInPlace, puzzleToPlace, matrix, x, y);
            if (s.equals("east")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(i);
                String[][] matrixClone = matrix.clone();
                matrixClone[y][x + 1] = puzzleToPlace;
                total += findSolutions(puzzleToPlace, matrixClone, x + 1, y, clone);

            } else if (s.equals("south")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(i);
                String[][] matrixClone = matrix.clone();
                matrixClone[y + 1][x] = puzzleToPlace;
                total += findSolutions(puzzleToPlace, matrixClone, x, y + 1, clone);

            } else if (s.equals("west")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(i);
                String[][] matrixClone = matrix.clone();
                matrixClone[y][x - 1] = puzzleToPlace;
                total += findSolutions(puzzleToPlace, matrixClone, x - 1, y, clone);

            } else if (s.equals("north")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(i);
                String[][] matrixClone = matrix.clone();
                matrixClone[y - 1][x] = puzzleToPlace;
                total += findSolutions(puzzleToPlace, matrixClone, x, y - 1, clone);

            }

        }
        return total;
    }

    private static String puzzleMatch(String puzzleInPlace, String puzzleToPlace, String[][] matrix, int x, int y) {

        if (matchNorth(puzzleInPlace, puzzleToPlace)) {
            y--;
            //north east west
            if (y >= 0 && x >= 0 && matrix[y][x] == null) {
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                if (x + 1 < matrix.length) {

                    if (!matchEast(puzzleToPlace, matrix[y][x + 1])) {
                        return "";
                    }
                }
                if (x - 1 >= 0) {
                    if (!matchWest(puzzleToPlace, matrix[y][x - 1])) {
                        return "";
                    }
                }
                return "north";
            }

        }

        if (matchEast(puzzleInPlace, puzzleToPlace)) {
            x++;
            if (y >= 0 && x >= 0 && matrix[y][x] == null) {
                //north east south
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                if (x + 1 < matrix.length) {
                    if (!matchEast(puzzleToPlace, matrix[y][x + 1])) {
                        return "";
                    }
                }
                if (y + 1 < matrix.length) {
                    if (!matchSouth(puzzleToPlace, matrix[y + 1][x])) {
                        return "";
                    }
                }

                return "east";
            }
        }

        if (matchSouth(puzzleInPlace, puzzleToPlace)) {
            y++;
            // east south west
            if (y >= 0 && x >= 0 && matrix[y][x] == null) {
                if (x - 1 >= 0) {
                    if (!matchWest(puzzleToPlace, matrix[y][x - 1])) {
                        return "";
                    }
                }
                if (x + 1 < matrix.length) {
                    if (!matchEast(puzzleToPlace, matrix[y][x + 1])) {
                        return "";
                    }
                }
                if (y + 1 < matrix.length) {
                    if (!matchSouth(puzzleToPlace, matrix[y + 1][x])) {
                        return "";
                    }
                }

                return "south";
            }
        }
        if (matchWest(puzzleInPlace, puzzleToPlace)) {
            y++;
            // north south west
            if (y >= 0 && x >= 0 && matrix[y][x] == null) {
                if (x - 1 >= 0) {
                    if (!matchWest(puzzleToPlace, matrix[y][x - 1])) {
                        return "";
                    }
                }
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                if (y + 1 < matrix.length) {
                    if (!matchSouth(puzzleToPlace, matrix[y + 1][x])) {
                        return "";
                    }
                }

                return "west";
            }
        }

        return "";
    }

    //charAt direction orientaion
    //0 north
    //1 east
    //2 south
    //3 west

    private static boolean matchNorth(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleToPlace == null) {
            return true;
        }
        if (!checkRNorth(puzzleInPlace, puzzleToPlace)) {
            return false;
        }
        if (puzzleInPlace.charAt(0) == 'U' && puzzleToPlace.charAt(2) == 'I') {
            return true;
        }
        if (puzzleInPlace.charAt(0) == 'I' && puzzleToPlace.charAt(2) == 'U') {
            return true;
        }

        return false;
    }

    private static boolean checkRNorth(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleInPlace.charAt(1) == 'R' && puzzleToPlace.charAt(1) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(1) != 'R' && puzzleToPlace.charAt(1) == 'R') {
            return false;
        }

        if (puzzleInPlace.charAt(3) == 'R' && puzzleToPlace.charAt(3) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(3) != 'R' && puzzleToPlace.charAt(3) == 'R') {
            return false;
        }
        return true;
    }

    private static boolean matchEast(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleToPlace == null) {
            return true;
        }
        if (!checkREast(puzzleInPlace, puzzleToPlace)) {
            return false;
        }

        if (puzzleInPlace.charAt(1) == 'U' && puzzleToPlace.charAt(3) == 'I') {
            return true;
        }
        if (puzzleInPlace.charAt(1) == 'I' && puzzleToPlace.charAt(3) == 'U') {
            return true;
        }
        return false;
    }

    private static boolean checkREast(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleInPlace.charAt(0) == 'R' && puzzleToPlace.charAt(0) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(0) != 'R' && puzzleToPlace.charAt(0) == 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(2) == 'R' && puzzleToPlace.charAt(2) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(2) != 'R' && puzzleToPlace.charAt(2) == 'R') {
            return false;
        }
        return true;
    }

    private static boolean matchWest(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleToPlace == null) {
            return true;
        }
        if (!checkRWest(puzzleInPlace, puzzleToPlace)) {
            return false;
        }

        if (puzzleInPlace.charAt(3) == 'U' && puzzleToPlace.charAt(1) == 'I') {
            return true;
        }
        if (puzzleInPlace.charAt(3) == 'I' && puzzleToPlace.charAt(1) == 'U') {
            return true;
        }
        return false;
    }

    private static boolean checkRWest(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleInPlace.charAt(0) == 'R' && puzzleToPlace.charAt(0) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(0) != 'R' && puzzleToPlace.charAt(0) == 'R') {
            return false;
        }

        if (puzzleInPlace.charAt(2) == 'R' && puzzleToPlace.charAt(2) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(2) != 'R' && puzzleToPlace.charAt(2) == 'R') {
            return false;
        }
        return true;
    }

    private static boolean matchSouth(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleToPlace == null) {
            return true;
        }
        if (!checkRSouth(puzzleInPlace, puzzleToPlace)) {
            return false;
        }

        if (puzzleInPlace.charAt(2) == 'U' && puzzleToPlace.charAt(0) == 'I') {
            return true;
        }
        if (puzzleInPlace.charAt(2) == 'I' && puzzleToPlace.charAt(0) == 'U') {
            return true;
        }
        return false;
    }

    private static boolean checkRSouth(String puzzleInPlace, String puzzleToPlace) {
        if (puzzleInPlace.charAt(1) == 'R' && puzzleToPlace.charAt(1) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(1) != 'R' && puzzleToPlace.charAt(1) == 'R') {
            return false;
        }

        if (puzzleInPlace.charAt(3) == 'R' && puzzleToPlace.charAt(3) != 'R') {
            return false;
        }
        if (puzzleInPlace.charAt(3) != 'R' && puzzleToPlace.charAt(3) == 'R') {
            return false;
        }

        return true;
    }

    public static ArrayList<String> readFile(String file) throws IOException {
        FileReader fr =
                new FileReader(Paths.get(file).toFile().getPath());
        BufferedReader in = new BufferedReader(fr);
        ArrayList<String> strings = new ArrayList<>();
        String row;
        while ((row = in.readLine()) != null) {
            strings.add(row);
        }

        return strings;
    }

}


