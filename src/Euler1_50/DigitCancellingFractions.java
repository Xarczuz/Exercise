package Euler1_50;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Chjun-chi
 *
 *
 * @ Digit cancelling fractions Problem 33 The fraction 49/98 is a curious
 * fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by
 * cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 * 
 * 
 */
public class DigitCancellingFractions {

	public static void main(String[] args) {
		ArrayList<String[]> arr = new ArrayList<>();
		for (float i = 11; i < 99; i++) {
			for (float j = 11; j < 99; j++) {
				if(i%10!=0 && j%10!=0 && j!=i) {
					String a = i+"";
					String b = j+"";
					String[] aa = new String[]{a.substring(0, 1),a.substring(1, 2)};
					String[] bb = new String[]{b.substring(0, 1),b.substring(1, 2)};
					float fraction =  (i/j);
					if(aa[0].equals(bb[0])) {
					float d=Float.parseFloat(aa[1])/Float.parseFloat(bb[1]);
			
					if(d==fraction) {
						arr.add(new String[]{aa[1],bb[1]});
					}
					}else if(aa[1].equals(bb[0])) {
						Float d=Float.parseFloat(aa[0])/Float.parseFloat(bb[1]);
						
						if(d==fraction) {
							arr.add(new String[]{aa[0],bb[1]});
						}		
					}	
				}
			}
		}
		for (String[] strings : arr) {
			
			System.out.println(Arrays.asList(strings));
		}
	}
}
