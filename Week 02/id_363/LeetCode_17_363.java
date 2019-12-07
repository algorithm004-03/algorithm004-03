package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class SolutionLetterCombination17 {


    /**
     * 1. 递归
     * 2. queue+ 2循环
     * 3. queue + 1循环
     */
    @Test
    public void test1() {
//        System.out.println(letterCombinationsQueue(""));
        System.out.println(letterCombinationsQueue2("234"));
    }


    public List<String> letterCombinationsQueue2(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return queue;
        }
        String[] buttons = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        queue.offer("");
        // 以队列里面字母的长度来判断当前层有多少数据
        while (queue.peek().length() != digits.length()) {
            String temp = queue.poll();
            String chars = buttons[temp.length() + 2];
            for (Character c : chars.toCharArray()) {
                queue.offer(temp + c);
            }
        }
        return queue;
    }


    public List<String> letterCombinationsQueue(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return queue;
        }
        String[] buttons = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        queue.offer("");
        for (int i = 0; i < digits.length(); i ++) {
            String chars = buttons[digits.charAt(i) - '0'];
            while(queue.peek().length() == i) {
                String temp = queue.poll();
                for (Character c : chars.toCharArray()) {
                    queue.offer(temp + c);
                }
            }
        }
        return queue;
    }




    Map<String, String > map = new HashMap();

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "qprs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        // map
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(digits, "", result);
        // digit i
        // combination + 可能的字母 + 继续递归
        return result;
    }

    private void helper(String digits, String combination, List<String> result) {
        // 终止条件
        if (digits.length() == 0) {
            result.add(combination);
            return;
        }
        // 处理当前层 获取当前层的数字 获取对应的字母 吧字母加入到combination 后面
        String num = digits.substring(0, 1);
        String chars = map.get(num);
        // 下探到下一层 digits = digits.substring(1);
        digits = digits.substring(1);
        for (Character c : chars.toCharArray()) {
            helper(digits, combination+ c , result);
        }
        // 清理当前层
    }
}
