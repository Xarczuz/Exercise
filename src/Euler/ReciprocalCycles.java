package Euler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReciprocalCycles {

	public static void main(String[] args) {

		int max = 0;
		String maxC = "";
		int index = 0;
		for (int i = 7; i <= 1000; i++) {
			BigDecimal a = new BigDecimal("1.0");
			BigDecimal b = new BigDecimal("" + i);

			String s = a.divide(b, 2000, RoundingMode.HALF_EVEN)
					.stripTrailingZeros().toString().substring(2);
			while (s.startsWith("0")) {
				s = s.substring(1);
			}
			String cycle = "";
		
			for (int j = 10; j < s.length()-1;j++) {
				if (s.length() > 1+j+cycle.length()) {
					String tmp = s.substring(j , j+1);
					cycle+= tmp;
					String tmp2 = s.substring(j+1,j+1+cycle.length());
					if(cycle.equals(tmp2)) {
						break;
					}
				}
			}
			if (cycle.length() > max) {
				maxC = cycle;
				max = cycle.length();
				index = i;
				System.out.println(
						"Cycle: " + maxC + " length:" + max + " Index:" + index);
			}
		}
		
	}

}
