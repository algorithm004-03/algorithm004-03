import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 字母异位词分组
 * @author Lvxile
 *
 */
public class LeetCode_49_138 {
	
	/**
	 * 快
	 * @param words
	 * @return
	 */
	public List<List<String>> agganumGroup_solution1 (String[] words){
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String,List<String>> map = new HashMap();
		for(String word: words) {
			char[] array = word.toCharArray();
			Arrays.sort(array);
			String sortStr = new String(array);
			if (map.containsKey(sortStr)) {
				List<String> temp = map.get(sortStr);
				temp.add(word);
				map.put(sortStr, temp);
			}else {
				List<String> temp = new ArrayList();
				temp.add(word);
				map.put(sortStr,temp);
			}
		}
		result.addAll(map.values());
		return result;
	}
	
	/**
	 * 慢
	 * @param words
	 * @return
	 */
	public List<List<String>> agganumGroup_solution2 (String[] words){
		List<List<String>> result = new ArrayList<List<String>>();
		Set<Integer> set = new HashSet();
		for(int i=0;i<words.length-1;i++) {
			if(!set.contains(i)) {
				List<String> ls = new ArrayList();
				ls.add(words[i]);
				set.add(i);
				for(int j=i+1;j<words.length;j++) {
					if(letterEquals(words[i], words[j])) {
						ls.add(words[j]);
						set.add(j);
					}
				}
				result.add(ls);
			}
		}
		
		return result;
	}
	
	/**
	 * 判断两个单词的字母是否一样
	 * @param w1
	 * @param w2
	 * @return
	 */
	private boolean letterEquals(String w1, String w2) {
		if(w1.length() != w2.length()) {
			return false;
		}
		int[]letters = new int[26];//注意是int数组，不是char数组
		for(char ch :w1.toCharArray()) {
			letters[ch-'a'] ++;
		}
		for(char ch: w2.toCharArray()) {
			letters[ch-'a']--;
			if(letters[ch-'a']<0) {//此种情况即可确定两个单词不一致，比如w1：aaa,w2:bbb
				return false;
			}
		}
		return true;
	}
	
	
}
