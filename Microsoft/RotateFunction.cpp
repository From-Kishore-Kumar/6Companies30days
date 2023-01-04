//https://leetcode.com/problems/rotate-function/
//leetcode problem 396
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        ios_base::sync_with_stdio(false);
        cin.tie(0);
    
        
        int n = nums.size();
        // vector<int> dp(n);
        int sum = 0;
        int val=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            val+=(i)*nums[i];
        }
        int mx = val;
        int newval=0;
        for(int i=1;i<n;i++){
            newval = val+sum - n*nums[n-i];
            mx = max(mx, newval);
            val = newval;
        }
        // for(auto i:dp){
        //     cout << i << ' ';
        // }
        cout << '\n';
        return mx;
    }
};