package com.leetcode.week08;

/**
 * Created by tim on 2019/12/7.
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

 '?' 可以匹配任何单个字符。
 '*' 可以匹配任意字符串（包括空字符串）。
 两个字符串完全匹配才算匹配成功。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入:
 s = "aa"
 p = "*"
 输出: true
 解释: '*' 可以匹配任意字符串。
 示例 3:

 输入:
 s = "cb"
 p = "?a"
 输出: false
 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 示例 4:

 输入:
 s = "adceb"
 p = "*a*b"
 输出: true
 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 示例 5:

 输入:
 s = "acdcb"
 p = "a*c?b"
 输入: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/wildcard-matching
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_44_048 {
    public boolean isMatch(String s, String p) {
        if (p.equals("*"))
            return true;
        char[] s_array = s.toCharArray();
        char[] p_array = p.toCharArray();
        int s_index = 0;
        int p_index = 0;
        boolean result = false;
        boolean flag = false;
        while (s_index< s_array.length && p_index < p_array.length){
            //处理正常情况
            if (p_array[p_index]!='?'&&p_array[p_index]!='*'){
                if (s_array[s_index]!=p_array[p_index]){
                    return false;
                }
            }
            //处理 * 情况
            if (p_array[p_index]=='*'){
                flag = true;
                //当有很多个*连在一起的时候，等同于一个*
                while (p_index<p_array.length&&p_array[p_index]== '*')
                    p_index++;

                if (p_index >= p_array.length )
                    return true;
                else {
                    while (s_index < s_array.length){
                        int temp_s_index = s_index;
                        int temp_p_index = p_index;
                        //当相等时，下标向前走
                        while (s_index<s_array.length&&p_index<p_array.length&&(s_array[s_index]==p_array[p_index]|| p_array[p_index]=='?')){
                            s_index++;
                            p_index++;
                            //result = result || isMatch_Problem_44(s.substring(s_index,s.length()),p.substring(p_index,p.length()));
                        }
                        //如果走到头了，就是匹配成功了
                        if (p_index == p_array.length && s_index == s_array.length)
                            result = result || true;
                        //如果p遇到*，则交给下一轮递归
                        if (p_index<p_array.length&&p_array[p_index]=='*') {
                            result = result ||isMatch(s.substring(s_index,s.length()),p.substring(p_index,p.length()));
                            //break掉，防止重复递归
                            break;
                        }
                        s_index = temp_s_index;
                        p_index = temp_p_index;

                        s_index++;
                    }
                }
                break;
            }

            s_index++;
            p_index++;
        }
        //如果flag为true，则是有*的情况
        if (flag)
            return result;
        //当s走完了，但p没走完，且p后面全是*， 这种情况单独判断
        if (s_index==s_array.length && p_index!=p_array.length){
            while (p_index<p_array.length){
                if (p_array[p_index]!='*')
                    return false;

                p_index++;
            }
            return true;
        }
        //普通情况，没走完返回false
        if (s_index!=s_array.length || p_index!=p_array.length)
            return false;
        return true;
    }

}
