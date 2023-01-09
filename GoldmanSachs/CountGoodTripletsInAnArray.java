//https://leetcode.com/problems/count-good-triplets-in-an-array/
//leetcode problem 2179
package GoldmanSachs;

public class CountGoodTripletsInAnArray {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] bit = new int[n + 1], pos = new int[n];
        for (int i = 0; i < n; ++i) pos[nums1[i]] = i;
        long res = 0;
        for (int i = 0; i < n; ++i) {
            int smaller = get(bit, pos[nums2[i]] + 1);
            int greater = (n - pos[nums2[i]] - 1) - (i - smaller);
            res += smaller * (long) greater;
            add(bit, pos[nums2[i]] + 1);
        }
        return res;
    }
    private int get(int[] bit, int i) {
        int res = 0;
        for (; 0 < i; i -= i & -i) res += bit[i];
        return res;
    }
    private void add(int[] bit, int i) {
        for (; i < bit.length; i += i & -i) bit[i]++;
    }
}
