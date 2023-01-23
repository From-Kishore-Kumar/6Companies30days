//https://leetcode.com/problems/restore-ip-addresses/
//leetcode problem 93
import java.util.*;
class RestoreIPAddresses {

    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        calc(s, 0, new int[s.length()], s.charAt(0) - '0', 0);
        return ans;
    }

    void calc(String s, int i, int[] dots, int last, int count) {
        if (last < 0 || last > 255 || count > 3) return;
        if (i + 1 == s.length()) {
            if (count != 3) return;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (dots[j] == 1)
                    sb.append('.');
            }
            ans.add(sb.toString());
            return;
        }
        dots[i] = 1;
        calc(s, i + 1, dots, s.charAt(i + 1) - '0', count + 1);
        dots[i] = 0;
        if (last == 0 || last * 10 + s.charAt(i + 1) - '0' > 255) return;
        calc(s, i + 1, dots, last * 10 + s.charAt(i + 1) - '0', count);
    }
}