/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s.length % 2) {
        return false;
    }

    var map = { "(": ")", "[": "]", "{": "}" };
    var sArr = s.split("");
    var stack = [];
    var half = s.length / 2;

    for (var i = 0; i < sArr.length; ++i) {
        if (sArr[i] in map) {
            stack.push(map[sArr[i]]);

            if (stack.length > half) {
                return false;
            }
        }
        else {
            if (stack.pop() !== sArr[i]) {
                return false;
            }
        }
    }

    return stack.length === 0;
};
