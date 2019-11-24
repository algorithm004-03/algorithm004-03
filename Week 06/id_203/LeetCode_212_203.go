package week06

/**
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import "fmt"

type node struct{
	val rune
	word string
	next map[rune]*node
}

func findWords(board [][]byte, words []string) []string {
	root := &node{next : map[rune]*node{}}
	for _, w := range words{
		p := root
		for i, b := range w{
			if _, ok := p.next[b]; !ok{ p.next[b] = &node{val:b, next:map[rune]*node{}} }
			if i==len(w)-1{ p.next[b].word = w }
			p = p.next[b]
		}
	}

	res := []string{}
	for i:=0; i< len(board); i++{
		for j:=0; j< len(board[i]); j++{
			dfs(board, &res, root, i,j, map[string]bool{})
		}
	}

	return res
}

func dfs(brd [][]byte, res *[]string, node *node, i,j int, visited map[string]bool){
	k := fmt.Sprintf("%v_%v", i,j)

	if i<0 || j<0 || i>=len(brd) || j >= len(brd[0]) || visited[k] { return }
	nn, ok:= node.next[rune(brd[i][j])]
	if !ok{ return }

	if len(nn.word) >0{  *res = append(*res, nn.word); nn.word ="" }

	visited[k]=true
	dfs(brd, res, nn, i+1, j, visited)
	dfs(brd, res, nn, i-1, j, visited)
	dfs(brd, res, nn, i, j+1, visited)
	dfs(brd, res, nn, i, j-1, visited)
	visited[k]=false
}