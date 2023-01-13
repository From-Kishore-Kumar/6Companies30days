//https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
//leetcode problem 600

class Non_negativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        if (num < 2) {
            return num + 1;
        }
        
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int k = sb.length();
        
        // fill f array
        int[] f = new int[k];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < k; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        // check all bits of num
        int rst = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                rst += f[i];
                if (i < k - 1 && sb.charAt(i + 1) == '1') { // sb.charAt(i + 1) represents the prev_bits
                    return rst;
                }
            }
        }
        return rst + 1;
    }
}
