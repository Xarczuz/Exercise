package Euler;

public class Fibo {

	public static void main(String[] args) {
		fibonacci(200);
	}

	public static void fibonacci(int number) {
		int a = 1;
		int b = 0;
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		for (int i = 0; i < number; i++) {
			int nr = a + b;
			if (nr > 4000000) {
				break;
			}
			if (nr % 2 == 0) {
				total1 += nr;
				System.out.println("Even number: " + nr);
			} else {
				total2 += nr;
				System.out.println("Odd number: " + nr);
			}
			total3 += nr;
			b = a;
			a = nr;
		}
		System.out.println("The sum of all even number below 4mil: " + total1);
		System.out.println("The sum of all odd number below 4mil: " + total2);
		System.out.println("The sum of all number below 4mil: " + total3);
	}
	
	
	
}
