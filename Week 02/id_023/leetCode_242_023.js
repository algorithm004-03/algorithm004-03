/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
  const map = new Map()
  for (let i = 0; i < s.length; i++) {
    const getMap = map.get(s[i])
    if (!getMap) {
      map.set(s[i], 1)
    } else {
      map.set(s[i], getMap + 1)
    }
  }

  for (let i = 0; i < t.length; i++) {
    const getMap = map.get(t[i])
    if (getMap === 1) {
      map.delete(t[i])
    } else if (getMap) {
      map.set(t[i], getMap - 1)
    } else {
      map.set(t[i], 1)
    }
  }

  if (map.size) {
    return false
  } else {
    return true
  }
};