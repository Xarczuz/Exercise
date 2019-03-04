package Java;

public class NestedClasses1 {

	public static void main(String[] args) {
		NestedClasses1.inre inre = new NestedClasses1.inre();

		inre.print();
		
	}
public static class inre{
	public  void print(){
		System.out.println("Inre klass!");
	}
}
}
