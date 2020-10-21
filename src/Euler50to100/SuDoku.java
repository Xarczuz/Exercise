package Euler50to100;

import Euler1to50.Timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem 96
 *
 * @author Chjun-chi
 */
public class SuDoku {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        Timer t = new Timer();
        for (int[][] sud : getSudoku()) {
            sum += solveSudokuBruteForce(sud);
        }
        t.time();
        System.out.println("Project Euler problem 96 fifty sudoku top corner 3 numbers sum: " + sum);
    }

    private static int solveSudokuBruteForce(int[][] sudoku) {
        LinkedList<int[][]> sudokuStack = new LinkedList<>();
        sudokuStack.addLast(sudoku);
        int i = 0, j = 0;
        while (j < 9) {
            int[][] sudokuToTry = sudokuStack.pop();
            if (sudokuToTry[j][i] == 0) {
                for (int k = 1; k <= 9; k++) {
                    if (tryToPlaceNrInMatrix(sudokuToTry, i, j, k)) {
                        int[][] sudokuToTryClone = Arrays.stream(sudokuToTry).map(int[]::clone).toArray(int[][]::new);
                        sudokuToTryClone[j][i] = k;
                        sudokuStack.addLast(sudokuToTryClone);
                    }
                }
            } else {
                sudokuStack.addLast(sudokuToTry);
                i++;
            }
            if (i > 8) {
                i = 0;
                j++;
            }
        }

        int[][] solvedSudoku = sudokuStack.pop();
        StringBuilder st = new StringBuilder();
        st.append(solvedSudoku[0][0]);
        st.append(solvedSudoku[0][1]);
        st.append(solvedSudoku[0][2]);
        return Integer.parseInt(st.toString());
    }

    private static boolean tryToPlaceNrInMatrix(int[][] sudokuToTry, int i, int j, int k) {
        if (checkLinesForDupes(sudokuToTry, i, j, k)) {
            return false;
        }
        if (checkSquaresForDupe(sudokuToTry, i, j, k)) {
            return false;
        }
        return true;
    }

    private static boolean checkLinesForDupes(int[][] sudokuToTry, int i, int j, int k) {
        for (int x = 0; x < i; x++) {
            if (sudokuToTry[j][x] == k) {
                return true;
            }
        }
        for (int x = i + 1; x < 9; x++) {
            if (sudokuToTry[j][x] == k) {
                return true;
            }
        }
        for (int y = 0; y < j; y++) {
            if (sudokuToTry[y][i] == k) {
                return true;
            }
        }
        for (int y = j + 1; y < 9; y++) {
            if (sudokuToTry[y][i] == k) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSquaresForDupe(int[][] sudokuToTry, int i, int j, int k) {
        if (i < 3 && j < 3) {
            int[] s = new int[]{0, 2, 0, 2};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 6 && j < 3) {
            int[] s = new int[]{3, 5, 0, 2};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 9 && j < 3) {
            int[] s = new int[]{6, 8, 0, 2};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 3 && j < 6) {
            int[] s = new int[]{0, 2, 3, 5};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 6 && j < 6) {
            int[] s = new int[]{3, 5, 3, 5};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 9 && j < 6) {
            int[] s = new int[]{6, 8, 3, 5};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 3 && j < 9) {
            int[] s = new int[]{0, 2, 6, 8};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 6 && j < 9) {
            int[] s = new int[]{3, 5, 6, 8};
            return checkSquare(sudokuToTry, s, k);
        } else if (i < 9 && j < 9) {
            int[] s = new int[]{6, 8, 6, 8};
            return checkSquare(sudokuToTry, s, k);
        }
        return true;
    }

    private static boolean checkSquare(int[][] sudokuToTry, int[] s, int k) {
        for (int x = s[0]; x <= s[1]; x++) {
            for (int y = s[2]; y < s[3]; y++) {
                if (sudokuToTry[y][x] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<int[][]> getSudoku() throws IOException {
        File file = new File(Paths.get("./src/Euler50to100/p096_sudoku.txt").toFile().getPath());
        BufferedReader br;
        br = new BufferedReader(new FileReader(file));
        ArrayList<int[][]> arr = new ArrayList<>();
        String st;
        while ((br.readLine()) != null) {
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = br.readLine();
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = (char)(st.charAt(j)-'0');
                }
            }
            arr.add(sudoku);
        }
        return arr;
    }

    private static void printMatrix(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
        System.out.println();
    }

}
