class Solution:
    def myAtoi(self, str: str) -> int:
        new_str = str.strip()
        if len(new_str) == 0:
            return 0
        tmp = "0"
        result = 0
        i = 0
        if new_str[0] in "-+":
            tmp = new_str[0]
            i = 1
        for i in range(i, len(new_str)):
            if new_str[i].isdigit():
                tmp += new_str[i]
            else:
                break
        if len(tmp) > 1:
            result = int(tmp)
        result = max(result, -(2 ** 31))
        result = min(result, 2 ** 31 - 1)
        return result


# 使用i控制第一位
