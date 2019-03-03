package Euler1to50;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * Consecutive prime sum Problem 50 The prime 41, can be written as the sum of
 * six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * 
 * @author Chjun-chi
 *
 */
public class ConsecutivePrimeSum {

	public static void main(String[] args) {
		HashSet<Integer> primes = new HashSet<>();
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < 1000000; i++) {
			if (checkPrime(i)) {
				primes.add(i);
				primeList.add(i);
			}
		}
		
		int target=1000000;
		int k=0;
		int lastPrime=0;
		int maxConsecutive = 0;
		while (k<primeList.size()) {
			
		int consecutive=0;
		int sum =0;
		for (int i = k; i < primeList.size(); i++) {
			sum=sum+primeList.get(i);
			consecutive++;
			if (checkPrime(sum)&&sum<=target&&consecutive>maxConsecutive) {
				lastPrime=sum;
				maxConsecutive = consecutive;
			}
			if(sum>=target) {
				break;
			}
			
		}
		k++;
		}
		System.out.println(checkPrime(lastPrime));
		System.out.println("The prime we are looking for: "+ lastPrime);
	}
	public static boolean checkPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if ((n & 1) == 0 || n % 3 == 0)
			return false;
		int limit = (int) (Math.sqrt(n) + 1);
		for (int i = 5, w = 2; i < limit; i += w, w = 6 - w) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
