/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  if (s.length === 1) {
    return 0;
  }
  let base = ['a', 'b', 'c', 'd', 'e', 'f', 'g',
    'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
    'z'
  ];
  let minIndex = Number.MAX_SAFE_INTEGER, firstIndex;
  for (let i = 0; i < base.length; i++) {
    firstIndex = s.indexOf(base[i]);
    if (firstIndex >= 0 && firstIndex === s.lastIndexOf(base[i])) {
      minIndex = Math.min(minIndex, firstIndex);
    }
  }
  return (minIndex ^ Number.MAX_SAFE_INTEGER) == 0 ? -1 : minIndex;
};