import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II
 * @author L
 *给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用
 */
public class LeetCode_212_138 {
	//字典树节点
	class TrieNode{
		String val;
		TrieNode[] child = new TrieNode[26];
		boolean isLeaf=false;

	}
	//字典树定义
	class WordTrie{
		TrieNode root = new TrieNode();
		void insert(String s) {
			TrieNode cur = root;
			for(char ch:s.toCharArray()) {
				if(cur.child[ch-'a'] == null) {
					cur.child[ch-'a'] = new TrieNode();
				}
				cur = cur.child[ch-'a'];
			}
			cur.isLeaf = true;
			cur.val = s;
		}
	}
	public List<String> findWords(char[][] board, String[] words) {
		if(board == null) {
			return Collections.EMPTY_LIST;
		}
		//构造字典树	
		WordTrie wt = new WordTrie();
		TrieNode root = new TrieNode();
		//初始化字典树
		for(String s:words) {
			wt.insert(s);
		}
		Set<String> result = new HashSet();	
		int m = board.length;
		int n = board[0].length;
		boolean[][]visited = new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				findHelper(board,visited,i,j,m,n,result,root);
			}
		}
		return new LinkedList<String>(result);
	}
	private void findHelper(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result,
			TrieNode root) {
		// TODO Auto-generated method stub
		//边界以及是否已经访问判断
        if(i<0||i>=m||j<0||j>=n||visited[i][j])
            return;
        root = root.child[board[i][j]-'a'];
        visited[i][j]=true;
        if(root==null)
        {
            //如果单词不匹配，回退
            visited[i][j]=false;
            return;
        }
        //找到单词加入,找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
        if(root.isLeaf)
        {
            result.add(root.val);
        }
        findHelper(board,visited,i+1,j,m,n,result,root);
        findHelper(board,visited,i,j+1,m,n,result,root);
        findHelper(board,visited,i,j-1,m,n,result,root);
        findHelper(board,visited,i-1,j,m,n,result,root);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j]=false;
	}
}
