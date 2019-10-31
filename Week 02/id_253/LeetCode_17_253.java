class Solution {
    List<String> ans = new LinkedList<String>();
    public void search(String s ,String digits,int i,Map<Character,String> map){
        if(i == digits.length()){
            ans.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for(int j=0;j<letters.length();j++){
            search(s+letters.charAt(j),digits,i+1,map);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits == null) return new ArrayList<String>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        search("",digits,0,map);
        return ans;
    }
}
