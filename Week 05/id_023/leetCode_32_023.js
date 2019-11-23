/**
 * @param {string} s
* @return {number}
*/
var longestValidParentheses = function (s) {
  var max = 0;
  function isValid(str) {
    var stack = ['#'];
    for (var i = 0; i < str.length; i++) {
      if (str[i] == '(') {
        stack.push('(');
      } else {
        var topEle = stack.pop();
        if (topEle != '(') {
          return false;
        }
      }
    }
    return stack.length == 1;
  }
  for (var i = 0; i < s.length; i++) {
    for (var j = i + 2; j <= s.length; j += 2) {
      if (isValid(s.slice(i, j))) {
        max = Math.max(max, j - i);
      }
    }
  }
  return max;
};
