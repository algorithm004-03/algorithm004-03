import java.util.HashMap;
import java.util.Map;

/**
 * @author northleaf
 * @create 2019年11月21日
 */
public class LeetCode_36_598 {
    /**
     * 使用迭代法一次遍历
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //初始化数据，三个：
        // row，column，box
        Map<Integer,Integer>[] rows = new HashMap[9];
        Map<Integer,Integer>[] cols= new HashMap[9];
        Map<Integer,Integer>[] boxs= new HashMap[9];
        for(int i = 0;i<9;i++){
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }

        //以二维数组的形式遍历
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                char ch = board[i][j];
                int num = (int)ch;
                if(ch != '.'){
                    int boxNum = (i / 3) * 3 + j / 3;
                    rows[i].put(num,rows[i].getOrDefault(num,0)+1);
                    cols[j].put(num,cols[j].getOrDefault(num,0)+1);
                    boxs[boxNum].put(num, boxs[boxNum].getOrDefault(num,0)+1);

                    if(rows[i].get(num) > 1 || cols[j].get(num)>1 || boxs[boxNum].get(num)>1 ){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
