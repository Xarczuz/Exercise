package Java;

import java.io.IOException;

public class TEst {

	public static void main(String[] args) {

		// System.out.println(new String(new char[50]).replace("\0", "\r\n"));
		System.out.print("\033[2J");
		System.out.print("\033[H");
		System.out.println();

		System.out.printf("Text: %10s  tal: %10d  antal: %10d", "namb", 2, 8);
		
		// clrscr();
	}

	public static void clrscr() {
		// Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}
}
