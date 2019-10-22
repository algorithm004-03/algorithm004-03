class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
      # strs_sorted = ["".join(sorted(item)) for item in strs]
      # print(strs_sorted)
      # results = []
      # results_idx = []
      # idxs = set()
      # for i in range(len(strs)):
      #   result = []
      #   if i in idxs:
      #     continue
      #   result.append(i)
      #   for j in range(1, len(strs)):
      #     if j in idxs:
      #       continue
      #     if strs[i] == strs[j] or "".join(sorted(strs[i])) == "".join(sorted(strs[j])):
      #       result.append(j)
      #       idxs.add(j)
      #   results.append(result)
        # results_idx.append(result)
      # for idx in results_idx:
      #   res = []
      #   for lidx in set(idx):
      #     res.append(strs[lidx])
      #   results.append(res)
      results = collections.defaultdict(list)
      for item in strs:
        results["".join(sorted(item))].append(item)
          
      return results.values()
