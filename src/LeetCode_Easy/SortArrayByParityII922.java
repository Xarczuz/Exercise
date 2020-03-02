package LeetCode_Easy;

import java.util.Stack;

public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();
        for (int n : A) {
            if (n % 2 == 0) {
                even.push(n);
            } else {
                odd.push(n);
            }
        }
        boolean flip = true;
        for (int i = 0; i < B.length; i++) {
            if (flip) {
                B[i] = even.pop();
                flip = false;
            } else {
                B[i] = odd.pop();
                flip = true;
            }
        }

        return B;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int[] B = new int[A.length];

        int pointerEven = 0;
        int pointerOdd = 0;

        for (int i = 0; i < B.length; i++) {
            if (i % 2 == 0) {
                for (; pointerEven < A.length; pointerEven++) {
                    if (A[pointerEven] % 2 == 0) {
                        break;
                    }
                }
                B[i] = A[pointerEven];
                pointerEven++;
            } else {
                for (; pointerOdd < A.length; pointerOdd++) {
                    if (A[pointerOdd] % 2 != 0) {
                        break;
                    }
                }
                B[i] = A[pointerOdd];
                pointerOdd++;
            }
        }

        return B;
    }
}
