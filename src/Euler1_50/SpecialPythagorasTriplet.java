package Euler1_50;

public class SpecialPythagorasTriplet {

	public static void main(String[] args) {
		abc(1000);
	}

	public static void abc(int n) {
		int a, b, c;
		for (a = 1; a < n; a++) {
			for (b = 1; b < n; b++) {
				for (c = 1; c < n; c++) {
					if ((a + b + c) == 1000 && (Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)) {
						System.out.println("a: " + a + " b:" + b + " c:" + c);
						System.out.println("produc of abc: " + a * b * c);
						return;
					}
				}
			}
		}

	}
}
