class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        int a;
        int left=0;int right = n*m-1;int mid;
        while(left<=right){
            mid=(left+right)/2;
            a=matrix[mid/n][mid%n];
            if(target == a) return true;
            else{if(target>=a){
                left=mid+1;
            }else{
                right=mid-1;
            }}
        }
        return false;
    }
}
