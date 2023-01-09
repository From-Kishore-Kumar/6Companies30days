//https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/
//leetcode problem 1878
package GoldmanSachs;

public class GetBiggestThreeRhombusSumsInAGrid {
    public int[] getBiggestThree(int[][] grid) {
        int[] sums = {0, 0, 0};        
        for (int side = 1; side <= (Math.min(grid.length, grid[0].length) + 1) / 2; side++) {
            for (int v = 0; v <= grid.length - 2 * side + 1; v++) {
                for (int h = side - 1; h <= grid[0].length - side; h++) {
                    int sum = 0;
                    if (side == 1) {
                        sum = grid[v][h];
                    } else {                        
                        for (int i = 0; i <= side - 2; i++) {
                            sum += grid[v + i][h - i];
                            sum += grid[v + side - 1 + i][h - side + 1 + i];
                            sum += grid[v + 2 * (side - 1) - i][h + i];
                            sum += grid[v + side - 1 - i][h + side - 1 - i];
                        }
                    }
                    
                    boolean doesExist = false;
                    for (int i = 0; i < sums.length; i++) {
                        doesExist = doesExist || sum == sums[i];
                        if (!doesExist && sum > sums[i]) {
                            for (int j = sums.length - 1; j >= i + 1; j--) {
                               sums[j] = sums[j - 1];
                            }
                            sums[i] = sum;
                            break;
                        }
                    }                           
                }               
            }
        }
        
        int length = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > 0) length++;
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = sums[i];
        }        
        
        return ans;
    }
}
