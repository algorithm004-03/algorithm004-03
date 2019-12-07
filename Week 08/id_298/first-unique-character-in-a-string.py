class Solution:
    def firstUniqChar(self, s: str) -> int:
      temp_dict = {}
      chs = []
      result = None
      if s == "": return -1
      for idx, ch in enumerate(s):
        chs.append(ch)
        if ch not in temp_dict:
          temp_dict[ch] = 1
        else:
          temp_dict[ch] += 1
      for idx, ch in enumerate(chs):
        if temp_dict[ch] == 1:
          result = idx
          break
      return -1 if result is None else result
