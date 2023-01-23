//https://leetcode.com/problems/sort-an-array/
//leetcode problem 912
class SortAnArray {
    public int[] sortArray(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] counts = new int[max - min + 1];

        for (int num: nums) {
            counts[num - min]++;
        }

        int[] res = new int[nums.length];
        int idx = 0;

        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                res[idx++] = i + min;
                counts[i]--;
            } 
        }
        return res;
        
    }
}