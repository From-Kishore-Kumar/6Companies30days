//https://leetcode.com/problems/count-nice-pairs-in-an-array/
//leetcode problem 1814
package GoldmanSachs;
import java.util.HashMap;
public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> equationCounts = new HashMap<>();
        int ans = 0;
        for(int x : nums)
            equationCounts.merge(x-rev(x), 1, Integer::sum);
        for(int x : equationCounts.values())
            if(x>1)
            {
                x-=1;
                long add = (long)(x/2.0*x+x/2.0)%1000000007;
                ans+= (int)(add);
                ans%=1000000007;
            }
        return ans;
    }
    public int rev(int n)
    {
        int ans = 0;
        while(n>0)
        {
            ans = ans*10+n%10;
            n/=10;
        }
        return ans;
    }
}
