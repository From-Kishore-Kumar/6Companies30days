package Flipkart;
//https://leetcode.com/problems/distant-barcodes/
//leetcode problem 1054
class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] arr = new int[10001];
        int n = barcodes.length;
        int[] ans = new int[n];
        
        for(int it : barcodes) {
            arr[it]++;
        }
        
        int max = -1, count = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>count) {
                count = arr[i];
                max = i;
            }
        }
        int index = 0;
        for(int i=0; i<count; i++) {
            ans[index] = max;
            index+=2;
        }
        arr[max] = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                if(index >=n) index = 1;
                ans[index] = i;
                index+=2;
            }
        }
        return ans;
    }
}
