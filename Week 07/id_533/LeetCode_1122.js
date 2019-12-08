// https://leetcode-cn.com/problems/relative-sort-array/

/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {  
    var bucket = {},
        result = [];
    for (var i = 0; i < arr1.length; i++) 
        bucket[arr1[i]] = bucket[arr1[i]] ? ++bucket[arr1[i]] : 1;
    for (var j = 0; j < arr2.length; j++) {
        while (bucket[arr2[j]]) {
            result.push(arr2[j]);
            bucket[arr2[j]]--;
        }
    }
    for(let key in bucket){
        while(bucket[key]){
            result.push(key);
            bucket[key]--;
        }
    }
    return result;
};

console.log(relativeSortArray([2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19],  [2, 1, 4, 3, 9, 6]));