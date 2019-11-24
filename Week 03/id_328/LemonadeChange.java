public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0 ;
        int tenCount = 0;
        
        for(int i = 0 ; i < bills.length ; i ++){
            if(bills[i] == 5){
                fiveCount++;
            }else if(bills[i] == 10){
                if (fiveCount > 0){
                    tenCount++;
                    fiveCount--;
                }else {
                    return false;
                }
            }else {
                if(tenCount >0 && fiveCount >0){
                    tenCount --;
                    fiveCount --;
                }else if(fiveCount > 2){
                    fiveCount -= 3;
                }else{
                    return false;
                }
            }
        }
        
        return true;
        
    }
}