package Amazon;
//https://leetcode.com/problems/destroying-asteroids/
//leetcode problem 2126

import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        long runningMass = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (runningMass >= asteroids[i]) {
                runningMass += asteroids[i];
            } else {
                return false;
            }
        }
        
        return true;
    }
}