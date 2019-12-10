/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (37.09%)
 * Likes:    152
 * Dislikes: 0
 * Total Accepted:    13.4K
 * Total Submissions: 35.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 *
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 *
 * 说明:
 *
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 *
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 */

// @lc code=start
package leetCode

import "container/list"

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordLen, comoboDict := len(beginWord), make(map[string][]string, len(wordList)*3)

	for _, word := range wordList {
		index := 0
		for index < wordLen {
			key := word[0:index] + "*" + word[index+1:]
			comoboDict[key] = append(comoboDict[key], word)
			index++
		}
	}

	level := 0
	queue := list.New()
	queue.PushBack(interface{}(beginWord))
	visited := make(map[string]bool, len(wordList))

	for queue.Len() > 0 {
		level++
		queueIndex, queueCount := 0, queue.Len()
		for queueIndex < queueCount {
			queueIndex++
			word := queue.Remove(queue.Front()).(string)
			if visited[word] {
				continue
			}
			if word == endWord {
				return level
			}
			visited[word] = true
			wordIndex := 0
			for wordIndex < wordLen {
				key := word[0:wordIndex] + "*" + word[wordIndex+1:]
				wordIndex++
				words, exist := comoboDict[key]
				if !exist {
					continue
				}
				for _, value := range words {
					if value != word && !visited[value] {
						queue.PushBack(interface{}(value))
					}
				}
			}
		}
	}
	return 0
}

// @lc code=end
