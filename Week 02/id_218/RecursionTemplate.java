package leetcode.week2;

/**
 * @author eason.feng at 2019/10/27/0027 11:21
 **/
public class RecursionTemplate {

    public void recur(int level, int param) {
        //terminator
        int maxLevel = Integer.MAX_VALUE;
        if (level > maxLevel) {
            //process result
            return;
        }

        //process current logic;
        int newParam = param;

        //drill down
        recur(level + 1, newParam);

        //restore current status
    }

}
