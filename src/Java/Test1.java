package Java;


import java.util.Scanner;

public class Test1 {

	private static Scanner in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Inmating av namn och tel samt utskrift");
		System.out.print("Namn: ");
		String namn = in.nextLine();
		System.out.print("Tel: ");
		String tel = in.nextLine();
		while (!tel.matches("[1-9 -]+")) {
			System.out.println("Not a valid phonenumber ");
			tel = in.nextLine();
		}
		System.out.print("≈lder:");
		String age = in.nextLine();
		while (!age.matches("[0-9]+")) {
			System.out.println("Not a valid age ");
			age = in.nextLine();

		}
		System.out.print("Inkomst:");
		String income = in.nextLine();
		while (!income.matches("[0-9]+")) {
			System.out.println("Not a valid income ");
			income = in.nextLine();

		}
		System.out.println("\n*********");
		System.out.println("Namn:" + namn + "\nTel:" + tel + "\n≈lder:" + age + "\nInkomst: " + income + "kr");
		System.out.println("*********");

	}
}
