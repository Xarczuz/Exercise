package Misc;

public class permutaions {
    public static void main(String[] args) {
        int[] hour = new int[]{1, 2, 4, 8};

        int[] min = new int[]{1, 2, 4, 8, 16, 32};

        printAllRecursive(hour.length, hour);
    }

    public static void printAllRecursive(int n, int[] elements) {

        if (n == 1) {
            printArray(elements);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void printArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }
}
