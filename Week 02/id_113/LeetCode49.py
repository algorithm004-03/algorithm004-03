class Solution:
    def groupAnagrams(self, strs):
        word_dict = {}
        for word in strs:
            key = "".join(sorted(word))
            if word_dict.get(key, 0) == 0:
                temp = []
                temp.append(word)
                word_dict[key] = temp
            else:
                word_dict[key].append(word)

        group_list = []
        for key in word_dict:
            group_list.append(word_dict[key])

        return group_list
