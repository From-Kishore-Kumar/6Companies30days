//https://leetcode.com/problems/k-divisible-elements-subarrays/
//leetcode problem 2261
import java.util.*;
class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        
        Map<String, Boolean> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int count = 0;
            String s = "";
            for(int j=i; j<nums.length; j++){
                s += nums[j]+";";
                if(nums[j]%p == 0){
                    count++;
                }
                if(count <= k){
                    if(mp.get(s)==null){
                        mp.put(s, true);
                        ans++; 
                    }
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}