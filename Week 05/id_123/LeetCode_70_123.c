// int climbStairs(int n){
//     //递归f(2)=2;f(1)=1;f(3)=f(2)+f(1)(动态规划)
//     //以斐波拉契数列数组形式出现
//     if(n<=2){
//         return n;
//     }
//     int* stair = (int*)malloc(sizeof(int)*(n+1));
//     stair[1]=1;
//     stair[2]=2;
//     for(int i=3; i<=n; i++){
//         stair[i] = stair[i-1] + stair[i-2];
//     }
//     return stair[n];

// }

// int climbStairs(int n){
//     //递归f(2)=2;f(1)=1;f(3)=f(2)+f(1)(动态规划)
//     //非递归，变量迭代实现
//     if(n<=2){
//         return n;
//     }
//     int f1 = 1;
//     int f2 = 2;
//     int f3 = 3;
//     for(int i=3; i<=n; i++){
//         f3 = f1 + f2;
//         f1 = f2;
//         f2 = f3;
//     }
//     return f3;

// }

// FAIL
// //斐波拉契数列以递归形式实现 
// ////超出时间限制
// int fn(int n)
// {
//     if(n == 0 || n == 1) return 1;//前两项固定值。
//     return fn(n-1)+fn(n-2);// 通过递归调用实现通项公式。 
// }

// int climbStairs(int n){
//     if(n<=2)
//         return n;
//     return fn(n);

// }

int climbStairs(int n){
    //f(2)=2;f(1)=1;f(3)=f(2)+f(1)
    //斐波拉契通项公式
    //斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）。与本题查f(1)=1,f(2)=2,差1
    int f=(1/sqrt(5))*(pow(((1+sqrt(5))/2),(n+1))-pow(((1-sqrt(5))/2),(n+1)));
    return f;

}