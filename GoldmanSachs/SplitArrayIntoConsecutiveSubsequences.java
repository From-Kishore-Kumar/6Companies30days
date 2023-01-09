//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
//leetcode problem 659
package GoldmanSachs;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if(nums.length < 3) return false;
        int prev = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
        int cur = 0, c1 = 0, c2 = 0, c3 = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = 1;
            while(i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
                count++;
            }
            cur = nums[i];
            if(prev + 1 < cur) {
                if(p1 + p2 > 0) return false;
                c1 = count;
                c2 = 0;
                c3 = 0;
            }else {
                if(count < p1 + p2) return false;
                c1 = count - p1 - p2 - p3 > 0? count - p1 - p2 - p3 : 0;
                c2 = p1;
                c3 = p2 + Math.min(p3, count - (p1 + p2));
            }
            prev = cur;
            p1 = c1;
            p2 = c2;
            p3 = c3;
        }
        return p1 + p2  == 0;
    }
}
