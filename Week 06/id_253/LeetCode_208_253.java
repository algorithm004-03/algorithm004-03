class TrieNode{
    private TrieNode[] linkes;
    private final int R = 26;
    private boolean isEnd;
    public TrieNode(){
        linkes = new TrieNode[R];
    }
    public boolean containsKey(char ch){
        return linkes[ch-'a'] != null;
    }
    public TrieNode get(char ch){
        return linkes[ch-'a'];
    }
    public void put(char ch , TrieNode node){
        linkes[ch-'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;   
        for(int i =0  ; i<word.length() ; i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i =0 ; i<word.length() ; i++){
            char curLetter = word.charAt(i);
            if(node.containsKey(curLetter)){
                node = node.get(curLetter);
            }else{
                return null;
            }
        }
        return node;
    }
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node !=null && node.isEnd();
    }
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
