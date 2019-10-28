import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 */
public class LeetCode_49_648 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList();
        }
        HashMap<String,List<String>> mapList = new HashMap<>();
        for(String str:strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String strNew = String.valueOf(strArray);
            if(!mapList.containsKey(strNew))mapList.put(strNew,new ArrayList<String>());
            mapList.get(strNew).add(str);
        }
        return new ArrayList(mapList.values());
    }

    public static void main(String[] args) {
        LeetCode_49_648 leetCode_49_648 = new LeetCode_49_648();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        leetCode_49_648.groupAnagrams(strs);
    }
}