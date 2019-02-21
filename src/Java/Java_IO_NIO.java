package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Java_IO_NIO {

	private final static java.util.Random rand = new java.util.Random();
	@SuppressWarnings("unused")
	private static final String FILE = "files/test.txt";
	private static final String ser = "files/person.ser";
	private static final Charset CHARSET = Charset.forName("UTF-8");
	public static void main(String[] args) throws IOException {
		
		start();

	}

	@SuppressWarnings("unchecked")
	public static void start() throws IOException {
		ArrayList<P> array = new ArrayList<>();
		// ArrayList<P> array = randomizeData(CHARSET);
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String[] names = readAllByte("src/euler/namesScore.txt", CHARSET).get(0)
				.replace("\"", "").split(",");

		while (true) {
			System.out.println("1: Avsluta");
			System.out.println("2: Lägg till person");
			System.out.println("3: Visa alla personer");
			System.out.println("4: Läs in alla personer från fil");
			System.out.println("5: Spara alla personer till fil");
			System.out.println("6: Skapa en person automatiskt");
			String s = br.readLine();

			switch (s) {
				case "1" :
					System.out.println("Adjö!");
					return;
				case "2" :
					System.out.print("Namn:");
					String n = br.readLine();
					System.out.print("Ålder:");
					String å = br.readLine();
					System.out.print("Höjd:");
					String h = br.readLine();
					array.add(
							new P(n, Integer.parseInt(å), Float.parseFloat(h)));
					break;
				case "3" :
					System.out.println("Personer: ");
					if (array!=null) {
						for (P p : array) {
							p.visa();
						}
					}
					break;
				case "4" :
					array = (ArrayList<P>) deSerialize(ser);
					System.out.println("Inläst!");
					break;
				case "5" :
					serialize(array, ser);
					System.out.println("Sparad!");
					break;
				case "6" :
					array.add(new P(names[rand.nextInt(names.length)],
							rand.nextInt(110) + 1,
							(float) (Math.random() * ((130)) + 70)));
					System.out.println("Person skapad och tillagd!");
					break;
			}
		}
	}
	public static ArrayList<P> randomizeData(Charset charset) {
		ArrayList<P> array = new ArrayList<>();
		String[] s = readAllByte("src/euler/namesScore.txt", charset).get(0)
				.replace("\"", "").split(",");
		for (int i = 0; i < 100000; i++) {
			array.add(new P(s[rand.nextInt(s.length)], rand.nextInt(110) + 1,
					(float) (Math.random() * ((130)) + 70)));
		}
		return array;
	}
	public static void printDeSerialize() {
		@SuppressWarnings("unchecked")
		ArrayList<P> array = (ArrayList<P>) deSerialize(ser);
		for (P p : array) {
			p.visa();
		}
	}
	public static void serialize(Object obj, String ser) {
		try {
			FileOutputStream filout = new FileOutputStream(ser);
			ObjectOutputStream obstr = new ObjectOutputStream(filout);
			obstr.writeObject(obj);
			obstr.close();
			filout.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static Object deSerialize(String ser) {

		try {
			FileInputStream fis = new FileInputStream(ser);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			ois.close();
			fis.close();
			return obj;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}
	public static void writeToTextFile(String file, Charset charset,
			ArrayList<P> array) {
		write("Start:", file, charset);
		writeAppend(array, file, charset);

	}
	public static void write(String text, String file, Charset charset) {

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file),
				charset)) {
			writer.write(text, 0, text.length());
			writer.newLine();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	public static void writeAppend(ArrayList<P> array, String file,
			Charset charset) {

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file),
				charset, StandardOpenOption.APPEND)) {
			for (P p : array) {
				writer.write(p.toString(), 0, p.toString().length());
				writer.newLine();
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
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
	public static ArrayList<P> read(String file) {
		ArrayList<P> array2 = new ArrayList<>();
		Charset charset = Charset.forName("UTF-8");

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(file),
				charset)) {
			String line = null;

			while ((line = reader.readLine()) != null) {

				if (line.contains("namn")) {
					line = line.replace("]", "");
					String[] strings = line.split(",");
					array2.add(new P(strings[0].split(":")[1],
							Integer.parseInt(strings[1].split(":")[1]),
							Float.parseFloat(strings[2].split(":")[1])));
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return array2;
	}
	public void övning1() {
		ArrayList<String> arry = new ArrayList<String>();
		arry.add("Lisa");
		arry.add("Fabian");
		arry.add("Hugo");
		String file = "test.txt";
		Charset charset = Charset.forName("UTF-8");

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file),
				charset)) {
			writer.write(arry.toString(), 0, arry.toString().length());
			writer.newLine();

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(file),
				charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}
class P implements Serializable {

	private static final long serialVersionUID = 4154872473018778610L;
	String namn;
	int ålder;
	float höjd;
	public P(String namn, int ålder, float höjd) {
		this.namn = namn;
		this.ålder = ålder;
		this.höjd = höjd;
	}
	@Override
	public String toString() {
		return "[namn:" + namn + ", ålder:" + ålder + ", höjd:" + höjd + "]";
	}
	public void visa() {
		System.out.printf("Namn:%-10s Ålder:%4d Höjd: %5.1fcm\n", namn, ålder,
				höjd);
	}
}
