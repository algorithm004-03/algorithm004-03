//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	static Map<Character,String> map = new HashMap<>();

	static{
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
	}

	public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> result  = new ArrayList<>();
        recursionTask("",result,0,digits);
        return result;
    }

    private void recursionTask(String s,List<String> result,int level,String digits) {
        //terminator
        if (level == digits.length()) {
            result.add(s);
            return;
        }
        // process current level logic
        //找到当前的数字字符，对应的字母范围，然后每个范围遍历输出
        char currentChar = digits.charAt(level);
        String foreachStr = map.get(currentChar);
        for (int i = 0; i<foreachStr.length();i++) {
            recursionTask(s + foreachStr.charAt(i),result,level +1,digits);
        }
        //drill down

        //reverse status if need
    }
}
//leetcode submit region end(Prohibit modification and deletion)
