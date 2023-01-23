//https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
//leetcode problem 1561
import java.util.*;
class MaximumNumberOfCoinsYouCanGet{
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i=0; int j=piles.length-1;
        int sum=0;
        while(i<j)
        {
            i++;
            j--;
            sum=sum+piles[j--];
        }
        return sum;
    }
}