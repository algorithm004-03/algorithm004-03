/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    var box = [];
    box[5] = 0;
    box[10] = 0;
    box[20] = 0;

    for (var i = 0; i < bills.length; ++i) {
        if (bills[i] === 5) {
            ++box[5];
        }
        else if (bills[i] === 10) {
            if (box[5] > 0) {
                --box[5];
            }
            else {
                return false;
            }

            ++box[10];
        }
        else if (bills[i] === 20) {
            if (box[10] > 0 && box[5] > 0) {
                --box[10];
                --box[5];
            }
            else if (box[5] > 2) {
                box[5] -= 3;
            }
            else {
                return false;
            }

            ++box[20];
        }
    }

    return true;
};
