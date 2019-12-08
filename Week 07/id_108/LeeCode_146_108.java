package study;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * 
 * 双向链表+HashMap
 *
 */
public class LeeCode_146_108 {
	private int capacity;
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public LeeCode_146_108(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			list.remove(new Integer(key));
			list.offerFirst(key);
			return map.get(key);
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			list.remove(new Integer(key));
		} else {
			if (capacity <= map.size()) {
				Integer lastKey = list.pollLast();
				map.remove(lastKey);
			}
		}
		list.offerFirst(key);
		map.put(key, value);
	}
}
