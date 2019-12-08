// https://leetcode-cn.com/problems/trapping-rain-water/

/**
 * @param {number[]} height
 * @return {number}
 */
// 暴力破解 时间复杂度O(n^2) 空间复杂度O(1)
var trap = function(height) {
    var length = height.length,
        ans = 0;
    for (var i = 1; i < length - 1; i++) {
        var maxLeft = 0,
            maxRight = 0;
        for (var j = i; j >= 0; j--) {
            maxLeft = Math.max(maxLeft, height[j])
        }
        for (var j = i; j < length; j++) {
            maxRight = Math.max(maxRight, height[j])
        }
        ans += Math.min(maxLeft, maxRight) - height[i]
    }
    return ans;
};

/**
 * @param {number[]} height
 * @return {number}
 */
// 遍历存储每个格子的左边最高墙和右边最高强 时间复杂度O(n) 空间复杂度O(n)
var trap = function(height) {
    var length = height.length,
        ans = 0,
        maxLeft = [],
        maxRight = [];
    maxLeft[0] = height[0];
    for (var i = 1; i < length; i++) {
        maxLeft[i] = Math.max(height[i], maxLeft[i - 1])
    }
    maxRight[length - 1] = height[length - 1]
    for (var i = length - 2; i >= 0; i--) {
        maxRight[i] = Math.max(height[i], maxRight[i + 1])
    }
    for (var i = 1; i < length - 1; i++) {
        ans += Math.min(maxLeft[i], maxRight[i]) - height[i]
    }
    return ans;
};

/**
 * @param {number[]} height
 * @return {number}
 */
// 使用栈
var trap = function(height) {
    var length = height.length,
        ans = 0,
        current = 0,
        stack = [];
    while (current < height.length) {
        while (stack.length > 0 && (height[current] > height[stack.top()])) {
            var top = stack.top();
            stack.pop();
            if(stack.length <= 0) break;
            var instance = current - stack.top() - 1;
            var boundedHeight = Math.min(height[current], height[stack.top()]) - height[top];
            ans += instance * boundedHeight;
        }
        stack.push(current++)
    }
    return ans;
};

Array.prototype.top = function () {
    return this[this.length - 1]
}

var arr = [0,1,0,2,1,0,1,3,2,1,2,1];
var result = trap(arr);
console.log(result)