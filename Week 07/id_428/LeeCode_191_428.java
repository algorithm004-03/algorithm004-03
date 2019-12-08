
class Solution {
    public int hammingWeight(int n) {
        int num=0;
        for (int i= 0;i<32;i++) {
            if ((n >> i & 0x01) == 1) {
                num++;
            }
        }
        return num;
    }
	
}