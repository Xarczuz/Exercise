package Java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

class Dator {
	private String cpu;
	private String gpu;
	private String motherboard;

	public Dator(String cpu, String gpu, String motherboard) {
		this.cpu = cpu;
		this.gpu = gpu;
		this.motherboard = motherboard;
	}

	public String getCpu() {
		return cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public String getMotherboard() {
		return motherboard;
	}

	public void print() {
		System.out.printf("Cpu:%-10s gpu:%-10s motherbord: %-10s\n", cpu, gpu, motherboard);
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "[cpu=" + cpu + ", gpu=" + gpu + ", motherboard=" + motherboard + "]";
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}
}

public class Java {
	public static void main(String[] args) throws IOException {
		start();
	}

	private static void start() throws IOException {
		ArrayList<Dator> data = new ArrayList<>();
		String tmp = "";
		while (true) {
			printMeny();
			tmp = Scr.inStr();
			System.out.println();
			switch (tmp) {
			case "1":
				showList(data);
				break;
			case "2":
				addPost(data);
				break;
			case "3":
				removePost(data);
				break;
			case "4":
				System.out.printf("Antal poster: %3d\n", data.size());
				break;
			case "5":
				data.clear();
				System.out.println("Listan tömd.");
				break;
			case "6":
				modifyPost(data);
				break;
			case "7":
				writeToFile(data);
				break;
			case "8":
				readFromFile(data);
				break;
			case "9":
				System.out.println("Avsultad.");
				return;
			default:
				System.out.println("Fel meny val!");
				break;
			}
		}
	}

	private static void readFromFile(ArrayList<Dator> data) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader((new FileReader(".\\Computer components.txt")));
		while (true) {
			String tmps = in.readLine();
			if (tmps == null) {
				break;
			}
			String[] element = tmps.split(",");
			Dator d = new Dator(element[0].split("=")[1].replaceAll("[\\[]", ""), element[1].split("=")[1],
					element[2].split("=")[1].replaceAll("[\\]]", ""));
			data.add(d);
			System.out.println(tmps);
		}
	}

	private static void writeToFile(ArrayList<Dator> data) throws FileNotFoundException, UnsupportedEncodingException {
		if (data.size() > 0) {
			System.out.println("Sparad till fil.");
			PrintWriter writer = new PrintWriter("Computer components.txt", "UTF-8");
			for (Dator dator : data) {
				writer.println(dator.toString());
			}
			writer.close();
		}
	}

	private static void printMeny() {
		System.out.println("*******************************");
		System.out.println("Meny:");
		System.out.println("1: Visa lista.");
		System.out.println("2: Lägg till en post.");
		System.out.println("3: Ta bort en post.");
		System.out.println("4: Hur många poster finns det.");
		System.out.println("5: Töm Listan");
		System.out.println("6: Redigera post.");
		System.out.println("7: Spara till fil");
		System.out.println("8: Läs från fil");
		System.out.println("9: Avsluta programmet.");
		System.out.println("*******************************");
		System.out.print("Välj: ");
	}

	private static void modifyPost(ArrayList<Dator> data) throws IOException {
		System.out.println("Redigera post index: ");
		String idx = Scr.inStr();
		Dator e;
		if (idx.matches("[0-9]+")) {
			int i = Integer.parseInt(idx);
			if (0 <= i && i < data.size()) {
				e = data.get(i);
				e.print();
				System.out.println("Redigera post.");
				System.out.print("CPU:" + e.getCpu() + " ny CPU:");
				String cpu = Scr.inStr();
				System.out.print("GPU:" + e.getGpu() + " ny GPU:");
				String gpu = Scr.inStr();
				System.out.print("Motherboard:" + e.getMotherboard() + " ny Motherboard:");
				String motherboard = Scr.inStr();
				e.setCpu(cpu);
				e.setGpu(gpu);
				e.setMotherboard(motherboard);

			} else {
				System.out.println("Fel index.");
			}
		} else {
			System.out.println("Inte ett nummer!");
		}
	}

	private static void removePost(ArrayList<Dator> data) throws IOException {
		System.out.println("Ta bort post index: ");
		String index = Scr.inStr();
		if (index.matches("[0-9]+")) {
			int i = Integer.parseInt(index);
			if (i < data.size()) {
				Dator e = data.remove(i);
				e.print();
				System.out.println("Borttaget.");
			} else {
				System.out.println("Fel index.");
			}
		} else {
			System.out.println("Inte ett nummer.");
		}
	}

	private static void addPost(ArrayList<Dator> data) throws IOException {
		System.out.println("Lägg till post.");
		System.out.print("CPU:");
		String cpu = Scr.inStr();
		System.out.print("GPU:");
		String gpu = Scr.inStr();
		System.out.print("motherboard:");
		String motherboard = Scr.inStr();

		Dator d = new Dator(cpu, gpu, motherboard);
		data.add(d);

	}

	public static void showList(ArrayList<Dator> data) {
		if (data.size() == 0) {
			System.out.println("Tom lista:");
		} else {
			System.out.println("Lista:");
		}
		for (int i = 0; i < data.size(); i++) {
			if (i < 10) {
				System.out.print("Index: " + i + "  ");

			} else {
				System.out.print("Index: " + i + " ");
			}
			data.get(i).print();
		}
	}
}

class Scr {
	public static String inStr() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}
}