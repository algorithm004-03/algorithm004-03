/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }

    var len = matrix.length * matrix[0].length;
    var L = 0;
    var R = len - 1;
    var harf = Math.floor((L + R) / 2);

    while (L <= R) {
        if (L === R) {
            if (N(L) === target) {
                return true;
            }

            return false;
        }

        var n = N(harf);

        if (n > target) {
            R = harf - 1;
        }
        else if (n < target) {
            L = harf + 1;
        }
        else {
            return true;
        }

        harf = Math.floor((L + R) / 2);
    }

    return false;

    function X(k){
        return (k - Y(k)) / matrix[0].length;
    }

    function Y(k){
        return k % matrix[0].length;
    }

    function N(k){
        return matrix[X(k)][Y(k)];
    }
};
