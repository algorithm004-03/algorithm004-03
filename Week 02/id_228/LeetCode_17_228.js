/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  if (digits.length === 0) {
    return [];
  }
  let hashMap = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz"
  };
  let result = [];
  let backtrack = function(combination, nextDigits) {
    if (nextDigits.length === 0) {
      result.push(combination);
    } else {
      let digit = nextDigits.substring(0, 1);
      let letters = hashMap[digit];
      for (let i = 0; i < letters.length; i++) {
        let letter = hashMap[digit].substring(i, i + 1);
        backtrack(combination + letter, nextDigits.substring(1));
      }
    }
  };
  backtrack("", digits);
  return result;
};
