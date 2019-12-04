class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int n;
    int k;
    public void backtrack(int first , LinkedList<Integer> curr){
        if(curr.size()== k) ans.add(new LinkedList(curr));
        for(int i=first ; i<=n;i++){
            curr.add(i);
            backtrack(i+1,curr);
            curr.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        backtrack(1, new LinkedList<Integer>());
        return ans;
    }
}
