var longestValidParentheses = function(s) {
  let maxans = 0;
  let stackArr = [-1];
  for (let i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      stackArr.push(i);
    } else {
      stackArr.pop();
      if (stackArr.length === 0) {
        stackArr.push(i);
      } else {
        maxans = Math.max(maxans, i - stackArr[stackArr.length - 1]);
      }
    }
  }
  return maxans;
};
