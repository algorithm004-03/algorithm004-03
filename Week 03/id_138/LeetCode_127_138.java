import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 单词接龙
 * 	给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
	每次转换只能改变一个字母。
	转换过程中的中间单词必须是字典中的单词。
 * @author L
 *
 */
public class LeetCode_127_138 {
	public class Pair<K,V>{

	    /**
	     * Key of this <code>Pair</code>.
	     */
	    private K key;

	    /**
	     * Gets the key for this pair.
	     * @return key for this pair
	     */
	    public K getKey() { return key; }

	    /**
	     * Value of this this <code>Pair</code>.
	     */
	    private V value;

	    /**
	     * Gets the value for this pair.
	     * @return value for this pair
	     */
	    public V getValue() { return value; }

	    /**
	     * Creates a new pair
	     * @param key The key for this pair
	     * @param value The value to use for this pair
	     */
	    public Pair(K key,V value) {
	        this.key = key;
	        this.value = value;
	    }
	   }
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        Map<String,ArrayList<String>> dict = new HashMap();
        
        wordList.forEach(word->{
        	for(int i=0;i<length;i++) {
        		//key 是类似通配符的字符串
        		String key = word.substring(0,i)+"*"+word.substring(i+1, length);
        		//存放两端与key匹配的map集合
        		ArrayList<String> values = dict.getOrDefault(key, new ArrayList<String>());
        		values.add(word);
        		dict.put(key, values);
        	}
        });
        
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String,Integer>>();
        queue.add(new Pair(beginWord, 1));
        
        Map<String,Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        
        while(!queue.isEmpty()) {
        	Pair<String,Integer> pair = queue.remove();
        	String word = pair.getKey();
        	int level = pair.getValue();
        	for(int i=0;i<length;i++) {
        		String key = word.substring(0,i)+"*"+word.substring(i+1,length);
        		for(String value: dict.getOrDefault(key, new ArrayList<String>())){
        			if(value.equals(endWord)) {
        				return level+1;
        			}
        			
        			if(!visited.containsKey(value)) {
        				visited.put(value, true);
        				queue.add(new Pair(value, level+1));
        			}
        		}
        	}
        }
        return 0;
        
    }
}
