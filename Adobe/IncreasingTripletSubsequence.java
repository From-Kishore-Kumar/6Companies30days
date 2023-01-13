//https://leetcode.com/problems/increasing-triplet-subsequence/
//leetcode probelm 334
class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstNum) {
                firstNum = num;
            } else if (num <= secondNum) {
                secondNum = num;
            } else {
                return true;
            }
        }
        return false;
    }
}