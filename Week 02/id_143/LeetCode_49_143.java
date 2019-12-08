import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 * 暴力法+哈希
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> a  = new HashMap<String,List<String>>();

        for(String str : strs){
            char[] aa = str.toCharArray();
            Arrays.sort(aa);

            StringBuffer aaaa = new StringBuffer();
            for(int i =0;i<aa.length;i++){
                aaaa.append(aa[i]);
            }
            String aaa =aaaa.toString();
            List<String> bb = (a.get(aaa) == null)? (new ArrayList<String>()) : a.get(aaa);
            bb.add(str);
            a.put(aaa, bb);
        }
        List result = new ArrayList<List<String>>();
        for(String key : a.keySet()){
            result.add(a.get(key));
        }
        return result;
    }
}
// 最后四行可以用ArrayList<a.vaule()> 实现空间换时间,减少3M的内存,提高1ms
// @lc code=end

