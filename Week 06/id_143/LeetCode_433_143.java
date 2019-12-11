import java.util.Arrays;
import java.util.HashSet;
/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> geset = new HashSet<String>(Arrays.asList(bank));
        if (!geset.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        HashSet<String> positve = new HashSet<String>();
        positve.add(start);
        HashSet<String> negative = new HashSet<String>();
        negative.add(end);
        HashSet<String> tempNewSet = new HashSet<String>();
        int step = 0;
        while (positve.size() > 0 && negative.size() > 0) {
            step++;
            if(positve.size() > negative.size()){
                HashSet<String> temp = new HashSet<String>(positve);
                positve = negative;
                negative = temp;
            }
            for(String item:positve){
                String str;
                char[] tempStringChars = item.toCharArray();
                for (int i= tempStringChars.length-1;i >= 0;--i){
                    char oldChar = tempStringChars[i];
                    for(int j=0;j<4;++j){
                        tempStringChars[i] = four[j];
                        String newString = new String(tempStringChars);
                        if(negative.contains(newString)){
                            return step;
                        } else if(geset.contains(newString)){
                            geset.remove(newString);
                            tempNewSet.add(newString);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
            positve = new HashSet<String>(tempNewSet);
            tempNewSet.clear();
        }
        return -1;
    }
}
// @lc code=end

