package Euler1to50;

import java.util.HashSet;

/**
 * The Class CoinSums.
 * 
 * Coin sums Problem 31 In England the currency is made up of pound, �, and
 * pence, p, and there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, �1 (100p) and �2 (200p). It is possible to make �2
 * in the following way:
 * 
 * 1ף1 + 1�50p + 2�20p + 1�5p + 1�2p + 3�1p How many different ways can �2 be
 * made using any number of coins?
 */
public class CoinSums {

	final int POUND_TRAGET = 200;
	HashSet<Permutation> perm = new HashSet<Permutation>();
	int[] money = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
	HashSet<Permutation> paths = new HashSet<Permutation>();

	/**
     * The java.main method.
     *
     * @param args the arguments
     */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		CoinSums s = new CoinSums();
		s.permutations(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0);

		System.out.println("size: " + s.perm.size());
		System.out.println(
				"time taken:" + (System.currentTimeMillis() - start) / 1000);
	}

	public void permutations(int[] p, int sum) {
		
		sum = 0;
		for (int i = 0; i < p.length; i++) {
			sum += p[i] * money[i];
		}
		if (sum > POUND_TRAGET) {
			return;
		}
		if (POUND_TRAGET == sum) {
			perm.add(new Permutation(p[0], p[1], p[2], p[3], p[4], p[5], p[6],
					p[7]));
			return;
		}

		Permutation path = new Permutation(p[0], p[1], p[2], p[3], p[4], p[5],
				p[6], p[7]);
		
		if (paths.contains(path)) {
			return;
		}
		
		paths.add(path);
		permutations(
				new int[]{p[0] + 1, p[1], p[2], p[3], p[4], p[5], p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1] + 1, p[2], p[3], p[4], p[5], p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2] + 1, p[3], p[4], p[5], p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2], p[3] + 1, p[4], p[5], p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2], p[3], p[4] + 1, p[5], p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2], p[3], p[4], p[5] + 1, p[6], p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2], p[3], p[4], p[5], p[6] + 1, p[7]},
				sum);
		permutations(
				new int[]{p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7] + 1},
				sum);

	}
}

class Permutation {
	int p1, p2, p5, p10, p20, p50, p100, p200;

	public Permutation(int p1, int p2, int p5, int p10, int p20, int p50,
			int p100, int p200) {
		this.p1 = p1;
		this.p2 = p2;
		this.p5 = p5;
		this.p10 = p10;
		this.p20 = p20;
		this.p50 = p50;
		this.p100 = p100;
		this.p200 = p200;
	}

	@Override
	public String toString() {
		return "Permutation [p1=" + p1 + ", p2=" + p2 + ", p5=" + p5 + ", p10="
				+ p10 + ", p20=" + p20 + ", p50=" + p50 + ", p100=" + p100
				+ ", p200=" + p200 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + p1;
		result = prime * result + p10;
		result = prime * result + p100;
		result = prime * result + p2;
		result = prime * result + p20;
		result = prime * result + p200;
		result = prime * result + p5;
		result = prime * result + p50;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permutation other = (Permutation) obj;
		if (p1 != other.p1)
			return false;
		if (p10 != other.p10)
			return false;
		if (p100 != other.p100)
			return false;
		if (p2 != other.p2)
			return false;
		if (p20 != other.p20)
			return false;
		if (p200 != other.p200)
			return false;
		if (p5 != other.p5)
			return false;
		if (p50 != other.p50)
			return false;
		return true;
	}

}
