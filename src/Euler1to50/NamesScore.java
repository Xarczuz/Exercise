package Euler1to50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NamesScore {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException {

		HashMap<String, Integer> alpha = new HashMap<String, Integer>();
		alpha.put("a", 1);
		alpha.put("b", 2);
		alpha.put("c", 3);
		alpha.put("d", 4);
		alpha.put("e", 5);
		alpha.put("f", 6);
		alpha.put("g", 7);
		alpha.put("h", 8);
		alpha.put("i", 9);
		alpha.put("j", 10);
		alpha.put("k", 11);
		alpha.put("l", 12);
		alpha.put("m", 13);
		alpha.put("n", 14);
		alpha.put("o", 15);
		alpha.put("p", 16);
		alpha.put("q", 17);
		alpha.put("r", 18);
		alpha.put("s", 19);
		alpha.put("t", 20);
		alpha.put("u", 21);
		alpha.put("v", 22);
		alpha.put("w", 23);
		alpha.put("x", 24);
		alpha.put("y", 25);
		alpha.put("z", 26);
		
		

		File file = new File(Paths.get("./src/Euler1to50/namesScore.txt").toFile().getPath());

		br = new BufferedReader(new FileReader(file));
		String[] names = null;
		ArrayList<String> s = new ArrayList<String>();

		String st;
		while ((st = br.readLine()) != null) {
			names = st.split(",");
		}
		for (int i = 0; i < names.length; i++) {
			s.add(names[i].replaceAll("\"", ""));
		}
		Collections.sort(s);
		System.out.println(s.toString());
		int position = 1;
		long totalSum = 0;
		for (int i = 0; i < s.size(); i++, position++) {
			
			int score = 0;
			for (int j = 0; j < s.get(i).length(); j++) {
				score += alpha.get(s.get(i).substring(j, j + 1).toLowerCase());
			}
			totalSum += score * position;
		}

		System.out.println(totalSum);
	}
}
