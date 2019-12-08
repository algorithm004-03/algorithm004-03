/**
 * @param {number} num
 * @return {number[]}
 * 奇数：1 个数为前一个数的1 的个数+1
 * 偶数：1个数等于下一个乘以2的数的 1 的个数
 * DP方程
 * a[0] = 0
 * if n % 2 === 1  a[n] = a[n-1] + 1
 * if n % 2 === 0  a[n] = a[n/2]
 */
 var countBits = function(num) {
    let a = new Array(num+1)
    a[0] = 0;
    for(let i = 1; i <= num; i++) {
        if(i%2 === 1) {
            a[i] = a[i-1] + 1;
        } else if(i % 2 === 0) {
            a[i] = a[i/2]
        }
    }
    return a
};