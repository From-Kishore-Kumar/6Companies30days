//https://leetcode.com/problems/random-pick-with-weight/
//leetcode problem 528
import java.util.*;
class RandomPickWithWeight {
    private int[] indexes;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        int sum = 0;

        for (int num : w) {
            sum += num;
        }

        double[] weight = new double[w.length];

        for (int i = 0; i < weight.length; i++) {
            weight[i] = w[i] * 1.0 / sum;
        }

        indexes = new int[1001];
        random = new Random();

        int index = 0;

        for (int i = 0; i < weight.length; i++) {
            double num = weight[i] * 1000;
            for (int j = 0; j < num; j++) {
                indexes[index + j] = i;
            }

            index += num;
        }

    }
    
    public int pickIndex() {
        return indexes[random.nextInt(1001)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */