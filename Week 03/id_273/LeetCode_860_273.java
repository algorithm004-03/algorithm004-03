//860. 柠檬水找零

//解法1：创建一个数组, index=0表示拥有的5块钱的张数, index=1表示拥有的10块钱的张数
//		 根据贪心算法的思想：如果收到20块钱, 首先确定是否拥有10块钱, 若有找零10+5, 若没有找零3*5
//时间复杂度O(n)
//空间复杂度O(1)
public boolean lemonadeChange(int[] bills) {
	int[] money = new int[2];// 0-5 1-10
	for (int i : bills) {
		if (i == 5) money[0]++;
		else if (i == 10) { money[1]++; money[0]--; }
		else {
			if (money[1] > 0) { money[1]--; money[0]--; }
			else money[0] -= 3;
		}
		if (money[0] < 0) return false;
	}
	return true;
}