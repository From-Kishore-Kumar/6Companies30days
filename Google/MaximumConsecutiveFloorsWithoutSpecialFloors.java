//https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
//leetcode problem 2274
import java.util.*;
class  MaximumConsecutiveFloorsWithoutSpecialFloors{
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int specialLength = special.length;
        int bottomToFirst = special[0] - bottom;
        int topToLast = top - special[specialLength - 1];
        int maxConsec = Math.max(bottomToFirst, topToLast);
        for (int i = 1; i < specialLength; i++) {
            maxConsec = Math.max(maxConsec, special[i] - special[i - 1] - 1);
        }
        return maxConsec;
    }
}