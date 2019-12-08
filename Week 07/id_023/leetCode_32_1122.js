/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let result = [], i = 0, target
  while (true) {
      if (i === 0) {
          i = arr1.length
          target = arr2.pop()
      }
      if (arr1[--i] === target) {
          result.unshift(target)
          arr1.splice(i, 1)
      }
      if (!arr2.length && !i) {
          break
      }
  }
  return result.concat(arr1.sort((a, b) => a - b))
};