/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    var result = [];
    var n = 0;

    while (n <= num){
        result.push(n.toString(2).replace(/0/g, "").length)
        ++n;
    }

    return result;
};
