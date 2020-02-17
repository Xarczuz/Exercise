package Java;

import java.util.ArrayList;
import java.util.Comparator;

//import java.util.Collections;

/**
 * The Class CollectionSort.
 */
public class CollectionSort {

    /**
     * The java.main method.
     *
     * @param args the arguments
     */
	public static void main(String[] args) {
		ArrayList<People> p = new ArrayList<People>();
		p.add(new People("Nils", 21, "053-322355", "AungsGatan 4",
				"Stockholm"));
		p.add(new People("Karl", 12, "050-92235", "KungsGatan 44", "Falun"));
		p.add(new People("Grham", 421, "050-142235", "CungsGatan 4", "Malmö"));
		p.add(new People("Sara", 319, "10-3578235", "LungsGatan 45", "Bor"));
		p.add(new People("Sofia", 41, "15-7922635", "NungsGatan 4", "Bor"));
		p.add(new People("Pelle", 61, "250-42235", "GungsGatan 4", "Kor"));
		p.add(new People("Fabian", 21, "450-5832235", "BungsGatan 43", "Dhor"));
		p.add(new People("Anna", 321, "150-3235235", "BungsGatan 9", "Bor"));

		// Collections.sort(p);
		// Collections.sort(p, new SortName());
//		Collections.sort(p, new SortStad());
		// Collections.sort(p, new SortAdress());
		// Collections.sort(p, new SortTelefon());
		p.sort((People p1, People p2)->p1.namn.compareTo(p2.namn));

		System.out.println("Namn:    ålder:   Tele:      Adress:       Stad:");
		for (People people : p)
			people.print();

	}
}
class People implements Comparable<People> {

	protected String namn, tel, adress, stad;
	protected int ålder;

	/**
	 * Instantiates a new people.
	 *
	 * @param namn
	 *            the namn
	 * @param ålder
	 *            the ålder
	 * @param tel
	 *            the tel
	 * @param adress
	 *            the adress
	 * @param stad
	 *            the stad
	 */
	public People(String namn, int ålder, String tel, String adress,
			String stad) {
		this.namn = namn;
		this.ålder = ålder;
		this.tel = tel;
		this.adress = adress;
		this.stad = stad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(People arg0) {
		return this.ålder - arg0.ålder;
	}

	/**
	 * Prints the OBJECT.
	 */
	public void print() {
		System.out.printf("%-10s %3d %-13s %-14s %-10s\n", namn, ålder, tel,
				adress, stad);
	}
	@Override
	public String toString() {
		return "People [namn=" + namn + ", tel=" + tel + ", adress=" + adress
				+ ", stad=" + stad + ", ålder=" + ålder + "]";
	}

}
class SortName implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		return o1.namn.toLowerCase().compareTo(o2.namn.toLowerCase());
	}

}
class SortAdress implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		return o1.adress.toLowerCase().compareTo(o2.adress.toLowerCase());
	}

}
class SortStad implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		return o1.stad.toLowerCase().compareTo(o2.stad.toLowerCase());
	}

}
class SortTelefon implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		return o1.tel.toLowerCase().compareTo(o2.tel.toLowerCase());
	}

}