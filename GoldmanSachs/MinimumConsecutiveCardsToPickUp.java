//https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
//leetcode problem 2260
package GoldmanSachs;

public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        int y = 0;
        int[] count = new int[1000001];
        for(int x = 0; x < cards.length; x++){
            count[cards[x]]++;
            
            while(count[cards[x]] > 1){
                count[cards[y]]--;
                y++;
                ans = Math.min(ans, x - y + 2);
            }
            
            
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        
        return -1;
    }
}
