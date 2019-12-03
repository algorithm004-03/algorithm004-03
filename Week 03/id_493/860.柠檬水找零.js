/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let fiveCount = 0;
    let tenCount = 0;
    let twenty = 0;
    for (let bill of bills) {
        // let locBill = 
        if (bill == 5) {
            fiveCount++;
        } else if (bill == 10) {
            tenCount++;
            fiveCount--;
            if (fiveCount < 0) {
                return false;
            }
        } else {
            if (tenCount > 0) {
                tenCount--;
                if (fiveCount > 0) {
                    fiveCount--;
                } else {
                    return false;
                }
            } else {
                if (fiveCount > 2) {
                    fiveCount = fiveCount - 3;
                } else {
                    return false;
                }
            }
            twenty++;
        }
    }
    return true;
};
// @lc code=end

