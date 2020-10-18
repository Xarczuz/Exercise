package CodingGame.Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class temperatures {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            tempArr.add(t);
        }
        if (tempArr.size() == 0) {
            System.out.println(0);
            return;
        }
        int closes = 0;
        int min = Integer.MAX_VALUE;

        for (int t : tempArr) {
            int tAbs = Math.abs(t);
            int cAbs = Math.abs(closes);
            if (tAbs == cAbs) {
                if (t > closes) {
                    closes = t;
                }
            } else if (tAbs < min) {
                closes = t;
                min = tAbs;
            }
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        System.out.println(closes);
    }

}
