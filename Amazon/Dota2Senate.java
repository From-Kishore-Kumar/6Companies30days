package Amazon;
//https://leetcode.com/problems/dota2-senate/
//leetcode problem 649

class Solution {
  
    public String predictPartyVictory(String str) {
        char [] s = str.toCharArray();  
        return predictPartyVictory(s, 0, 0);
    }
 
    public String predictPartyVictory(char [] s, int  rCount, int dCount) {
  
        for (int i=0;i<s.length;i++){
            if(s[i]=='D') {
                if(rCount > 0) {
                    rCount--;
                    s[i] = 'X';
                } else {
                    // rCount <= 0
                    dCount++;
                }
            }
            if(s[i]=='R') {
                if(dCount > 0) {
                    dCount--;
                    s[i] = 'X';
                } else {
                    // dCount <= 0
                    rCount++;
                }
            }
        }
      
        String ss = new String(s);
 
 
        if(ss.indexOf('D')== -1) return "Radiant";
        if(ss.indexOf('R')== -1) return "Dire";
 
        return predictPartyVictory(s,rCount, dCount);
        // return rCount + " | " +dCount + " | " + ss ;
   
    }
}