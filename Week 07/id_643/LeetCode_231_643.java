class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag = false;
        if(n > 0) {
            n = n & n - 1; 
            if(n == 0)
            flag = true;
        }
        return flag;
    }
}
