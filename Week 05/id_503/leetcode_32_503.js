/**
 * DP 方案
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function (s) {

    if (s.length < 2) {
        return 0;
    }
    let maxLen = 0;
    const dp = new Array(s.length).fill(0);
    if (s[0] === "(" && s[1] === ")") {
        maxLen = dp[1] = 2;
    }

    for (let i = 2; i < s.length; i++) {

        if (s[i] === ")") {
            if (s[i - 1] === "(") {

                dp[i] = dp[i - 2] + 2;
                maxLen = Math.max(maxLen, dp[i]);

            } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] === "(") {

                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);

                maxLen = Math.max(maxLen, dp[i]);
            }
        }
    }

    return maxLen;
};

/**
 * 栈方案
 * @param {string} s
 * @return {number}
 */
var longestValidParenthesesWithStack = function (s) {

    if (s.length < 2) {
        return 0;
    }
    let maxLen = 0;
    const stack = [-1] // 首次入栈 -1，方便计算边缘情况 

    for (let i = 0; i < s.length; i++) {

        if (s[i] === "(") {
            stack.push(i);
            continue;
        }

        stack.pop();
        if (stack.length === 0) { // 栈空表示此时的 ")" 无效，进行入栈；比如 "()))" 中的第三个字符
            stack.push(i)
            continue;
        }

        const top = stack[stack.length - 1];
        // 通过计算当前元素下标和栈顶元素下标得到有效字符长度
        // 并对比最大值
        maxLen = Math.max(maxLen, i - top);
    }

    return maxLen;
};