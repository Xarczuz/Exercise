package Java;

public class NestedClasses4 {

	public static void main(String[] args) {

		Ano a = new Ano() {
			String test = "Ano class";
			public void print() {
				System.out.println(test);
			}
		};
		a.print();

		myInterface inter = new myInterface() {
			public void print() {
				System.out.println("from interface");
			}
		};
		inter.print();
	}

}
class Ano {
	public void print() {
		System.out.println("BLABALFG");
	}
}
interface myInterface {
	public void print();
}