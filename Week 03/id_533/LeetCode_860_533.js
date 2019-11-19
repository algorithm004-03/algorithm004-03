// https://leetcode-cn.com/problems/lemonade-change/

/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    var five = 0,
        ten = 0;
    for (bill of bills) {
        if (bill === 5) {
            five++;
        } else if (bill === 10) {
            if (five === 0) return false;
            five--;
            ten++;
        } else {
            if (five > 0 && ten > 0) {
                five--;
                ten--;
            } else if(five >= 3) {
                five -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
};

console.log(lemonadeChange([5,5,5,10,20]))
console.log(lemonadeChange([5,5,10,10,20]))