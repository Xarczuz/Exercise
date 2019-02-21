package Euler;

public class DigitFifthPowers {

	public static void main(String[] args) {
		double sum = 0;
		int totalSum = 0;
		int index = 2;
		while (true) {
			String s = ""+index;
			for (int i = 0; i < s.length(); i++) {
				String tmp = s.substring(i, i + 1);
				sum += Math.pow(Double.parseDouble(tmp), 5);
			}
			if (sum == index) {
				System.out.println("sum: " + sum);
				totalSum += sum;
			}
			if(index>10000000) {
				break;
			}
			sum=0;
			index++;
			
		}
		System.out.println("total sum: " + totalSum);
	}
	public static void name() {

	}

}
