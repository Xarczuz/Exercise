package Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class NIO {
	public static void main(String[] args) throws IOException {
		String text = "En första rad";
		String text2 = "Den andra raden";
		// Skriver1: Sätter sökväg till filen Path och skriver ---
		Path p = Paths.get("test.txt"); // Sätter path med fil
										// namnetFiles.write(p,text.getBytes());
										// // Skriver till fil
		Files.write(p, text.getBytes()); // Skriver till fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND); // Radmatning
		Files.write(p, text2.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND); // Radmatning
		// var är close ??
		String text3 = "Ny text läggs till i filen ";
		String text4 = "Mer Ny text läggs till";
		// Path p = (Path) Paths.get("test.txt"); // Sätter path med fil namnet
		Files.write(p, text3.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(p, text4.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		// Läser från filen ---
		byte[] fileArr; // Byte array för lagring av svaret
		// Skapa reader och läs från filen ---
		fileArr = Files.readAllBytes(Paths.get("test.txt"));
		System.out.println(new String(fileArr));
		// String retur = new String(fileArr); // Konvereter till sträng om
		// retur --
	}
}
