package LeetCode_Medium;

import java.util.HashMap;

public class LeetCode_1357_ApplyDiscountEverynOrders {

    static class Cashier {

        private final int n;
        private final double discount;
        private final HashMap<Integer, Integer> productsMap;
        int counter;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = (100d - discount) / 100;
            HashMap<Integer, Integer> productsMap = new HashMap<>();
            for (int i = 0; i < products.length; i++) {
                productsMap.put(products[i], prices[i]);
            }
            this.productsMap = productsMap;
            this.counter = 0;
        }

        public double getBill(int[] product, int[] amount) {
            counter++;
            int sum = 0;
            int length = product.length;
            for (int i = 0; i < length; i++) {
                sum += productsMap.get(product[i]) * amount[i];
            }
            System.out.println((counter % 3 == 0) ? sum * discount : sum);
            return counter % n == 0 ? sum * discount : sum;
        }

    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        cashier.getBill(new int[]{1, 2}, new int[]{1, 2});                        // return 500.0, bill = 1 * 100 + 2 * 200 = 500.
        cashier.getBill(new int[]{3, 7}, new int[]{10, 10});                      // return 4000.0}
        cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1});    // return 800.0, The bill was 1600.0 but as this is the third customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
        cashier.getBill(new int[]{4}, new int[]{10});                           // return 4000.0
        cashier.getBill(new int[]{7, 3}, new int[]{10, 10});                      // return 4000.0
        cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}); // return 7350.0, Bill was 14700.0 but as the system counted three more customers, he will have a 50% discount and the bill becomes 7350.0
        cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2});                    // return 2500.0

    }
}
