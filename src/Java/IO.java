package Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class IO {
	public static void main(String[] args) throws IOException {
		// Skriv till en fil med NIO API, endast för små filer
		fileNew("Text in med åäö som skrivs till fil", "test.txt");
		fileApp("En till rad som vi har lagt till med APPEND", "test.txt");
		fileApp("Nu kan vi börja skriva ännu mer", "test.txt");
		fileApp("Och ännu mer", "test.txt");
		String te = fread("test.txt");
		System.out.println("Läst: \n" + te);
		String[] ar = te.split("\n");
		// Skriv ut arrayen ------
		System.out.println("\nRader i arrayen är: " + ar.length);
		int i = 0;
		for (String rad : ar) {
			System.out.printf("Rad: %d %s\n", i, rad);
			i++;
		}
	}

	// Läser med metod från fil med NIO Files.readAllBytes() --
	public static String fread(String fil) throws IOException {
		byte[] fileArr; // Byte array för lagring av svaret
		// Skapa reader och läs från filen ---
		fileArr = Files.readAllBytes(Paths.get(fil));
		String retur = new String(fileArr); // Konvereter till sträng --
		return retur;
	}

	// Skriv med metod till fil med NIO File.write() ---
	static void fileNew(String text, String fil) throws IOException {
		Path p = Paths.get(fil); // Sätter path med fil namnet
		Files.write(p, text.getBytes()); // Skriver till fil
	}

	// Skriv med metod till fil med NIO File.write() ---
	static void fileApp(String text, String fil) throws IOException {
		Path p = Paths.get(fil); // Sätter path med fil namnet
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(p, text.getBytes(), StandardOpenOption.APPEND);
	}
}
