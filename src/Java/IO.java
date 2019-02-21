package Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class IO {
	public static void main(String[] args) throws IOException {
		// Skriv till en fil med NIO API, endast f�r sm� filer
		fileNew("Text in med ��� som skrivs till fil", "test.txt");
		fileApp("En till rad som vi har lagt till med APPEND", "test.txt");
		fileApp("Nu kan vi b�rja skriva �nnu mer", "test.txt");
		fileApp("Och �nnu mer", "test.txt");
		String te = fread("test.txt");
		System.out.println("L�st: \n" + te);
		String[] ar = te.split("\n");
		// Skriv ut arrayen ------
		System.out.println("\nRader i arrayen �r: " + ar.length);
		int i = 0;
		for (String rad : ar) {
			System.out.printf("Rad: %d %s\n", i, rad);
			i++;
		}
	}

	// L�ser med metod fr�n fil med NIO Files.readAllBytes() --
	public static String fread(String fil) throws IOException {
		byte[] fileArr; // Byte array f�r lagring av svaret
		// Skapa reader och l�s fr�n filen ---
		fileArr = Files.readAllBytes(Paths.get(fil));
		String retur = new String(fileArr); // Konvereter till str�ng --
		return retur;
	}

	// Skriv med metod till fil med NIO File.write() ---
	static void fileNew(String text, String fil) throws IOException {
		Path p = Paths.get(fil); // S�tter path med fil namnet
		Files.write(p, text.getBytes()); // Skriver till fil
	}

	// Skriv med metod till fil med NIO File.write() ---
	static void fileApp(String text, String fil) throws IOException {
		Path p = Paths.get(fil); // S�tter path med fil namnet
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(p, text.getBytes(), StandardOpenOption.APPEND);
	}
}
