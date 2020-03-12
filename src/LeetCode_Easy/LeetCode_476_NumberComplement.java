package LeetCode_Easy;

public class LeetCode_476_NumberComplement {
    public int findComplement(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
