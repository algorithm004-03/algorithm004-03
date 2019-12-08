/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let bucket = {};
  let result = [];

  for (let i = 0; i < arr1.length; i++) {
    if (bucket[arr1[i]]) {
      bucket[arr1[i]]++;
    } else {
      bucket[arr1[i]] = 1;
    }
  }

  for (let j = 0; j < arr2.length; j++) {
    while(bucket[arr2[j]]) {
      result.push(arr2[j]);
      bucket[arr2[j]]--;
    }
  }

  for (const key in bucket) {
    while(bucket[key]) {
      result.push(key);
      bucket[key]--;
    }
  }
  return result
};
