package Misc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TwoPrimes {
    HashMap<Integer, Integer> primes;

    public TwoPrimes(int i) {
        primes = new HashMap<>();
        for (int j = 2; j < i; j++) {
            if (checkPrime(j)) {
                primes.put(j, j);
            }
        }
    }

    public String returnTwoPrimesFromEvenNumber(int i) {
        if (i == 2) {
            return "";
        }
        int prime = 2;
        while (prime < 10000) {
            if (!primes.containsKey(prime)) {
                prime++;
                continue;
            }
            int bigPrime = i - prime;
            if (primes.containsKey(bigPrime)) {
                return prime + " " + bigPrime;
            }
            prime++;
        }
        return "";
    }

    public boolean checkPrime(long n) {
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

    public static void main(String[] args) throws IOException {
        TwoPrimes twoPrimes = new TwoPrimes(10000);
        BufferedInputStream scan = new BufferedInputStream((System.in));
        BufferedReader r = new BufferedReader(
                new InputStreamReader(scan, StandardCharsets.UTF_8));
        int ints = Integer.parseInt(r.readLine());
        for (int i = 0; i < ints; i++) {
            twoPrimes.returnTwoPrimesFromEvenNumber(Integer.parseInt(r.readLine()));
        }
    }
}
