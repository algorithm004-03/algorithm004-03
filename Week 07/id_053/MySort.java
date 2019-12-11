import java.util.Arrays;

/**
 * @author rongsimin
 * @date 2019/12/8 22:41
 */
public class MySort {
	public static int[] bubbleSort(int[] params){
		for (int i = 0;i < params.length;i++) {
			for (int j = i;j < params.length-1;j++){
				if (params[j] > params[j+1]) {
					int temp = params[j];
					params[j] = params[j+1];
					params[j+1] = temp;
				}
			}
		}
		return params;
	}

	public static int[] selectionSort(int[] params){
		int minIndex,temp;
		for (int i = 0;i < params.length; i++){
			minIndex = i;
//			temp = params[minIndex];
			for (int j = i+1;j < params.length - 1;j++){
				if (params[minIndex] > params[j]){
					minIndex = j;
				}
				temp = params[minIndex];
				params[minIndex] = params[j];
				params[j] = temp;
			}
		}
		return params;
	}

	public static void main(String[] args) {
		int[] params = {-1,-5,-3,4,6,9,8,0};
//		params = bubbleSort(params);
		params = selectionSort(params);
		System.out.println(Arrays.toString(params));

	}
}
