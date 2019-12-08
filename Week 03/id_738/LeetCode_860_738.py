class Solution(object):
    def lemonadeChange(self, bills):
        """
        柠檬水找零：https://leetcode-cn.com/problems/lemonade-change/description/

        :type bills: List[int]
        :rtype: bool
        """
        five = ten = 0
        for bill in bills: #找零0
            if bill == 5: # 5直接收下
                five += 1
            elif bill == 10: #找零5
                if five > 0: # 要求身上5的个数>0才能找零
                    five -= 1
                    ten += 1
                else:
                    return False 
            elif bill == 20: #找零15
                #这个分多个情况分析
                if 5 * five + 10 * ten < 15: #身上零钱少于20，失败
                    return False
                if five <= 0: # 身上如果没有5，失败，因为找零15必须里面有个5
                    return False
                if ten <= 0: # 来到这个if表示身上钱大于等于20，而且至少有一个5，这个判断表示身上没有10，都是5，那么直接找零3张5
                    five -= 3
                if ten > 0: # 来到这个if表示身上钱大于等于20，而且至少有一个5，这个判断表示身上有10，那么直接找零1张10和一张5
                    five -= 1
                    ten -= 1
                    #20不能找任何零，不计入
        return True
    
