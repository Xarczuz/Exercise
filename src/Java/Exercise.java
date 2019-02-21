package Java;

import java.util.ArrayList;

public class Exercise {

	public static void main(String[] args) {
		Exercise c1 = new Exercise();
		c1.getType("yoyoy 2323++5");
		c1.getType((int) 1234);
		c1.getType((double) 42343);
		c1.getType((long) 62343);
		c1.getType((float) 72343);
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		c1.divideByTwo(5);
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		c1.plus(223523523, (long) 44364634634L);
		c1.plus(223523523, (double) 44364634634D);
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		ArrayList<Long> l = new ArrayList<>();
		l.add(234324L);
		l.add(3235532L);
		l.add(32342L);
		ArrayList<Double> d = new ArrayList<>();
		d.add(234.324D);
		d.add(232342.124D);
		c1.mean(l, d);
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		Person p1 = new Person("kalle anka", 23, 235235235, "070-624342");
		Person p2 = new Person("Janne ankas", 55, 2335235, "070-724342");
		Person p3 = new Person("Yalle anka", 23, 2235235, "070-45724342");
		Person p4 = new Person("jalle anka", 23, 1235235, "070-457342");
		Person p5 = new Person("Joakim Won Anka", 23, 72345235, "07-24342");
		Person p6 = new Person("dalle anka", 23, 235425235, "070-24256342");
		Person p7 = new Person("Janne ankas", 55, 72335235, "070-89324342");
		Person p8 = new Person("ealle anka", 23, 52235235, "070-1724342");
		Person p9 = new Person("Talle anka", 23, 81235235, "070-24367862");
		Person p10 = new Person("Joakim Won Anka", 23, 72345235,
				"0790-4624342");

		Person.rubrik();
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		p5.print();
		p6.print();
		p7.print();
		p8.print();
		p9.print();
		p10.print();
		System.out.println();
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		c1.printName(3);
		Ort o = new Ort("Lund", "Sala", "Star Night", "Kulle", "Bakom hörnet",
				556);
		Ort o2 = new Ort("Bo", "la", "Night", "Någonstans", "Andra hörnet",
				2556);
		Ort o3 = new Ort("Ba", "Sa", "Star", "Berg", "Femte hörnet", 65536);

		o.printF();
		o2.printF();
		o3.printF();
		System.out.println(
				"________________________________________________________________________________________________________________________________");

		c1.concatStrings("Kalle,", "Anka,");
		c1.concatStrings("Kalle,", "Anka,", "Heter,");
		c1.concatStrings("Kalle,", "Anka,", "Heter,", "Jag");
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		c1.stringToIntAddition("52", "3", "42");
		System.out.println(
				"________________________________________________________________________________________________________________________________");

		System.out.println(c1.concat(new String[]{"Pelle", "234-26463", "23"}));
		System.out.println(
				"________________________________________________________________________________________________________________________________");
		String[] arr = c1.stringToArray(
				c1.concat(new String[]{"Pelle", "234-26463", "23"}));
		String returNamn = arr[0];
		String returTel = arr[1];
		int returAge = Integer.parseInt(arr[2]);
		System.out.println("returNamn: " + returNamn + " returnTel: " + returTel
				+ " returAge: " + returAge);	

	}
	public String[] stringToArray(String s) {
		return s.split(",");
	}
	public String concat(String[] s) {
		String tmp = "";
		for (int i = 0; i < s.length; i++) {
			if (i != s.length - 1) {
				tmp += s[i] + ",";
			} else {
				tmp += s[i];
			}
		}
		return tmp;
	}
	public void stringToIntAddition(String a, String b, String c) {
		if (a.matches("[0-9]+") && b.matches("[0-9]+") && c.matches("[0-9]+")) {
			System.out.println("a:" + a + "+b:" + b + "+c:" + c + "="
					+ (Integer.parseInt(a) + Integer.parseInt(b)
							+ Integer.parseInt(c)));
		} else {
			System.out.println("Not a Number!");
		}

	}

	public void concatStrings(String a, String b) {
		System.out.println("2 Strings: " + a + b);
	}
	public void concatStrings(String a, String b, String c) {
		System.out.println("3 Strings: " + a + b + c);
	}
	public void concatStrings(String a, String b, String c, String d) {
		System.out.println("4 Strings: " + a + b + c + d);
	}
	public void printName(int a) {
		String[] s = new String[]{"Pelle", "KAlle", "Fabian", "sara", "mira",
				"amanda"};
		if (0 <= a && a < 6) {
			System.out.println("Name: " + s[a]);
		}

	}
	public void getType(String type) {

		System.out.println("String: " + type);
	}

	public void getType(int type) {

		System.out.println("Int: " + type);
	}

	public void getType(float type) {

		System.out.println("Float: " + type);
	}

	public void getType(long type) {

		System.out.println("Long: " + type);
	}

	public void getType(double type) {

		System.out.println("Double: " + type);
	}

	public void divideByTwo(double a) {

		System.out.println("Divide " + a + " by two: " + (a / 2));

	}

	public void plus(long a, long b) {

		System.out.println("a:" + a + " + b:" + b + " = " + (a + b));
	}

	public void plus(double a, double b) {

		System.out.println("a:" + a + " + b:" + b + " = " + (a + b));
	}


	public void mean(ArrayList<Long> l, ArrayList<Double> d) {
		double dd = 0;
		double sum = 0;
			
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
			sum += l.get(i);
		}
		for (int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i));
			sum += d.get(i);
		}
		double length = l.size() + d.size();
		dd = sum / length;
		System.out.println("Medelvärdet: " + dd);

	}

}
