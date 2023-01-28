package Amazon;
//https://leetcode.com/problems/most-popular-video-creator/
//leetcode problem 2456

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static class Creator {
        public long popularity; // popularity Sum
        public String videoId; // video id
        public int maxView; // maximum view 
        public Creator(long popularity, String videoId, int maxView) {
            this.popularity = popularity;
            this.videoId = videoId;
            this.maxView = maxView;
        }
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Creator> nameToCreator = new HashMap<>();
        final int n = creators.length;
        long maxPopularity = 0;
        for (int i = 0; i < n; i++) {
            if (!nameToCreator.containsKey(creators[i])) {
                nameToCreator.put(creators[i], new Creator(views[i], ids[i], views[i]));
                maxPopularity = Math.max(maxPopularity, (long) views[i]);
                continue;
            }
           
            Creator creator = nameToCreator.get(creators[i]);
            creator.popularity += views[i];
            maxPopularity = Math.max(maxPopularity, creator.popularity);
            if (creator.maxView < views[i] || 
            creator.maxView == views[i] && creator.videoId.compareTo(ids[i]) > 0) {
              creator.videoId = ids[i];
              creator.maxView = views[i];  
            }
        }

        for (Map.Entry<String, Creator> entry : nameToCreator.entrySet()) {
            if (entry.getValue().popularity == maxPopularity) {
                ans.add(Arrays.asList(entry.getKey(), entry.getValue().videoId));
            }
        }
        return ans;
    }
}