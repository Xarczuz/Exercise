package Java;

public class NestedClasses2 {

	public static void main(String[] args) {
		NestedClasses2 yttre = new NestedClasses2();
		NestedClasses2.inre inre = yttre.new inre();
		
		inre.print();
	}
	public class inre {
		public void print() {
			System.out.println("inre klass");
		}
	}
}
