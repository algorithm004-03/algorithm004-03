# NOTE
HashMap源码分析：所有操作非线程安全的。

继承AbstractMap，实现Map，数据结构：哈希表。key和value都允许为空。
HashMap容量为2的平方。初始容量为16。
最大所能容纳的key-value 个数：2^30
出于性能考虑。容量计算均通过位运算得出。所以也就不难理解为何都是2的平方 
hash函数计算出index.
hash碰撞：   拉链式解决碰撞

put方法：

	根据key经过hash函数计算出hashcode，来确定node在数组中的位置。

	判断table有没有初始化，如果没有初始化，则调用resize（）方法为table初始化容量，以及threshold的值。
	根据hash值定位该key 对应的数组索引，如果对应的数组索引位置无值，则调用newNode（）方法，为该索引创建Node节点
	如果根据hash值定位的数组索引有Node，并且Node中的key和需要新增的key相等，则将对应的value值更新。
	如果在已有的table中根据hash找到Node，其中Node中的hash值和新增的hash相等，但是key值不相等的，那么创建新的Node，放到当前已存在的Node的链表尾部。
	      如果当前Node的长度大于8,则调用treeifyBin（）方法扩大table数组的容量，或者将当前索引的所有Node节点变成TreeNode节点，变成TreeNode节点的原因是由于TreeNode节点组成的链表索引元素会快很多。
	将当前的key-value 数量标识size自增，然后和threshold对比，如果大于threshold的值，则调用resize（）方法，扩大当前HashMap对象的存储容量。
	返回oldValue或者null。
	put 方法比较经常使用的方法，主要功能是为HashMap对象添加一个Node 节点，如果Node存在则更新Node里面的内容。

	
resize方法：
	如果当前数组为空，则初始化当前数组

	如果当前table数组不为空，则将当前的table数组扩大两倍，同时将阈值（threshold）扩大两倍

      数组长度和阈值扩大成两倍之后，将之前table数组中的值全部放到新的table中去

get略~


BST:中序查询是有序的（有些算法题可以运用此特性求解）

二叉树之所以用递归，个人觉得就是重复特性非常鲜明。

递归解题模板：
	
	1：终结条件
	
	2：处理当前层逻辑
	
	3：下探下一层
	
	4：清理当前层
	
	
分治，回溯  都是递归课题里面的子集，  回溯目前还有点迷糊，还需要加强联系。	

