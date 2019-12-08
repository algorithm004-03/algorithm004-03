/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if (!intervals || !intervals.length) return []; 
    let len = intervals.length,
        i = 0,
        result =[];
    intervals.sort(function (a, b) {
        return a[0] - b[0];
    });
    while (i < len){
        let currLeft = intervals[i][0];
        let currRight = intervals[i][1];
        while(i < len - 1 && intervals[i+1][0] <= currRight){
            i++;
            currRight = Math.max(intervals[i][1], currRight);
        }
        result.push([currLeft,currRight]);
        i++;
    }
    return result;
};

console.log(merge([[1, 3], [2, 6], [8, 10], [15, 18]]));