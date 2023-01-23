//https://leetcode.com/problems/swim-in-rising-water/
//leetcode problem 778
class SwimInRisingWater {
    boolean dfs(int[][] grid, int mid, int i, int j, int n, boolean[][] vis){
        if(i<0 || i>=n || j<0 || j>=n || vis[i][j]==true || grid[i][j]>mid){
            return false;
        }
        vis[i][j]=true;
        if(i==n-1 && j==n-1) return true;

        boolean up,down,right,left;
        up=dfs(grid,mid,i-1,j,n,vis);
        down=dfs(grid,mid,i+1,j,n,vis);
        right=dfs(grid,mid,i,j-1,n,vis);
        left=dfs(grid,mid,i,j+1,n,vis);
        return (up || down || right || left);
    }

    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int lo=0,hi=(n*n)-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            boolean[][] vis=new boolean[n][n];
            if(dfs(grid,mid,0,0,n,vis)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}