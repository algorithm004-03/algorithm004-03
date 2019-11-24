class Solution {
    private double helper(double x,long N){
        if(N == 0){
            return 1.0;
        }
        double half = helper(x,N/2);
        if(N%2==1){
            return half*half*x;
        }
        if(N%2==0){
            return half*half;
        }
        return x;
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x= 1/x;
            N=-N;
        }
        return helper(x,N);
    }
}

