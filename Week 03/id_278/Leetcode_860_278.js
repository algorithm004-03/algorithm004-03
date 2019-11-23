/**
 * 860. Lemonade Change
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    const changes = {
        5: 0,
        10: 0
    };
    
    for (const bill of bills) {
        if (bill === 5) {
            changes['5'] ++;
        } else {
            if (changes['5'] === 0) {
                return false;
            } else {
                if (bill === 10) {
                    changes['10'] ++;
                    changes['5'] --;
                } else {
                    if (changes['10'] === 0) {
                        changes['5'] -= 3;
                    } else {
                        changes['10'] --;
                        changes['5'] --;
                    }
                }
            }
        }
        
        if (changes['5'] < 0 || changes['10'] < 0) {
            return false;
        }
    }
    
    return true;
};
