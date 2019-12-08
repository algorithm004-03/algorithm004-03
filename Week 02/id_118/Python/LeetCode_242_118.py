class Solution1:
    """
    Solution 1 Use sorted function
    """

    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)


class Solution2:
    """
    Solution 2 Use hashmap
    """

    def isAnagram(self, s: str, t: str) -> bool:
        dict_s, dict_t = self._str_dict(s), self._str_dict(t)
        return dict_s == dict_t

    def _str_dict(self, s: str) -> dict:
        res = {}
        for c in s:
            if c in res:
                res[c] += 1
            else:
                res[c] = 1
        return res


class Solution3:
    """
    Use dict get method, equivalent to Solution2
    """

    def isAnagram(self, s: str, t: str) -> bool:
        dict_s, dict_t = self._str_dict(s), self._str_dict(t)
        return dict_s == dict_t

    def _str_dict(self, s: str) -> dict:
        res = {}
        for c in s:
            res[c] = res.get(c, 0) + 1
        return res


def test1():
    sol = Solution1()
    s, t = "anagram", "nagaram"
    print(sol.isAnagram(s, t))


def test2():
    sol = Solution2()
    s, t = "a", "b"
    print(sol.isAnagram(s, t))


def test3():
    sol = Solution3()
    s, t = "anagram", "nagaram"
    print(sol.isAnagram(s, t))


if __name__ == '__main__':
    test1()
    test2()
    test3()
