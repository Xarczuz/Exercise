package Vitec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Pusslet {

    public static void main(String[] args) throws IOException {
        System.out.println("1 solution: " + placePuzzle("./src/Vitech/testcase5.txt"));
        System.out.println("1 solution: " + placePuzzle("./src/Vitech/testcase4.txt"));
        System.out.println("1 solution: " + placePuzzle("./src/Vitech/testcase3.txt"));
        System.out.println("2 solutions: " + placePuzzle("./src/Vitech/testcase2.txt"));
        System.out.println("1 solution: " + placePuzzle("./src/Vitech/testcase1.txt"));
    }

    private static int placePuzzle(String filename) throws IOException {

        ArrayList<String> arr = readFile(filename);
        String[][] matrix = findSizeOfPuzzle(arr);
        if (arr.size() == 1) {
            return 1;
        }
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            if (s.charAt(0) == 'R' && s.charAt(3) == 'R') {
                arr.remove(i);
                matrix[0][0] = s;
                return findSolutions(s, matrix, 0, 0, arr);
            }
        }
        return 0;
    }

    private static String[][] findSizeOfPuzzle(ArrayList<String> arr) {
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
        return new String[y][x];
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

    private static int findSolutions(String puzzleInPlace, String[][] matrix, int x, int y, ArrayList<String> arr) {
        int total = 0;
//        System.out.println(arr);
//        printMatrix(matrix);
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
        }
        return total;
    }

    private static String puzzleMatch(String puzzleInPlace, String puzzleToPlace, String[][] matrix, int x, int y) {
        if (puzzleInPlace.equals("")) {
            if (matrix[y][x] == null) {
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                return "emptySpot";
            }
        }
        if (matchEast(puzzleInPlace, puzzleToPlace)) {
            x++;
            if (y >= 0 && x >= 0 && y < matrix.length && x < matrix[0].length && matrix[y][x] == null) {
                if (y - 1 >= 0) {
                    if (!matchNorth(puzzleToPlace, matrix[y - 1][x])) {
                        return "";
                    }
                }
                return "east";
            }
        }
        return "";
    }

    //charAt orientation
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

    public static ArrayList<String> readFile(String file) throws IOException {
        FileReader fr =
                new FileReader(Paths.get(file).toFile().getPath());
        BufferedReader in = new BufferedReader(fr);
        ArrayList<String> arr = new ArrayList<>();
        String row;
        while ((row = in.readLine()) != null) {
            arr.add(row);
        }
        arr.remove(0); //remove nr of puzzlebits
        return arr;
    }

}


