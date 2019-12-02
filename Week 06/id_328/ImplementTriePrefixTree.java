class Trie {
	    private TrieNode root;
	    public Trie() {
	        root = new TrieNode();
	    }
	    public void insert(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            char currentChar = word.charAt(i);
	            if (!node.containsKey(currentChar)) {
	                node.put(currentChar, new TrieNode());
	            }
	            node = node.get(currentChar);
	        }
	        node.setEnd();
	    }
	    
	    public boolean search(String word) {
	    	 TrieNode node = searchPrefix(word);
	    	 if(node != null && node.isEnd()) {
	    		 return true;
	    	 }else {
	    		 return false;
	    	 }
	    }
	    
	    public boolean startsWith(String prefix) {
		   return searchPrefix(prefix) != null;
	    }
	    
	    private TrieNode searchPrefix(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	           char curLetter = word.charAt(i);
	           if (node.containsKey(curLetter)) {
	               node = node.get(curLetter);
	           } else {
	               return null;
	           }
	        }
	        return node;
	    }
	}

class TrieNode {
	    private TrieNode[] links;
	    private final int R = 26;
	    private boolean isEnd;
	    public TrieNode() {
	        links = new TrieNode[R];
	    }
	    public boolean containsKey(char ch) {
	        return links[ch -'a'] != null;
	    }
	    public TrieNode get(char ch) {
	        return links[ch -'a'];
	    }
	    public void put(char ch, TrieNode node) {
	        links[ch -'a'] = node;
	    }
	    public void setEnd() {
	        isEnd = true;
	    }
	    public boolean isEnd() {
	        return isEnd;
	    }
	}