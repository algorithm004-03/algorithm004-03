class Solution {
    public boolean isPerfectSquare(int num) {
        long left=0;long right = num;
        long mid;
        while(left < right){
            mid = left+(right-left+1)/2;
            if(mid * mid == num) return true;
            if(mid * mid > num){
                right=mid-1;
            }
            if(mid * mid < num){
                left=mid;
            }
        }
        return false;
    }
}
