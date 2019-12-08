public class LeetCode_17_233{
	public List<String> letterCombinations(String digits) {

        if(null==digits||digits.equals("")){
            return new ArrayList<>();
        }

        Map<Character,char[] > dict = new HashMap<>();
        dict.put('2',"abc".toCharArray());
        dict.put('3',"def".toCharArray());
        dict.put('4',"ghi".toCharArray());
        dict.put('5',"jkl".toCharArray());
        dict.put('6',"mno".toCharArray());
        dict.put('7',"pqrs".toCharArray());
        dict.put('8',"tuv".toCharArray());
        dict.put('9',"wxyz".toCharArray());

        char[] chars = digits.toCharArray();
        List<char[] > source = new ArrayList<>();
        for (char c:chars){
            if(dict.containsKey(c)){
                source.add(dict.get(c));
            }
        }
        List<String> result = new ArrayList<>();
        _generate("",source,0,result);

        return result;
    }

    private void _generate(String s, List<char[] > source, int level, List<String> result) {
        if(level==source.size()){
            result.add(s);
            return;
        }

        char[] chars = source.get(level);
        for (int i = 0; i <chars.length ; i++) {
            _generate(s+chars[i],source,level+1,result);
        }
    }
}