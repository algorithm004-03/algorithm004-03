package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LeeCode_049_108 {
	 
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return  new ArrayList<List<String>>();
 
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (String s:strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);        //从小到大排序
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)){
                map.put(keyStr,new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        } 
        return  new ArrayList<List<String>>(map.values());
    }
    /*@Test
	public static void main(String[] args) {
		String[] strArra = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupStr = groupAnagrams(strArra);
		
		// 测试案例期望值
	    List<List<String>> expResult1 = new ArrayList<>();
	    List<String> list1 = new ArrayList<>();
	    list1.add("ate");
	    list1.add("eat");
	    list1.add("tea");
	    List<String> list2 = new ArrayList<>();
	    list2.add("nat");
	    list2.add("tan");
	    List<String> list3 = new ArrayList<>();
	    list3.add("bat");
	    expResult1.add(list1);
	    expResult1.add(list2);
	    expResult1.add(list3);
	    // 判断期望值与实际值
	    Assert.assertEquals(expResult1, groupStr);
	}*/
}
