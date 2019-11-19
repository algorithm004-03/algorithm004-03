/**
 * 柠檬水找零
 *     在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
	顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
	每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
	注意，一开始你手头没有任何零钱。
	如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @author L
 *
 */
public class LeetCode_860_138 {
	public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills) {
        	if(bill == 5) {
        		five++;
        	}else if(bill == 10) {
        		if(five == 0) {//5美元钞票的个数为0，无法找零 ，返回false
        			return false;
        		}
        		five--;
        		ten++;
        	}else if(bill == 20) {
        		if(five>0 && ten>0) {//收入20bill可以找零
        			five--;
        			ten--;
        		}else if(five >= 3) {//可以找零
        			five = five-3;
        		}else {//上述两种可以找零的情况不存在
        			return false;
        		}
        	}
        }
        return true;
    }
}
