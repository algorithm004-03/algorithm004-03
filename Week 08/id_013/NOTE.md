# NOTE
动态规划算法：
是一种解决棘手问题的方法，它将问题分成小问题，并先着手解决这些小问题。但仅当每个子问题都是离散的，即不依赖于其他子问题时，动态规划才管用。

在问题可分解为彼此独立且离散的子问题时，就可使用动态规划来解决。

设计动态规划解决方案的通用小贴士：
1、每个动态规划算法都从一个网格开始。
2、单元格中的值通常就是要优化的值。
3、每个单元格都是一个子问题，因此应考虑如何将问题分成子问题，这有助于找出网格的坐标轴。

最长公共子串：
两个字符串都包含的最长连续子串。

最长公共子序列：
两个字符串都包含的最长有序子串。

最长公共子串要求在原字符串中是连续的，而最长公共子序列只需要保持相对顺序一致，并不要求连续。

以下2例中待处理字符串：

# str_a = 'cnbalodgs'
# str_b = 'cbaelodng'

# str_a = 'abcdfg'
# str_b = 'abdfg'

str_a = 'abcbdab'
str_b = 'bdcaba'

# str_a = 'abcbdecb'
# str_b = 'ebdeaba'
1
2
3
4
5
6
7
8
9
10
11
示例：获取最长公共子串
解法就是用一个矩阵来记录两个字符串中所有位置的两个字符之间的匹配情况，若匹配则为1，否则为0。然后求出对角线最长的1的序列，其对应的位置就是最长匹配子串的位置。

# 此例中有多个相同长度的公共子串，但只能获取第一个子串
def find_lcsubstr(s1, s2): 
	# 下面4行不要直接写在循环中，减少计算
	s1_len = len(s1) + 1 									#为方便后续计算，多了1行1列 
	s2_len = len(s2) + 1
	s3_len = len(s1)
	s4_len = len(s2)
	m = [[0 for j in range(s2_len)] for i in range(s1_len)] #生成0矩阵
	maxNum = 0   											#初始最长匹配长度
	p = 0  													#匹配的起始位置
	for i in range(s3_len):
		for j in range(s4_len):
			if s1[i] == s2[j]:								#相同则累加
				m[i + 1][j + 1] = m[i][j] + 1     			#给相同字符赋值，值为左上角值加1
				if m[i + 1][j + 1] > maxNum:
					maxNum = m[i + 1][j + 1]				#获取最大匹配长度
					p = i + 1 								#记录最大匹配长度的终止位置
	print(m)
	return s1[p - maxNum : p], maxNum   					#返回最长子串及其长度
print(find_lcsubstr(str_a, str_b))
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
结果为：

[[0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 2, 0], [0, 0, 0, 1, 0, 0, 0], [0, 1, 0, 0, 0, 1, 0], [0, 0, 2, 0, 0, 0, 0], [0, 0, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 2, 0]]
('ab', 2)
1
2
示例：获取最长公共子序列，可辨别显示多组相同长度的不同最长公共子序列（此为转载）

class LCS():
    # 读入待匹配的两个字符串
    def input(self, x, y):									
        if type(x) != str or type(y) != str:
            print('input error')
            return None
        self.x = x
        self.y = y

    # 生成最长公共子序列矩阵
    def Compute_LCS(self):
        xlength = len(self.x)
        ylength = len(self.y)
        self.direction_list = [None] * xlength 				#这个二维列表存着回溯方向
        for i in range(xlength):
            self.direction_list[i] = [None] * ylength
        self.lcslength_list = [None] * (xlength + 1)        #这个二维列表存着当前最长公共子序列长度
        for j in range(xlength + 1):
            self.lcslength_list[j] = [None] * (ylength + 1)
        for i in range(0, xlength + 1):						#二维列表第一列设置为0
            self.lcslength_list[i][0] = 0
        for j in range(0, ylength + 1):						#二维列表第一行设置为0
            self.lcslength_list[0][j] = 0
        #下面是进行回溯方向和长度表的赋值
        for i in range(1, xlength + 1):
            for j in range(1, ylength + 1):
                if self.x[i - 1] == self.y[j - 1]:
                    self.lcslength_list[i][j] = self.lcslength_list[i - 1][j - 1] + 1
                    self.direction_list[i - 1][j - 1] = 0	#左上
                elif self.lcslength_list[i - 1][j] > self.lcslength_list[i][j - 1]:
                    self.lcslength_list[i][j] = self.lcslength_list[i - 1][j]
                    self.direction_list[i - 1][j - 1] = 1 	#上
                elif self.lcslength_list[i - 1][j] < self.lcslength_list[i][j - 1]:
                    self.lcslength_list[i][j] = self.lcslength_list[i][j - 1]
                    self.direction_list[i - 1][j - 1] = -1  #左
                else:
                    self.lcslength_list[i][j] = self.lcslength_list[i - 1][j]
                    self.direction_list[i - 1][j - 1] = 2  	#左或上
        self.lcslength = self.lcslength_list[-1][-1]
        # print(self.direction_list)
        # print(self.lcslength_list)
        return self.direction_list, self.lcslength_list

    # 生成最长公共子序列
    def printLCS(self, curlen, i, j, s):
        if i == 0 or j == 0:
            return None
        if self.direction_list[i - 1][j - 1] == 0:
            if curlen == self.lcslength:
                s += self.x[i - 1]
                for i in range(len(s)-1, -1, -1):
                    print(s[i])
                print('\n')
            elif curlen < self.lcslength:
                s += self.x[i - 1]
                self.printLCS(curlen + 1, i - 1, j - 1, s)
        elif self.direction_list[i - 1][j - 1] == 1:
            self.printLCS(curlen, i - 1, j, s)
        elif self.direction_list[i - 1][j - 1] == -1:
            self.printLCS(curlen, i, j - 1, s)
        else:
            self.printLCS(curlen, i - 1, j, s)
            self.printLCS(curlen, i, j - 1, s)

    def returnLCS(self):									#回溯的入口
        self.printLCS(1, len(self.x), len(self.y), '')

if __name__ == '__main__':
    p = LCS()												#实例化类
    p.input(str_a, str_b)									#读入待匹配的两个字符串
    p.Compute_LCS()											#生成最长公共子序列矩阵
    p.returnLCS()											#生成最长公共子序列
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
结果为：

b
c
b
a


b
c
a
b


b
d
a
b
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16


