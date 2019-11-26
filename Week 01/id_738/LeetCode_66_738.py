class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        pl = 1
        for i in range(1, len(digits) + 1):
            if digits[-i] + pl >= 10:
                digits[-i] = digits[-i] + pl - 10
                pl = 1
            else:
                digits[-i] += pl
                pl = 0
                break
        if pl == 1:
            digits.insert(0, 1)
        return digits
        