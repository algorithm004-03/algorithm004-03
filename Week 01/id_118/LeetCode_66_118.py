from typing import List


class Solution1:
    """
    The idea is simple, array -> string -> int
    then: int + 1
    finally: int -> string -> array
    """

    def plusOne(self, digits: List[int]) -> List[int]:
        # convert list to an int
        a = "".join(map(lambda x: str(x), digits))
        a = int(a)
        b = a + 1
        res = [int(digit) for digit in str(b)]
        return res


class Solution2:
    """
    I think a more proper solution would be using digit operation
    """

    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        # reverse order as hundreds is at 0, tens at 1...
        for idx, digit in enumerate(digits[::-1]):
            num += digit * (10 ** idx)
        # plus one
        num += 1

        res = []
        while num > 0:
            # start append digit into res from units, tens, hundreds etc
            res.append(num % 10)
            num = num // 10

        # need to reverse the list as hundreds, tens, units
        return res[::-1]


test_array = [1, 2, 3, 9]


def test1():
    sol = Solution1()
    print(sol.plusOne(test_array))


def test2():
    sol = Solution2()
    print(sol.plusOne(test_array))


if __name__ == '__main__':
    test1()
    test2()
