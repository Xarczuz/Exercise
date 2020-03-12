package LeetCode_Easy;

public class LeetCode_476_NumberComplement {
    /*
    * Let's say the input is num = 5 = 101 in binary
      Our mask needs to be 111 and then we will perform a XOR operation.
    * The XOR operation says return TRUE (1) only if one of the bits is true,
    * else return FALSE (0). This means that when we XOR a 1 and a 1 bit, we will get 0.
    * If we XOR a 1 and 0 bit, we will get 1. Thus effectively flipping the bits.
      The way we get the mask to be 111 is to first get the DECIMAL
    * VALUE OF THE FURTHER LEFT BIT of num, so in this case the furthest left bit of num represents 4.
    * In binary this is 100. We do a single left shift, thus we get 1000 which is 8 in decimal.
    *  Then we subtract 1 to get 7 in decimal, or 111.
    * This is the mask value we need to XOR to our original input num.
    * */
    public int findComplement(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
