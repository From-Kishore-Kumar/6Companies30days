//https://leetcode.com/problems/number-of-boomerangs/
//leetcode problem 447

package GoldmanSachs;
import java.util.HashMap;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Integer,Integer> distMap = new HashMap<Integer,Integer>();
        for(int[] i : points) {
            for(int[] j : points) {
                if(i==j) continue;
                int dist = (i[0]-j[0])*(i[0]-j[0]) + (i[1]-j[1])*(i[1]-j[1]);
                int prevDist = distMap.containsKey(dist) ? distMap.get(dist) : 0;
                result += 2*prevDist;
                distMap.put(dist, prevDist+1);
            }
            distMap.clear();
        }
        return result;
    }
}
