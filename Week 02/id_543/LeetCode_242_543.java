class Solution {

    //哈希表 43ms
    public boolean isAnagram(String s, String t) {
        if(s==null&&t==null){
            return true;
        }
        if(s.isEmpty()&&t.isEmpty()){
            return true;
        }
        if(s.length()!=t.length()){
            return false;
        }
        boolean result = true;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Map<Character,Integer> resultMap = new HashMap<Character,Integer>();
        for(int i = 0;i<schar.length;i++){
            if(resultMap.containsKey(schar[i])){
                resultMap.put(schar[i],resultMap.get(schar[i])+1);
            }else{
                resultMap.put(schar[i],1);
            }
        }
        for(int j = 0;j<tchar.length;j++){
            if(resultMap.containsKey(tchar[j])){
                resultMap.put(tchar[j],resultMap.get(tchar[j])-1);
            }else{
                resultMap.put(tchar[j],-1);
            }
        }

        for(Integer value : resultMap.values()){
            if(value != 0){
                result = false;
                break;
            }
        }
        return result;
    }

    //排序比较 4ms
    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar,tchar);
    }

    //计数器 5ms
    public static boolean isAnagram2(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}