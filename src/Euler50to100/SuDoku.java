package Euler50to100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Problem 96
 * 
 * @author Chjun-chi
 *
 */
public class SuDoku {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File(Paths.get("./src/Euler50to100/p096_sudoku.txt").toFile().getPath());
		 BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		ArrayList<String> arr = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null) {
			arr.add(st);
		}
		int[][] sudoku = new int[9][9];
		for (int i = 1; i <= 9; i++) {
		
			for (int j = 0; j < arr.get(i).length(); j++) {
				sudoku[i-1][j]=Integer.parseInt(arr.get(i).subSequence(j, j+1).toString());
			}				
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

}
