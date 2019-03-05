package Java;
interface Matte {
	int operation(int... a);
}
interface MatteS {
	String operation(String... a);
}

interface MatteMulti {
	String operation(int... a);
}
interface MatteString {
	String operation(int a,String s1 ,String s2);
}
// Funktionellt Interface
interface Hälsning {
	void ettMeddelande(String meddelande);
}

public class LambdaIntroduktion {

	public static void main(String[] args) {
		// // Matte och Sträng lambda rutiner
		// // Med typ deklaratin
		// Matte pluss = (int a, int b) -> a + b;
		// // Utan typ deklaratin
		// Matte minus = (a, b) -> a - b;
		// // Med rutur värde och måsvinge parentes
		// Matte multi = (int a, int b) -> {
		// return a * b;
		// };
		// // Med rutur värde och utan måsvinge parentes
		// Matte div = (int a, int b) -> a / b;
		// System.out.println("Pluss = " + pluss.operation(6, 8));
		// System.out.println("Minus = " + minus.operation(15, 6));
		// System.out.println("Multi = " + multi.operation(5, 8));
		// System.out.println("Divition = " + div.operation(24, 4));
		// // Utan parentes
		// Hälsning meddelande1 = meddelande -> System.out
		// .println("Ett meddelande: " + meddelande);
		// // Med parentes
		// Hälsning meddelande2 = (meddelande) -> System.out
		// .println("Hej igen " + meddelande);
		// meddelande1.ettMeddelande("Hej hopp i det gröna");
		// meddelande2.ettMeddelande("Ett meddelande till alla");

		Matte square = (int[]a) -> a[0] * a[0];
		System.out.println(square.operation(3));

		Matte pluss = (int[]a) -> a[0] + a[1] + a[2];
		System.out.println(pluss.operation(1,1,3, 5, 4));

		MatteMulti multi =(int[]a )->String.valueOf(a[0]) +"*"+ String.valueOf(a[1])+"="+ (a[0]*a[1]);		
		System.out.println(multi.operation(7,34));
		
		MatteS concatString = (String[]s)->s[0]+" "+s[1];
		System.out.println(concatString.operation("hej","på dig"));
		
		MatteString s =(a,b,c)->a+b+c;
		System.out.println(s.operation(32,"ef","af"));
		
		
}
}
