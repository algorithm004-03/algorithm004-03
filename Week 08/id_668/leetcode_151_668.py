#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 151_reverse_words_in_a_string.py
    @time: 2019/12/5 16:14
"""


class Solution(object):
    """
        给定一个字符串，逐个翻转字符串中的每个单词。

        示例 1：

        输入: "the sky is blue"
        输出: "blue is sky the"
        示例 2：

        输入: "  hello world!  "
        输出: "world! hello"
        解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        示例 3：

        输入: "a good   example"
        输出: "example good a"
        解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

    """

    def reverse_words(self, s):
        """
        :type s: str
        :rtype: str
        """
        '''
        函数说明：
        split(...)
        S.split([sep [,maxsplit]]) -> list of strings

        Return a list of the words in the string S, using sep as the
        delimiter string.  If maxsplit is given, at most maxsplit
        splits are done. If sep is not specified or is None, any
        whitespace string is a separator and empty strings are removed
        from the result.

        >>> s = "   the   sky   is  blue "
        >>> s
        '   the   sky   is  blue '
        >>>
        >>> s.split()
        ['the', 'sky', 'is', 'blue']

        可知，如果split函数没有传递sep，则字符串中所有的空格与空字符都会被清除
        '''
        # slist = [e for e in s.strip().split(' ') if e]
        # return ' '.join(slist[::-1])

        return ' '.join(s.split()[::-1])  # s.split()获取以空格为分隔符形成的真值列表，然后对此取反

    def reverse_words2(self, s):
        """
        :type s: str
        :rtype: str

        分析：
        1. 先对s整体反转
        2. 再对每个单词进行反转
        """
        return ' '.join([e[::-1] for e in s[::-1].split()])
