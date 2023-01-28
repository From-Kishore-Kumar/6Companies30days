package Amazon;
//https://leetcode.com/problems/cheapest-flights-within-k-stops/
//leetcode problem 787

import java.util.Arrays;

class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, 1_000_000_000);
        costs[src] = 0;
        boolean changes = true;
        for ( ; k >= 0 && changes; k--)  if (!addFlights(flights, costs))  break;
        return costs[dst] == 1_000_000_000 ? -1 : costs[dst];
    }
    
    
    private boolean addFlights(int[][] flights, int[] costs) {
        boolean changes = false;
        int[] oldCosts = Arrays.copyOf(costs, costs.length);
        for (int[] flight : flights) {
            int from = flight[0];
            int to =   flight[1];
            int cost = flight[2];
            if (oldCosts[from] < 1_000_000_000 && costs[from] + cost < costs[to]) {
                costs[to] = oldCosts[from] + cost;
                changes = true;
            }
        }
        return changes;
    }

}
