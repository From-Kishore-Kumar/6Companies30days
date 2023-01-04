//https://leetcode.com/problems/perfect-rectangle/
//leetcode problem 391
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        const int inf = 0x3f3f3f3f;
        long long a[4] = {inf,inf,-inf,-inf};
        long long s[4] = {0,0,0,0};
        for (auto r: rectangles) {
            a[0] = min<long long>(a[0], r[0]);
            a[1] = min<long long>(a[1], r[1]);
            a[2] = max<long long>(a[2], r[2]);
            a[3] = max<long long>(a[3], r[3]);
            long long x = (long long)r[2] - r[0];
            long long y = (long long)r[2] * r[2] - (long long)r[0] * r[0];
            long long z = (long long)r[3] - r[1];
            long long w = (long long)r[3] * r[3] - (long long)r[1] * r[1];
            s[0] += x*z, s[1] += y*z, s[2] += x*w, s[3] += y*w;
        }
        return s[0] == (a[2] - a[0]) * (a[3] - a[1]) &&
               s[1] == (a[2]*a[2] - a[0]*a[0]) * (a[3] - a[1]) &&
               s[2] == (a[2] - a[0]) * (a[3]*a[3] - a[1]*a[1]) &&
               s[3] == (a[2]*a[2] - a[0]*a[0]) * (a[3]*a[3] - a[1]*a[1]);
    }
};