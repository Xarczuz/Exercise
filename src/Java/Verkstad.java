package Java;

public class Verkstad {

	public static void main(String[] args) {
		Cars b1 = new Cars("Volvo", "X999", 2111);
		Cars b2 = new Cars("TESLA", "X99", 2112);
		Cars b3 = new Cars("OPEL", "X129", 2116);
		

		System.out.println(b1.getcarName() +" "+ b1.getModel() +" "+ b1.getYear());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
	}

}
