//https://leetcode.com/problems/maximum-points-in-an-archery-competition/
//leetcode probelm 2212
package GoldmanSachs;

public class MaximumPointsInAnArcheryCompetition {
    // for bob to get points, bobArrows[i] > alicenArrow[i]
    // bob may choose not to put arrow on pos i to get i points 
    //      if number of arrows wasted on i may get higher points at j
    // at pos i, either put aliceArrows[i] + 1 or 0
    // start from right to left, two choices at pos i
    // case1: if arrows >= aliceArrows[i] + 1, place aliceArrows[i] + 1, get i points
    // case2: do not place any arrows, go to pos i - 1
    // if there are any arrows left at pos 0, no use
    // pruning: if at pos i, arrows * i + points < maxPoints, return
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int[] bestArrows = new int[n];
        int[] bestScore = new int[1];
        placeArrows(new int[n], 0, n - 1, numArrows, aliceArrows, bestArrows, bestScore);
        return bestArrows;
    }

    private void copyArray(int[] nums, int[] other) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = other[i];
        }
    }
    private void placeArrows(int[] currArrows, int currScore, int level, int arrows, int[] aliceArrows, int[] bestArrows, int[] bestScore) {
        if (level == 0 || arrows == 0) {
            currArrows[0] += arrows;
            if (currScore > bestScore[0]) {
                bestScore[0] = currScore;
                copyArray(bestArrows, currArrows);
            }
            currArrows[0] -= arrows;
            return;
        }
        // if placing all arrows to maximum points does not get better score, return
        int maxSectionCnt = Math.min(level, arrows);
        int maxPossibleScore = currScore + (level + level - maxSectionCnt + 1) * maxSectionCnt / 2;
        if (maxPossibleScore < bestScore[0]) {
            return;
        }
        // place arrows at level
        int arrowsNeeded = aliceArrows[level] + 1;
        if (arrows >= arrowsNeeded) {
            currArrows[level] += arrowsNeeded;
            arrows -= arrowsNeeded;
            placeArrows(currArrows, currScore + level, level - 1, arrows, aliceArrows, bestArrows, bestScore);
            arrows += arrowsNeeded;
            currArrows[level] -= arrowsNeeded;
        }
        // does not place arrows at level
        placeArrows(currArrows, currScore, level - 1, arrows, aliceArrows, bestArrows, bestScore);
    }
}
