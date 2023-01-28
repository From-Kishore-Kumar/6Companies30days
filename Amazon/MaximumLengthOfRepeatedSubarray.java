package Amazon;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//leetcode problem 718

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums1.length+1][nums2.length+1];//dp[i][j] => max length of substr ending in (nums1[i], nums2[j])
        int max = 0;
        
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}
