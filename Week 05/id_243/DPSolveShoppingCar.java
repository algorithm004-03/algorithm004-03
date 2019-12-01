import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eazonshaw
 * @date 2019/11/13  11:30
 *
 * 用动态规划解决女朋友的双十一购物车问题
 * 题目场景：假设购物的规则是满200减20，要从购物车中选择n个产品，让他们大于且尽量接近于200。
 */
public class DPSolveShoppingCar {

    //所选择的商品列表
    private static List<Integer> shoppingList = new ArrayList<>();

    //假设items[]为商品数组，n为商品数量，w表示满减条件（即题设中的200）
    public static void double11advance(int[] items,int n,int w){

        //这里我们将商品的上线阈值定在w的3倍，建立动态规划的状态表
        int m = 3;
        boolean[][] states = new boolean[n][m*w+1];
        //第一行数据特殊出力
        states[0][0] = true;
        if(items[0]<= m*w){
            states[0][items[0]] = true;
        }
        //动态规划
        for(int i = 1;i<n;i++){
            //第i个商品不加入
            for(int j = 0;j <= m*w;j++){
                if(states[i-1][j]){
                    states[i][j] = true;
                }
            }
            //第i个商品加入
            for(int j = 0;j <= m*w-items[i];j++){
                if(states[i-1][j]){
                    states[i][j+items[i]] = true;
                }
            }
        }
        //计算结果大于w且最小的状态位
        int j;
        for(j = w;j < m*w+1;j++){
            if(states[n-1][j]){
                break;
            }
        }
        //无结果
        if(j == m*w+1){
            return;
        }
        //逆序得到所选择的商品
        for(int i = n-1;i>=1;i--){
            //该商品有列入清单
            if(j >= items[i] && states[i-1][j-items[i]]){
                shoppingList.add(i);
                j = j-items[i];
            }
        }
        if(j != 0) shoppingList.add(0);
    }

    public static void main(String[] args) {
        int[] items = new int[]{30,75,80,70,65,35,45,99};
        int n = items.length;
        int m = 200;
        double11advance(items,n,m);
        shoppingList.stream().sorted().collect(Collectors.toList()).forEach(i -> System.out.println(items[i]));// 75,80,45
    }



}
