//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//leetcode problem 581
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len=nums.length;
        int max=nums[0];
        int min=nums[len-1];

        int left=0,right=-1;
        for (int i = 0; i < len; i++) {
            
            if (max>nums[i]){
                right=i;
            }else {
                max=nums[i];
            }

            //寻找左边界
            if (min<nums[len-1-i]){
                left=len-1-i;
            }else {
                min=nums[len-1-i];
            }
        }
        return right-left+1;

    }
}
