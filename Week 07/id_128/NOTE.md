# NOTE

  
~ 反
^ 异或  相当于 不进位加法

x ^ 0 = x
x ^ 1s = ~x
x ^ x = 0
x ^ (~x) = 1s

c = a ^ b =>  a = c ^ b, b = a ^ c  交换性
a ^ b ^ c = (a ^ b) ^ c = a ^ (b ^ c) 结合性


实战要点

判断奇偶
x % 2 == 1 => x & 1 == 1
x % 2 == 0 => x & 1 == 0

除2
x/2 =>  x>>1
mid = (left+right)/2 => mid = (left+right) >> 1

清零最低位的1
x = x & (x-1)

得到最低位的1
x & -x


