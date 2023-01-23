//https://leetcode.com/problems/distinct-echo-substrings/
//leetcode problem 1316
import java.util.*;
class DistinctEchoSubstrings {
    public int distinctEchoSubstrings(String text) {
        // Set<String> ans = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        int len = text.length() - 1;
        for (int i = 0; i < len; ++i) {
            int h1 = 0, h2 = 0, pow = 1;
            int last = i + (text.length() - i) / 2;
            for (int j = i; j < last; ++j) {
                // extend the left hash
                h1 = 31 * h1 + text.charAt(j);
                if (h2 == 0) {
                    h2 = text.charAt(j + 1);
                } else {
                    int k = 2 * j - i;
                    // slide the right hash and extend
                    h2 = 31 * (31 * (h2 - pow * text.charAt(j)) + text.charAt(k)) 
                        + text.charAt(k + 1);
                    pow *= 31;
                }
                if (h1 == h2) {
                    // appendResult(text, ans, i, j);
                    ans.add(h1);
                }
            }
        }
        return ans.size();
    }

    private void appendResult(String text, Set<String> ans, int i, int j) {
        int len = j - i + 1;
        for (int c = 0; c < len; ++c) {
            if (text.charAt(i + c) != text.charAt(j + 1 + c)) {
                return;
            }
        }
        ans.add(text.substring(i, j + 1));
    }
}