// //超时
// bool isPowerOfTwo(int n){
//     if(n==1){
//         return true;
//     }
//     if(n&1==1&&(n!=1))
//         return false;
//     for(int i=0; i<=n/2; i++){
//         if(pow(2,i)==n){
//             return true;
//         }
//     }
//     return false;
 
// }
//2的幂次方，二进制有且仅有一个1
// bool isPowerOfTwo(int n){
//   int count = 0;
//   while(n>0){
//       n=n&n-1;
//       count++;
//   } 
//   if(count==1)
//       return true;
//    return false;
// }
//简单写法
bool isPowerOfTwo(int n){
   return ((n>0)&&((n&n-1)==0));
}