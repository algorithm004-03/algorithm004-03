class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0) return false;
        int five=0;int ten=0;
        if(bills[0] != 5) return false;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5) five++;
            if(bills[i] == 10){
                ten++;
                if(five>0){
                    five--;
                }else{
                    return false;
                }
            }
            if(bills[i] == 20) {
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(ten ==0 && five >2){
                    five-=3;
                }else return false;
            }
        }
        return true;
    }
}
