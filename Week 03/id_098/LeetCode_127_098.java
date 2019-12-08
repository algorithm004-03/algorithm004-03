// 最快解法解析 利用双端 BFS 双向交替遍历可能性
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //结果集
        List<List<String>> result =new ArrayList<>();
        //将字典转成hashset便于用于contains判断是否存在
        Set<String> words =new HashSet<>(wordList);
        //当结尾词不在字典集中，返回空
        if (!words.contains(endWord))
            return result;
        //自顶向下查找集（前向集）
        Set<String> start =new HashSet<>();
        //将开始词放入前向集
        start.add(beginWord);
        //自底向上查找集（后向集）
        Set<String> end =new HashSet<>();
        //将结束词放入后向集
        end.add(endWord);
        //利用双端BFS建树
        //严格来说不是颗完整树，是各种可能的一个路径片段，最后用深度优先遍历将路径片段串联起来完成输出
        Map<String,List<String>> map_tree=new HashMap<>();
        //如果双端建树，失败则直接返回
        if (!DoubleBuild_bfs(start,end,map_tree,true,words))
            return result;
        //利用深度优先遍历建里的树，返回结果
        DFS0(map_tree,result,beginWord,new LinkedList<String>(),endWord);
        return result;

    }


    /**
     *todo 核心 ： bfs 双向搜索建树；
     * boolean b 标志是正向搜索还是反向搜索的标志位
     */
    private boolean DoubleBuild_bfs(Set<String> start, Set<String> end, Map<String, List<String>> map_tree, boolean b,Set<String> words) {

        boolean success=false;
        //将遍历到的词从字典集中删除
        words.removeAll(start);
        //需要拓展可能性的集为空则返回
        if (start.size()==0)
            return false;
        //下一层的搜索集合
        Set<String> nextCeng =new HashSet<>();
        //向下一层搜索
        for (String str: start) {
            char[] c=str.toCharArray();
            //单词从左到右循环替换每一个字母
            for (int j = 0; j <c.length ; j++) {
                //c0临时变量保存每一个位置的字母
                char c0=c[j];
                //a-z 循环替换
                for (char i = 'a'; i <='z'; i++) {
                    //将字符数组的对应位置的字母替换
                    c[j]=i;
                    String s=String.valueOf(c);
                    //如果变换后的的词在字典集中
                    if (words.contains(s)){
                        //将该词加入下层的搜索集中
                        nextCeng.add(s);

                        //靠标志位b确定新词是拓展新的节点还是加入已有节点，保持已有建树的方向都是自上而下的
                        //b = true 正向搜索时，新词作为原搜索层的拓展
                        //b = false 反向搜索时，新词作为指向终点词的新节点
                        String  key= b? str : s;
                        String value=b? s : str;

                        //如果树中不包含该节点，则将该词放入树中
                        if (!map_tree.containsKey(key))
                            map_tree.put(key,new ArrayList<>());
                        map_tree.get(key).add(value);

                        // 如果该词在对向的搜索集中出现，则证明找到解答
                        if (end.contains(s))
                            success=true;
                    }
                }
                //将原来字符替换回去
                c[j]=c0;
            }
        }
        if (success)
            //如果找到解，结束递归返回上一层
            return true;
        else{
            //当搜索层单词个数大于对向层时，用对向层的搜索集进行拓展搜索，否则还按当前方向拓展搜索
            if (nextCeng.size()>end.size())
                return DoubleBuild_bfs(end,nextCeng,map_tree,!b,words);
            else
                return DoubleBuild_bfs(nextCeng,end,map_tree,b,words);
        }

    }

    //深度优先遍历树
    private void DFS0(Map<String, List<String>> map_tree, List<List<String>> result,String begin,LinkedList<String> list,String end) {
        //将遍历词加入临时栈
        list.addLast(begin);
        //当到达终了词时，将遍历路径加入结果集
        if (begin.equals(end)){
            result.add(new ArrayList<>(list));
        }
        //当遍历词不在树中，则回退到上一个节点
        if (!map_tree.containsKey(begin)){
            list.removeLast();
            return;
        }
        //深度优先遍历
        List<String> next=map_tree.get(begin);
        //找到该节点的下面所有节点一直遍历至终点词位置
        for (String str : next) {
            DFS0(map_tree,result,str,list,end);
        }
        //回退到上一个节点
        list.removeLast();
    }

}

/* 曾经尝试了一下对该算法进行改进
 在 ["hot","dot","dog","lot","log","cog"] 查找出现的所有字母 以减少 for (char i = 'a'; i <='z'; i++)
 这里的循环次数
        Set<Character>  charset = new HashSet<Character>();
        for (int i=0; i < wordList.size(); i++) {
            String tmpWord = wordList.get(i);
            char[] tmpChars = tmpWord.toCharArray();
            for (int j = 0; j < tmpChars.length; j++) {
                if (!charset.contains(tmpChars[j]))
                    charset.add(tmpChars[j]);
            }
        }
        Character[] chars = new Character[charset.size()];
        charset.toArray(chars);

  但是实际提交后发现，速度反而慢了很多，究其原因在于当词汇很多的时候找出上段代码本身就会耗时很高
 */