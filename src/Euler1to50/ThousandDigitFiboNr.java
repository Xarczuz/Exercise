package Euler1to50;

import java.math.BigInteger;

public class ThousandDigitFiboNr {

	public static void main(String[] args) {
		fibonacci(1000);

	}
	public static void fibonacci(int number) {

		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("0");
		BigInteger nr = new BigInteger("0");
		System.out.println("index: " + 1 + " nr:" + 1 + " length:" + 1);

		for (int i = 1; nr.toString().length() < number; i++) {
			nr = a.add(b);
			b = a;
			a = nr;
			System.out.println("index: " + (i + 1) + " nr:" + nr + " length:"
					+ nr.toString().length());

		}

	}

}
