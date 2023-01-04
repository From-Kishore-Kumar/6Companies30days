//https://leetcode.com/problems/most-profitable-path-in-a-tree/
//leetcode problem 2467
#include<bits/stdc++.h>
using namespace std;
int start[100001], adj[200000], *amnt, bb;
int speedup = [] { std::ios::sync_with_stdio(0); std::cin.tie(0); return 0; }();

int dfs1(int nd, int p, int d)
{
    if(nd == bb)
    {
        amnt[nd] = 0;
        return 1;
    }
    for(int *i = adj + start[nd], *e = adj + start[nd + 1]; i != e; ++i)
    {
        if(*i != p)
        {
            if(int bh = dfs1(*i, nd, d + 1))
            {
                if(bh < d)
                    amnt[nd] = 0;
                else if(bh == d)
                    amnt[nd] /= 2;
                return bh + 1;
            }
        }
    }
    return 0;
}

int dfs(int nd, int p, int s)
{
    s += amnt[nd];
    if(nd && start[nd] + 1 == start[nd + 1])
        return s;
    int res = INT_MIN;
    for(int *i = adj + start[nd], *e = adj + start[nd + 1]; i != e; ++i)
    {
        if(*i != p)
            res = max(res, dfs(*i, nd, s));
    }
    return res;
}

class Solution
{
public:
    int mostProfitablePath(vector<vector<int>> &edges, int bob, vector<int> &amount)
    {
        int n = size(edges) + 1;
        fill(start, start + n, 0);
        for(const auto &e : edges)
            ++start[e[0]], ++start[e[1]];
        for(int i = 1; i < n; ++i)
        {
            start[i] += start[i - 1];
            start[n] = start[n - 1];
        }
        for(const auto &e : edges)
        {
            adj[--start[e[0]]] = e[1];
            adj[--start[e[1]]] = e[0];
        }
        bb = bob;
        amnt = amount.data();
        dfs1(0, -1, 0);
        return dfs(0, -1, 0);
    }
};