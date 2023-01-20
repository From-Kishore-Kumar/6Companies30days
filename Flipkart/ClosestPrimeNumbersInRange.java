package Flipkart;
//https://leetcode.com/problems/closest-prime-numbers-in-range/
//leetcode problem 2523
class ClosestPrimeNumbersInRange {
    public int[] closestPrimes(int left, int right) {
        int[] res = new int[]{-1,-1};
        int prev = -1;
        int diff = Integer.MAX_VALUE;

        for(int i=left; i<=right; i++){
            if(isPrime(i)){
                // limiting iteration for long rage
                if(diff == 1 || diff == 2) break;

                // if existing difference of prime pare is greater than current difference 
                if(res[0]!=-1 && res[1]!=-1 && diff > i-prev){
                    res[0] = prev;
                    res[1] = i;
                    diff = res[1]-res[0];
                }

                // adding 2st prime value in the given range
                if(res[0]!=-1 && res[1]==-1){
                    res[1] = i;
                    diff = res[1]-res[0];
                }

                // adding 1st prime value in the given range
                if(res[0]==-1){
                    res[0]=i;
                }

                // assigning the prime to 
                prev = i;
            }
        }

        // if only one prime is present inbetween the range
        if(res[1] == -1) return new int[]{-1,-1};
        return res;
    }

    // function isPrime to return if the number is prime or not
    public boolean isPrime(int n){
        if (n == 2 || n == 3)
            return true;

        if (n <=1 || n%2 == 0 || n%3 == 0)
            return false;

        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
