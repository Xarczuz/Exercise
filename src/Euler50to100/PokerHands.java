package Euler50to100;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PokerHands {

	public static void main(String[] args) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("files/p054_poker.txt"),
				Charset.forName("UTF-8"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
