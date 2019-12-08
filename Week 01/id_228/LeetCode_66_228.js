/**
 * @param {number[]} digits
 * @return {number[]}
 */

/** 
 * 由于大数组精度丢失问题，该解法不能解决数据过大的问题
*/
var plusOne = function(digits) {
    return `${digits.join('') + 1}`.split('')
};

/** 
 * 逆序遍历，然后+1，如果+1后大于10，则继续遍历，进一位，否则直接return当前数组，如果遍历到最后，则表示首位也要进1
 */
var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        ++digits[i]
        if (digits[i] < 10) {
            return digits
        } else {
            digits[i] = digits[i] % 10
        }
    }
    arr[0] = arr[0] % 10
    arr.unshift(1)
};