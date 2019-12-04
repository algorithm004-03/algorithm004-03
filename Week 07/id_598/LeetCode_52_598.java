/**
 * @author northleaf
 * @create 2019年11月26日
 */
public class LeetCode_52_598 {
    int size;
    int count;

    public int totalNQueens(int n) {
        count = 0 ;
        //size的意思就是：1向右移到n位，再减1
        //比中n=8，1向右移动8位，再减1，就是：11111111
        size = (1<<n) -1;

        solve(0,0,0);

        return count;
    }


    private void solve(int row, int pie, int na) {
        //终止条件，row的值与size相等，row就是11111111（如果n为8的话）
        if(row == size){
            count++;
            return;
        }
        //查当前可以用的位置
        //使用size与表示把范围限制在size之内
        //row,pie,na分别代表可以被攻击的列，撇，捺，1代表被攻击，0表示未被攻击
        //row,pie,na相或的意思是：将三个被攻击的位置合并
        //row,pie,na或后再取反的意思是：求出未被攻击的位
        //pos中为1的位置表示不被攻击的位置
        int pos = size & (~(row|pie|na));
        //如果pos不为0，说明还有未被攻击的地方
        while (pos!=0){
            //针对pos中为1的位置进行试探
            int p = pos & (-pos);
            pos = pos - p;
            //递归求解
            solve(row|p,(pie|p)<<1,(na|p)>>1);
        }

    }
}
