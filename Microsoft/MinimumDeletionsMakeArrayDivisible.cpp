//https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/
//leetcode problem 2344
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        if (numsDivide.empty() || nums.empty()) {
            return -1;
        }
        int g = numsDivide[0];
        for (int i = 1; i < numsDivide.size() && g > 1; ++i) {
            g = std::gcd(g, numsDivide[i]);
        }
        int min_x = INT_MAX;
        for (int x : nums) {
            if (x < min_x && g % x == 0) {
                min_x = min(min_x, x);
            }
        }
        
        if (min_x != INT_MAX) {
            return std::count_if(nums.begin(), nums.end(), [min_x] (int x) { return x < min_x; } );
        }
        
        
        return -1;
    }
};