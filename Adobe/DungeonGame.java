//https://leetcode.com/problems/dungeon-game/
//leetcode problem 174
public class DungeonGame {
    public int traverse(int[][] g, int i, int j, int[][] dp)
    {
        if(i >= g.length || j >= g[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int health = Integer.MAX_VALUE;
        health = Math.min(health, traverse(g,i+1,j,dp));
        health = Math.min(health, traverse(g,i,j+1,dp));

        if(i == g.length - 1 && j == g[i].length - 1){
            health = 1;
        }

        health = health <= g[i][j]? 1: health - g[i][j];

        return dp[i][j] = health;


    }
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        return traverse(dungeon,0,0,dp);
    }
}
