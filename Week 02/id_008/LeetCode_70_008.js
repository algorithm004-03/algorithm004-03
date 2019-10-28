/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    var t = Math.sqrt(5);
    return Math.round(1/t * (Math.pow((1+t)/2, n+1) - Math.pow((1-t)/2, n+1)));
};

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n < 2) {
        return 1;
    }

    var a = 1;
    var b = 1;

    for (var i = 1; i < n; ++i) {
        b += a;
        a = b - a;
    }

    return b;
};

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    switch(n){
        case 0: return 1;
        case 1: return 1;
        case 2: return 2;
        case 3: return 3;
        case 4: return 5;
        case 5: return 8;
        case 6: return 13;
        case 7: return 21;
        case 8: return 34;
        case 9: return 55;
        case 10: return 89;
        case 11: return 144;
        case 12: return 233;
        case 13: return 377;
        case 14: return 610;
        case 15: return 987;
        case 16: return 1597;
        case 17: return 2584;
        case 18: return 4181;
        case 19: return 6765;
        case 20: return 10946;
        case 21: return 17711;
        case 22: return 28657;
        case 23: return 46368;
        case 24: return 75025;
        case 25: return 121393;
        case 26: return 196418;
        case 27: return 317811;
        case 28: return 514229;
        case 29: return 832040;
        case 30: return 1346269;
        case 31: return 2178309;
        case 32: return 3524578;
        case 33: return 5702887;
        case 34: return 9227465;
        case 35: return 14930352;
        case 36: return 24157817;
        case 37: return 39088169;
        case 38: return 63245986;
        case 39: return 102334155;
        case 40: return 165580141;
        case 41: return 267914296;
        case 42: return 433494437;
        case 43: return 701408733;
        case 44: return 1134903170;
        case 45: return 1836311903;
    }

    return 1;
};

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    return [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903][n];
};
