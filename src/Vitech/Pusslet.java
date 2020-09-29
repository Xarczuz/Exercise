package Vitech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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
//         ArrayList<String> arr = readFile("./src/Vitech/supersimpletestcase.txt");
//        ArrayList<String> arr = readFile("./src/Vitech/pusselMedel.txt");
//
        ArrayList<String> arr = readFile("./src/Vitech/indata.txt");

//        ArrayList<String> arr = readFile("./src/Vitech/pusselenkel.txt");

        arr.remove(0);
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).charAt(0) == 'R') {
                x++;
            }
            if (arr.get(i).charAt(1) == 'R') {
                y++;
            }
        }

        String[][] matrix = new String[y][x];

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
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int counter = 0;

    private static int findSolutions(String puzzleInPlace, String[][] matrix, int x, int y, ArrayList<String> arr) {

        // counter++;
//        if (matrix[0][1] != null && matrix[0][2] != null && matrix[0][3] != null && matrix[0][4] != null) {
//
//            System.out.println(arr);
//            printMatrix(matrix);
//        }
//        if (arr.size() > 8) {
//            System.out.println(arr);
//            printMatrix(matrix);
//        }
        if (matrix[2][1] != null && matrix[2][1].equals("UUUU")) {//TODO FIX WRONG DIRECTION GOING WEST SHOULD OG EAST DEBUG FIND OUT WIN
            System.out.println(arr);
            printMatrix(matrix);
        }
        int total = 0;

        if (arr.size() == 0) {
            return 1;
        }

        for (int i = 0; i < arr.size(); i++) {
            String puzzleToPlace = arr.get(i);

            String s = puzzleMatch(puzzleInPlace, puzzleToPlace, matrix, x, y);
            if (s.equals("east")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(puzzleToPlace);

                String[][] matrixClone = Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);

                matrixClone[y][x + 1] = puzzleToPlace;

                if (x + 1 == matrix[0].length - 1) {
                    total += findSolutions("", matrixClone, 0, y + 1, clone);

                } else {

                    total += findSolutions(puzzleToPlace, matrixClone, x + 1, y, clone);
                }

            } else if (s.equals("emptySpot")) {
                ArrayList<String> clone = new ArrayList<>(arr);
                clone.remove(puzzleToPlace);
                String[][] matrixClone = Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);
                matrixClone[y][x] = puzzleToPlace;
                total += findSolutions(puzzleToPlace, matrixClone, x, y, clone);

            }

//            else if (s.equals("south")) {
//                ArrayList<String> clone = new ArrayList<>(arr);
//                clone.remove(puzzleToPlace);
//                String[][] matrixClone = Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);
//
//                matrixClone[y + 1][x] = puzzleToPlace;
//                total += findSolutions(puzzleToPlace, matrixClone, x, y + 1, clone);
//
//            } else if (s.equals("west")) {
//                ArrayList<String> clone = new ArrayList<>(arr);
//                clone.remove(puzzleToPlace);
//                String[][] matrixClone = Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);
//                matrixClone[y][x - 1] = puzzleToPlace;
//                total += findSolutions(puzzleToPlace, matrixClone, x - 1, y, clone);
//
//            } else if (s.equals("north")) {
//                ArrayList<String> clone = new ArrayList<>(arr);
//                clone.remove(puzzleToPlace);
//                String[][] matrixClone = Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);
//                matrixClone[y - 1][x] = puzzleToPlace;
//                total += findSolutions(puzzleToPlace, matrixClone, x, y - 1, clone);
//            }

        }

        return total;
    }

    private static String puzzleMatch(String puzzleInPlace, String puzzleToPlace, String[][] matrix, int x, int y) {
        if (puzzleInPlace.equals("")) {
            if (matrix[y][x] == null) {
                //north east south
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                return "emptySpot";
            }
        }

        if (matchNorth(puzzleInPlace, puzzleToPlace)) {
            y--;
            //north east west
            if (y >= 0 && x >= 0 && y < matrix.length && x < matrix[0].length && matrix[y][x] == null) {
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                if (x + 1 < matrix[0].length) {
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

            if (y >= 0 && x >= 0 && y < matrix.length && x < matrix[0].length && matrix[y][x] == null) {
                //north east south
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                if (x + 1 < matrix[0].length) {
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
            if (y >= 0 && x >= 0 && y < matrix.length && x < matrix[0].length && matrix[y][x] == null) {
                if (x - 1 >= 0) {
                    if (!matchWest(puzzleToPlace, matrix[y][x - 1])) {
                        return "";
                    }
                }
                if (x + 1 < matrix[0].length) {
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
            if (y >= 0 && x >= 0 && y < matrix.length && x < matrix[0].length && matrix[y][x] == null) {
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


