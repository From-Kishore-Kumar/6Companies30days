package Amazon;
//https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
//leetcode problem 1503
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max=0;
        int min=Integer.MAX_VALUE;
        if(right.length==0)min=n;
        else{
            for(int i=0;i<right.length;i++){
                if(min>right[i])min=right[i];
            }
        }
        if(left.length==0)max=0;
        else{
            for(int i=0;i<left.length;i++){
                if(max<left[i])max=left[i];
            }
        }
        return Math.max(max,n-min);

    }
}
