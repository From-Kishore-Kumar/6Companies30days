//https://leetcode.com/problems/largest-divisible-subset/
//leetcode problem 368
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        vector<int> dp(n,1),hash(n);
        for(int i = 0;i<n;i++)
        cout<<hash[i]<<" ";
        int maxi = 0;
        int lastindex = -1;
        for(int ind = 0;ind<=n-1;ind++){
            for(int prev = 0;prev<=ind-1;prev++){
                if(nums[ind] % nums[prev] == 0 and dp[prev]+1>dp[ind]){
                    dp[ind] = dp[prev] + 1;
                    hash[ind] = prev;
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
                lastindex = ind;
            }
            if(dp[ind] == 1){
                hash[ind] = ind;
            }
        }
        vector<int> temp;
        temp.push_back(nums[lastindex]);
        while(hash[lastindex] != lastindex){
            lastindex = hash[lastindex];
            temp.push_back(nums[lastindex]);
        }
        reverse(temp.begin(),temp.end());
        return temp;
    }
};