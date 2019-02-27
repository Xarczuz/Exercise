package Euler1to50;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Coded triangle numbers Problem 42 The nth term of the sequence of triangle
 * numbers is given by, tn = �n(n+1); so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
 * is a triangle number then we shall call the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class CodedTriangleNumbers {

	static HashSet<Integer> tNr = new HashSet<>();
	static HashMap<String, Integer> index = new HashMap<>();
	public static void main(String[] args) {
		Timer t= new Timer();
		makeIndex();
		makeTnr();
		String[] words = readAllByte("src/Euler1_50/p042_words.txt",
				Charset.forName("UTF-8")).get(0).replace("\"", "").split(",");
		int tWords = 0;
		for (String string : words) {
			if (wordToNr(string.toLowerCase())) {
				tWords++;
			}
		}
		System.out.println(tWords + " are triangle words.");
		t.time();
	}
	private static void makeTnr() {
		for (int i = 1; i < 20; i++) {
			tNr.add((i * (i + 1)) / 2);
		}
	}
	public static void makeIndex() {
		index.put("a", 1);
		index.put("b", 2);
		index.put("c", 3);
		index.put("d", 4);
		index.put("e", 5);
		index.put("f", 6);
		index.put("g", 7);
		index.put("h", 8);
		index.put("i", 9);
		index.put("j", 10);
		index.put("k", 11);
		index.put("l", 12);
		index.put("m", 13);
		index.put("n", 14);
		index.put("o", 15);
		index.put("p", 16);
		index.put("q", 17);
		index.put("r", 18);
		index.put("s", 19);
		index.put("t", 20);
		index.put("u", 21);
		index.put("v", 22);
		index.put("w", 23);
		index.put("x", 24);
		index.put("y", 25);
		index.put("z", 26);
	}
	public static boolean wordToNr(String word) {
		int wordSum = 0;
		for (int i = 0; i < word.length(); i++) {
			String s = word.substring(i, i + 1);
			
			wordSum += index.get(s);
		}
		if (tNr.contains(wordSum)) {
			return true;
		}
		return false;
	}
	public static List<String> readAllByte(String file, Charset charset) {
		List<String> fileArr = null;
		try {
			fileArr = Files.readAllLines(Paths.get(file), charset);// Files.readAllBytes(Paths.get(file));
			return fileArr;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
