class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

      # -----------Method 1---------------
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

      # -----------Method 2---------------
      # results = collections.defaultdict(list)
      # for item in strs:
      #   results["".join(sorted(item))].append(item)

      # -----------Method 3---------------
      results = {}
      sort_str = lambda x : "".join(sorted(x))
      for item in strs:
        sorted_item = sort_str(item)
        if sorted_item not in results:
          results[sorted_item] = []
          results[sorted_item].append(item)  # 如果没有包含在结果中要添加自身
        else:
          results[sorted_item].append(item)
          
      return results.values()
