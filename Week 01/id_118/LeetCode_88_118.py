from typing import List


class Solution1:
    """
    A  very pythonic solution, though it uses built-in sort function
    Python uses mergeSort to implement list sort method
    Time complexity is O(nlogn)
    """

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # merge two list first, nums1 only takes the first m elements
        # nums2 fill the remainder
        nums1[m:] = nums2[:n]
        # nums1 sort
        nums1.sort()
        print(nums1)  # for testing


class Solution2:
    """
    This solution has a time complexity of O(n)
    """

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        in-place change nums1
        :param nums1:
        :param m:
        :param nums2:
        :param n:
        :return:
        """
        # compare from last to first element
        # the bigger element will remain it's original position
        # the smaller element will be used for the next comparison
        # the new list will have the length of n+m-1
        while m > 0 and n > 0:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[n + m - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[n + m - 1] = nums2[n - 1]
                n -= 1

        # edge case if there are still values in nums2, put all in front of
        # nums1 as they are sorted and compared with all the elements in nums1
        if n >= 0:
            nums1[:n] = nums2[:n]
        print(nums1)  # for testing


def test1():
    sol1 = Solution1()
    l1 = [1, 2, 3, 0, 0, 0]
    l2 = [2, 5, 6]
    sol1.merge(l1, 3, l2, 3)


def test2():
    sol2 = Solution2()
    l1 = [1, 2, 3, 0, 0, 0]
    l2 = [2, 5, 6]
    sol2.merge(l1, 3, l2, 3)


if __name__ == '__main__':
    test1()
    test2()
