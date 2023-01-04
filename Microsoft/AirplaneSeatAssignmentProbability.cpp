//https://leetcode.com/problems/airplane-seat-assignment-probability/
//leetcode problem 1227
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    double nthPersonGetsNthSeat(int n) {
        return n != 1 ? 0.5 : 1.0;
    }
};
