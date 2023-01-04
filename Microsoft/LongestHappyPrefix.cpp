//https://leetcode.com/problems/longest-happy-prefix/
//leetcode problem 1392
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    string longestPrefix(string s) {
        int n = s.length(), next[n + 1], k = -1, i = 0;

        next[0] = -1;

        while (i < n) {
            if (k < 0 || s[i] == s[k]) 
                next[++i] = ++k;
            else 
                k = next[k];
        }

        return s.substr(0, next[n]);
    }
};