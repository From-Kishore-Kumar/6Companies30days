package Amazon;
//https://leetcode.com/problems/tweet-counts-per-frequency/
//leetcode problem 1348

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

class TweetCounts {

    HashMap<String, TreeMap<Integer,Integer>> hm;
    HashMap<String,Integer> frq;
    public TweetCounts() {
        hm = new HashMap<>();
        frq = new HashMap<>();
        frq.put("minute",60);
        frq.put("hour",3600);
        frq.put("day",86400);
    }

    public void recordTweet(String tweetName, int time) {
        if(!hm.containsKey(tweetName)){
            TreeMap<Integer,Integer> ts = new TreeMap<>();
            hm.put(tweetName,ts);
        }
        hm.get(tweetName).put(time,hm.get(tweetName).getOrDefault(time,0)+1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> ts = hm.get(tweetName);
        int fqv =  frq.get(freq);

        Integer first = ts.ceilingKey(startTime);
        int startpos = startTime;
        while(startpos<=endTime){
            int cnt =0;
            while(first!=null&&startpos+fqv>first&&first<=endTime){
                cnt+=ts.get(first);
                first=ts.higherKey(first);
            }
            ans.add(cnt);
            startpos+=fqv;
        }
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */