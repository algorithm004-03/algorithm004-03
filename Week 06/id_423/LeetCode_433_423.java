class Solution {
	public int minMutation(String start, String end, String[] bank) {
		int[] ans = {Integer.MAX_VALUE};
		helper(start,end,bank,new boolean[bank.length],ans,0);
		return ans[0]==Integer.MAX_VALUE ? -1 : ans[0];
	}
	
	private void helper(String now,String end,String[] bank,boolean[] flag,int[] ans,int res){
		if(now.equals(end)){
			ans[0] = Math.min(ans[0],res);
		}else{
			for(int i =0;i<bank.length;i++){
				if(!flag[i]&&mutation(now,bank[i])){
					flag[i] = true;
					helper(bank[i],end,bank,flag,ans,res+1);
					flag[i] = false;
				}
			}
		}
	}
	
	private boolean mutation(String a,String b){
		int ans = 0;
		for(int i=0;i<8;i++)
			if(a.charAt(i)!=b.charAt(i))
				ans++;
		return ans==1;
	}
}