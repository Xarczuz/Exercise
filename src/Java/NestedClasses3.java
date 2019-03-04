package Java;

public class NestedClasses3 {
	String text = "TEST YTTRE!";
	public static void main(String[] args) {
		NestedClasses3 yttre = new NestedClasses3();
		NestedClasses3.inreKlass inre = yttre.new inreKlass();
		
		inre.print();
	}
	public void print() {
		System.out.println(text);
	}
	class inreKlass extends NestedClasses3 {
		String text = "Test Inre!";
		public void print() {
			super.print();
			System.out.println(NestedClasses3.this.text);
			System.out.println(text);
		}
	}
}

