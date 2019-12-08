from typing import List


class Solution1:
    """
    This solution uses a lot of python specific methods
    """

    def move_zeroes(self, nums: List[int]) -> None:
        # length of the original array
        l = len(nums)
        # filter out all the zeros
        nums[:] = filter(lambda x: x != 0, nums)
        # length of the modified array
        l2 = len(nums)
        # fill 0s to the right
        nums[l2:] = [0] * (l - l2)
        # print to test
        print(nums)


class Solution2:
    """
    the most traditional solution
    """

    def move_zeroes(self, nums: List[int]) -> None:
        # index for zero element
        zero = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[zero], nums[i] = nums[i], nums[zero]
                zero += 1
        print(nums)


class Solution3:
    """
    following Olsh's snowball solution
    """

    def move_zeros(self, nums: List[int]) -> None:
        snowball = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                snowball += 1
            elif snowball > 0:
                # swap with the most left 0
                nums[i], nums[i - snowball] = nums[i - snowball], nums[i]
        print(nums)


test_nums = [0, 1, 0, 3, 12]


def test1():
    sol = Solution1()
    sol.move_zeroes(test_nums)


def test2():
    sol = Solution2()
    sol.move_zeroes(test_nums)


def test3():
    sol = Solution3()
    sol.move_zeros(test_nums)


if __name__ == '__main__':
    test1()
    test2()
    test3()
