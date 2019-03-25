package Euler50to100;

import java.math.BigInteger;

public class SquareRootConvergents {

	public static void main(String[] args) {

		String s1 = "1+";

		String s2 = "1/(2+";

		String s3 = "1/2";

		String s4 = ")";

		int num=0;
		for (int j = 1; j <= 1000; j++) {
			String frac="";
			frac +=s1;
			for (int i = 1; i <j; i++) {
				frac+=s2;
			}
			frac+=s3;
			if(fraction(frac)) {
				num++;
			}
		}
		System.out.println("num: "+ num);
		
		// C +A/B
		// (C*B + A)/B
		// 1+1/2 = 3/2
		// (2*1+1)/2 = a=3 / b=2	

	}
	public static boolean fraction(String frac) {
		int i = frac.length() - 1;
		String b = frac.substring(i, i + 1);
		i -= 2;
		String a = frac.substring(i, i + 1);
		i -= 2;
		String c = frac.substring(i, i + 1);
		
		BigInteger tmpa = new BigInteger(a);
		BigInteger tmpb = new BigInteger(b);
		BigInteger tmpc = new BigInteger(c);
		String f = tmpc.multiply(tmpb).add(tmpa).toString();
		String tmp = "";
		boolean para = false;
		for (; 0 <= i; i--) {
			tmp = frac.substring(i, i + 1);
			if (tmp.contentEquals("(")) {
				para = true;
			}
			if (para && tmp.contentEquals("/")) {
				a = b;
				b = f;
				 tmpa = new BigInteger(a);
				 tmpb = new BigInteger(b);
				 tmpc = new BigInteger(c);
				 f = tmpc.multiply(tmpb).add(tmpa).toString();
				para = false;
			}
			if (i == 0) {
				break;
			}
		}
		c = "1";
		 tmpa = new BigInteger(a);
		 tmpb = new BigInteger(b);
		 tmpc = new BigInteger(c);
		 f = tmpc.multiply(tmpb).add(tmpa).toString();
//		System.out.println(f + "/" + b);
		if (f.length()>b.length()) {
			return true;
		}else {
			return false;
		}
			
	}
}
