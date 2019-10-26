from typing import List


class Solution1:
    """
    This solution 1 using hashmap
    """

    def group_anagram(self, strs: List[str]) -> List[List[str]]:
        res = {}
        for s in strs:
            # note here need to sort the string to keep the key the same
            # reason to use tuple is because str is not hashable in Python
            key = tuple(sorted(s))
            if key not in res:
                res[key] = [s]
            else:
                res[key] += [s]
        return res.values()


def test1():
    sol = Solution1()
    print(sol.group_anagram(["eat", "tea", "tan", "ate", "nat", "bat"]))


if __name__ == '__main__':
    test1()
