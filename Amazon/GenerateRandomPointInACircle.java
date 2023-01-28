package Amazon;
//https://leetcode.com/problems/generate-random-point-in-a-circle/
//leetcode problem 478

import java.util.Random;

class Solution {
    private final Random rand = new Random();
    private final double radius;
    private final double x_center;
    private final double y_center;

    public Solution(final double radius, final double x_center, final double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double a = rand.nextDouble() * 2.0 * Math.PI;
        double x = Math.cos(a) * r;
        double y = Math.sin(a) * r;
        return new double[] { x_center + x, y_center + y };
    }
}   

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
