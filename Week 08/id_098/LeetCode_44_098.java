class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length(),i_start=-1,j_start=-1,i=0,j=0;
        while(i<m) {
            if(j<n&&p.charAt(j)=='*') {
                j_start=j;
                i_start=i;
                j++;
            }
            else if(j<n&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')) {
                i++;
                j++;
            }
            else if(j_start>-1){
                j=j_start;
                i=i_start+1;
            }
            else {
                return false;
            }
        }

        while(j<n&&p.charAt(j)=='*') j++;
        return j==n;
    }
}