package Amazon;
//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
//leetcode problem 1593

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
       
        Set<String> set = new HashSet<>();
        max = 0;
        dft(set, s.toCharArray(), 0);
        return max;
    }
    int max = 0;
    
    void dft(Set<String> set, char[] s, int start) {
        if (start == s.length) {
            max = Math.max(max, set.size());
            return;
        }
        StringBuilder curr = new StringBuilder();
        for (int i = start; i < s.length; i++) {
            if (set.size() + s.length - i < max) {

                return;
            }
            curr.append(s[i]);
            String subStr = curr.toString();
      
            if (!set.contains(subStr)) {
                set.add(subStr);
                dft(set, s, i+1);
                set.remove(subStr);
            }
        }
    }
}