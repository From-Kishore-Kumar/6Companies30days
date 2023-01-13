import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/stock-price-fluctuation/
//leetcode problem 2034

public class StockPriceFluctuation {
    class Pair{
        int timeStamp;
        int price;
        Pair(int time, int price){
            timeStamp=time;
            this.price=price;
        }
    }    

    PriorityQueue<Pair> max; 
    PriorityQueue<Pair> min;
    HashMap<Integer,Integer> map;
    int latesttime;
    public StockPriceFluctuation() {
        latesttime=0;
        map = new HashMap<Integer,Integer>();    
        max = new PriorityQueue<>((a,b)->(b.price-a.price));
        min = new PriorityQueue<>((a,b)->(a.price-b.price));
    }
    
    public void update(int timestamp, int price) {
        latesttime=(latesttime>timestamp)?latesttime:timestamp;
        map.put(timestamp,price);
        max.add(new Pair(timestamp,price));        
        min.add(new Pair(timestamp,price));    
    }
    
    public int current() {
        return map.get(latesttime);
    }
    
    public int maximum() {
        while(max.peek().price!=map.get(max.peek().timeStamp)){
            max.poll();
        }
        return max.peek().price;        
    }
    
    public int minimum() {
        while(min.peek().price!=map.get(min.peek().timeStamp)){
            min.poll();
        }
        return min.peek().price;        
    }
}
/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
