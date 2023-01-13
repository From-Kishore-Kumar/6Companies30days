//https://leetcode.com/problems/knight-probability-in-chessboard/
//leetcode problem 688
public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{-1,-2},{1,-2}};
        return knight(dir,row,column,k,n);
    }
    public static double knight(int[][] dir,int r,int c,int k,int n){
        double[][][] dp = new double[k+1][n][n];
        return recurse(dir,r,c,k,n,dp);
    } 
    public static double recurse(int[][] dir,int r,int c,int k,int n,double[][][] dp){
        if(r<0 || r>=n || c<0 || c>=n){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[k][r][c] != 0.0){return dp[k][r][c];}
        float res = 0;
        for(int i=0;i<dir.length;i++){
            int[] move = dir[i];
            res += recurse(dir,r+move[0],c+move[1],k-1,n,dp);
        }
        dp[k][r][c] = res/8.0;
        return res/8.0;
    }
}
