/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let max = 0, x1, x2, current, min, prevHeight;

    for (x1 = 0; x1 < height.length - 1; ++x1) {
        for (x2 = height.length - 1; x2 >= x1 + 1; --x2) {
            if (height[x1] <= prevHeight) {
                continue;
            }

            min = height[x1] > height[x2] ? height[x2] : height[x1];
            max = Math.max(max, min * (x2 - x1));
            prevHeight = min;
        }
    }

    return max;
};

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    var max = 0, x1 = 0, x2 = height.length - 1, current, low;

    while (x1 < x2) {
        low = height[x1] > height[x2] ? height[x2] : height[x1];
        current = low * (x2 - x1);
        max = max > current ? max : current;

        if (height[x1] >= height[x2]) {
            --x2;
        }
        else if (height[x1] < height[x2]) {
            ++x1;
        }
    }

    return max;
};
