//动态规划,分解为子问题
//递推公式为
//dp[i][j]=dp[i-1][j]+dp[i][j-1];
//需要考虑边界
// int uniquePaths(int m, int n){
//     int **dp; 
//     dp=(int**)malloc(sizeof(int*)*m);  //返回一个指向（int*）数组的二级指针a
//     for(int i=0;i<m;i++) {
//         dp[i]=(int*)malloc(sizeof(int)*n);  //对a指向数组中的每一个一级指针开辟一行空间。
//     }
//     //int** dp = (int**)malloc(sizeof(int*)*m*n);
    
//     for(int i=0; i<m; i++){
//         for(int j=0; j<n; j++){
//             int one = i-1>=0 ? dp[i-1][j]:0;
//             int two = j-1>=0 ? dp[i][j-1]:0;
//             dp[i][j] = one + two;
//             if(i==0&&j==0){
//                 dp[0][0] = 1;
//             }
//             printf("%d",dp[i][j]);
//         }
//     }
//     return dp[m-1][n-1];
   

// }

//公式法，从n个元素中取出m个元素的循环排列数:C(n,m)=n!/[m!(n-m)!]=n*(n-1)*...*(n-m+1)/m!
//本题中相当于从m-n-2中取得n-1的随机组合方式
// int uniquePaths(int m, int n){
//     int M=n-1;
//     int min=m-1<n-1?m-1:n-1;
//     int N=m+n-2;
//     unsigned long long res=1;
//     if(n==1||m==1)
//         return 1;
//     if(m==0||n==0)
//         return 0;
//     for(int i=1; i<=min; i++){
//         res = res*(N-i+1)/i;
//         printf("%d\n",res);
//     }
//    return (int)(ceil(res));

// }

int uniquePaths(int m, int n){
    int **dp;
    dp = (int**)malloc(sizeof(int*)*m);
    for(int i=0; i<m; i++){
        dp[i] = (int*)malloc(sizeof(int)*n);
    }
    for(int i=0; i<n; i++) dp[0][i] = 1;
    for(int i=0; i<m; i++) dp[i][0] = 1;
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[m-1][n-1];

}