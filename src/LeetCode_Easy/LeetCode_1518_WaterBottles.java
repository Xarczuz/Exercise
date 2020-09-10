package LeetCode_Easy;

public class LeetCode_1518_WaterBottles {
    static public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            int tempEmpty = emptyBottles / numExchange;
            numBottles += tempEmpty;
            emptyBottles = (emptyBottles % numExchange);
            emptyBottles += tempEmpty;
        }
        return numBottles;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(5, 5));
        System.out.println(numWaterBottles(2, 3));
    }
}
