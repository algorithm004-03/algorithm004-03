/**
 * @author eazonshaw
 * @date 2019/12/5  10:18
 */
public class LeetCode_14_243 {

    //垂直扫描
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        for(int i = 0;i < strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(i == strs[j].length() || c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
