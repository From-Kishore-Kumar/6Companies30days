package Amazon;
//https://leetcode.com/problems/maximum-subarray-min-product/
//leetcode problem 1856

class Solution {
    public int maxSumMinProduct(int[] nums) {

        int mod = 1000000007;
        long ans = 0;
        int N = nums.length;
        long[] sum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[] stack = new int[N];
        int si = -1;
        for (int i = 0; i < N; i++) {
            while (si != -1 && nums[stack[si]] > nums[i]) {
                int idx = stack[si--];
                int L = si == -1 ? 0 : stack[si] + 1;
                int R = i - 1;
                ans = Math.max(ans, nums[idx] * (sum[R + 1] - sum[L]));
            }
            stack[++si] = i;

        }
        while (si >= 0) {
            int idx = stack[si--];
            int L = si == -1 ? 0 : stack[si] + 1;
            int R = N - 1;
            ans = Math.max(ans, nums[idx] * (sum[R + 1] - sum[L]));
        }
        ans %= mod;
        return (int) ans;
    }
}