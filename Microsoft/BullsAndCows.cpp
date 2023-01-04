//https://leetcode.com/problems/bulls-and-cows/
//leetcode problem 299
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    string getHint(string secret, string guess) {
        int arr[10]={0};int cows=0;int bull=0;
        for(int i=0;i<secret.size();i++){
            arr[secret[i]-'0']++;
            if(secret[i]==guess[i]){
                bull++;
            }
        }
        for(int i=0;i<guess.size();i++){
            if(arr[guess[i]-'0']>0){
                cows++;
                arr[guess[i]-'0']--;
            }
        }
        cows=cows-bull;
        string k="";
        k+=to_string(bull);
        k+='A';
        k+=to_string(cows);
        k+='B';
        return k;
    }
};