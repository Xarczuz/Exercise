package Euler1_50;
import java.util.ArrayList;

public class MultiplesOf {

	public static void main(String[] args) {
		System.out.println(multiples(1000));
		System.out.println(m());
	}

	public static int multiples(int number) {
		int a = 3;
		int b = 5;
		int c = a * b;
		int total = 0;
		total = multiOf(number, a) + multiOf(number, b) - multiOf(number, c);
		return total;
	}

	public static int multiOf(int num, int a) {
		int idx = 1;
		int total = 0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		int s = 0;
		while (true) {
			total = a * idx;
			if (total < num) {
				x.add(total);
				s += total;
				idx++;
			} else {
				break;
			}
		}

		System.out.println(x.toString());
		int tot = 0;
		for (int i = 0; i < x.size(); i++) {
			tot += x.get(i);
		}

		System.out.println(tot);
		return s;
	}

	private static int m() {
		int i, count = 0;
		for (i = 3; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				count += i;
		}
		return count;
	}
}
