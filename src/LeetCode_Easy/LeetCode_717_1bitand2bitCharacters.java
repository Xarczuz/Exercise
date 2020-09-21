package LeetCode_Easy;

public class LeetCode_717_1bitand2bitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length - 1] == 1) {
            return false;
        }

        for (int i = 0; i < bits.length - 1; i++) {

            if (bits[i] == 0) {
                continue;
            }
            if (bits[i] == 1) {
                if (i + 1 != bits.length - 1) {
                    i++;
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
