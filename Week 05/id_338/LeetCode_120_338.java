import java.util.List;

/**
 * @author Leesen
 * @date 2019/11/17 23:09
 * @Link https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minLen = new int[row+1];  //第i行有i+1个值
        for (int level=row-1; level>=0; level--) {
            for (int i=0; i<=level; i++) {
                minLen[i] = Math.min(minLen[i], minLen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minLen[0];
    }
}
