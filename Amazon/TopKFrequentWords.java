package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-words/
//leetcode problem 692
class Solution {
  public List<String> topKFrequent(String[] words, int k) {
      Map<String,Integer> map=new HashMap<>();
      PriorityQueue<String> pq=new PriorityQueue<>((a,b)->map.get(a)==map.get(b)?a.compareTo(b):map.get(b)-map.get(a));
      for(String s:words)
      map.put(s,map.getOrDefault(s,0)+1);

      for(String key:map.keySet())
      pq.offer(key);
      List<String> res=new ArrayList<>();
      for(int i=0;i<k;i++)
      {
        res.add(pq.poll());
      }
      return res;

  }
}
