/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if (heights.length <= 0) {
        return 0;
    }

    return findMaxS(0, heights.length - 1);

    function findMaxS(L, R){
        var minK = findMinH(L, R);
        var max = heights[minK] * (R - L + 1);

        if (minK > L) {
            var SL = findMaxS(L, minK - 1);
            SL > max && (max = SL);
        }

        if (minK < R) {
            var SR = findMaxS(minK + 1, R);
            SR > max && (max = SR);
        }

        return max;
    }

    // 方法待优化
    function findMinH(L, R){
        var min = heights[L], minK = L;

        for (var i = L + 1; i <= R; ++i) {
            if (heights[i] < min) {
                min = heights[i];
                minK = i;
            }
        }

        return minK;
    }
};
