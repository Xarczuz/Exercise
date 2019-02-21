package Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class NIO {
	public static void main(String[] args) throws IOException {
		String text = "En f�rsta rad";
		String text2 = "Den andra raden";
		// Skriver1: S�tter s�kv�g till filen Path och skriver ---
		Path p = Paths.get("test.txt"); // S�tter path med fil
										// namnetFiles.write(p,text.getBytes());
										// // Skriver till fil
		Files.write(p, text.getBytes()); // Skriver till fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND); // Radmatning
		Files.write(p, text2.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND); // Radmatning
		// var �r close ??
		String text3 = "Ny text l�ggs till i filen ";
		String text4 = "Mer Ny text l�ggs till";
		// Path p = (Path) Paths.get("test.txt"); // S�tter path med fil namnet
		Files.write(p, text3.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(p, text4.getBytes(), StandardOpenOption.APPEND); // Skriver
																		// till
																		// fil
		Files.write(p, "\n".getBytes(), StandardOpenOption.APPEND);
		// L�ser fr�n filen ---
		byte[] fileArr; // Byte array f�r lagring av svaret
		// Skapa reader och l�s fr�n filen ---
		fileArr = Files.readAllBytes(Paths.get("test.txt"));
		System.out.println(new String(fileArr));
		// String retur = new String(fileArr); // Konvereter till str�ng om
		// retur --
	}
}
