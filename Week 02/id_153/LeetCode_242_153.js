const isAnagram1 = (s, t) => {
  let sArr = s.split("");
  let tArr = t.split("");
  sArr.sort();
  tArr.sort();
  return sArr + "" === tArr + "";
};

const isAnagram2 = (s, t) => {
  const map = new Map();
  for (let i = 0; i < s.length; i++) {
    if (map.has(s[i])) {
      map.set(s[i], map.get(s[i]) + 1);
    } else {
      map.set(s[i], 1);
    }
  }

  for (let i = 0; i < t.length; i++) {
    if (map.has(t[i])) {
      map.set(t[i], map.get(t[i]) - 1);
    } else {
      map.set(t[i], 1);
    }

    if (map.get(t[i]) === 0) {
      map.delete(t[i]);
    }
  }
  if (map.size !== 0) {
    return false;
  }
  return true;
};
