class Solution:
    def plusOne(self, digits):
        digits[-1] += 1
        for i in range(len(digits) - 1, 0, -1):
            if digits[i] == 10:
                if i != 0:
                    digits[i - 1] += 1
                    digits[i] = 0
                elif digits[0] == 10:
                    digits[0:1] = [1, 0]
        return digits
