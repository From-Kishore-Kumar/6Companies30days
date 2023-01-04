//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
//leetcode problem 1358
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int numberOfSubstrings(string s) {
    int ans=0,a,b,c;
    a=b=c=-1;
    for(int i=0;i<s.size();i++){
        if(s[i]=='a') a=i;
        else if(s[i]=='b') b=i;
        else c=i;
        int p=min(a,min(b,c));
        if(p==-1) continue;
        ans+=(p+1);
    }
    return ans;
    }
};