package Euler50to100;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 59
 * 
 * An extract taken from the introduction of one of Euler's most celebrated
 * papers, "De summis serierum reciprocarum" [On the sums of series of
 * reciprocals]: I have recently found, quite unexpectedly, an elegant
 * expression for the entire sum of this series 1 + 1/4 + 1/9 + 1/16 + etc.,
 * which depends on the quadrature of the circle, so that if the true sum of
 * this series is obtained, from it at once the quadrature of the circle
 * follows. Namely, I have found that the sum of this series is a sixth part of
 * the square of the perimeter of the circle whose diameter is 1; or by putting
 * the sum of this series equal to s, it has the ratio sqrt(6) multiplied by s
 * to 1 of the perimeter to the diameter. I will soon show that the sum of this
 * series to be approximately 1.644934066842264364; and from multiplying this
 * number by six, and then taking the square root, the number
 * 3.141592653589793238 is indeed produced, which expresses the perimeter of a
 * circle whose diameter is 1. Following again the same steps by which I had
 * arrived at this sum, I have discovered that the sum of the series 1 + 1/16 +
 * 1/81 + 1/256 + 1/625 + etc. also depends on the quadrature of the circle.
 * Namely, the sum of this multiplied by 90 gives the biquadrate (fourth power)
 * of the circumference of the perimeter of a circle whose diameter is 1. And by
 * similar reasoning I have likewise been able to determine the sums of the
 * subsequent series in which the exponents are even numbers.
 * 
 * @author chjunchi
 */
public class XORDecryption {

	public static void main(String[] args) throws IOException {

		int[] crypt = readFile();

	String msg=	start(crypt);

	int sum =0;
	for (int i = 0; i < msg.length(); i++) {
		sum += (int)msg.charAt(i);
	}
	System.out.println("Total msg AScii sum: " + sum);
	}
	public static String start(int[] crypt) throws IOException {

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 97; i <= 122; i++) {
			arr.add(i);
		}
		int key = 0;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				for (int k = 0; k < arr.size(); k++) {
					boolean word = true;
					int key1 = arr.get(i);
					int key2 = arr.get(j);
					int key3 = arr.get(k);
					int[] g = new int[]{key1, key2, key3};

					int d = 0;
					for (Integer s : crypt) {
						key = g[d % g.length];
						int ascii = s ^ key;
						String t = String.valueOf((char) ascii);
						if (!t.matches("[a-zA-Z0-9,.!'^()?\\*\"#¤%&/=+-_ ]*")) {
							word = false;
							break;

						}
						d++;
					}

					if (word) {

						d = 0;
						StringBuilder sb= new StringBuilder();
						for (Integer s : crypt) {
							key = g[d % g.length];
							int ascii = s ^ key;
							char w = (char) ascii;
							String t = String.valueOf(w);
							sb.append(t);
							d++;
						}
						
						return sb.toString();
					}

				}
			}
		}
		return "";
	}
	public static int[] readFile() throws IOException {
		List<String> fileArr = null;
		fileArr = Files.readAllLines(Paths.get("files/p059_cipher.txt"),
				Charset.forName("UTF-8"));
		String[] q = fileArr.get(0).split(",");
		int[] s = new int[q.length];
		int i = 0;
		for (String string : q) {
			s[i] = Integer.parseInt(string);
			i++;
		}
		return s;

	}
}
