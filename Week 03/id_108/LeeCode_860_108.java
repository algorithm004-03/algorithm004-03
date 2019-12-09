package study;

/**
 * 
 * @Leecode 860. 柠檬水找零 思路：
 * @link https://www.jianshu.com/p/1e1a9a81bbc0
 * 如果收到5块的，就保存起来
        如果收到10块的，就检查是否有五块的去找零，然后把十块的保存起来
        关键是收到20的，这里就用到贪心算法。
        因为10是5的倍数，一张10块的能做的两张5块的也能做，反过来则不行，所以10的优先级要低于5块的。
        换句话说就是：两张5块的要优于一张10块的。所以我们就要先去检查是否有10块的，然后再去检查5块的
       
       如果是这里的钱数不是5，10，20这种有倍数关系的，而是2，5，9等等这种没什么联系的钱币，就不能用到贪心算法了。
 */
public class LeeCode_860_108 {

	public static boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int bill : bills) {
			if (bill == 5) {
				five++;
			} else if (bill == 10) {
				ten++;
				five--;
				if (five < 0)
					return false;
			} else {
				if (ten > 0) {
					ten--;
					five--;
					if (five < 0)
						return false;
				} else if (five > 0) {
					five = five - 3;  ///?
					if (five < 0)
						return false;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		  @SuppressWarnings("static-access")
		  boolean ret = new LeeCode_860_108().lemonadeChange(new int[] {10,10});
	      System.out.println(ret);
	}

}
