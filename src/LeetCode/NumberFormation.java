package LeetCode;

public class NumberFormation {

    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int z = 1;
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    sum += fun(i, j, k);
                }
            }

        }
        System.out.println(sum);
    }

    private static int fun(int x, int y, int z) {
        int A = 10 * fun(x - 1, y, z) + 4 * g(x - 1, y, z);
        int B = 10 * fun(x, y - 1, z) + 5 * g(x, y - 1, z);
        int C = 10 * fun(x, y, z - 1) + 6 * g(x, y, z - 1);

        return A + B + C;
    }

    private static int g(int x, int y, int z) {
        return x * 4 + y * 5 + z * 6;
    }
}
