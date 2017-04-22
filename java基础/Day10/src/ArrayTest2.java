
public class ArrayTest2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		//颠倒数组
		int[] nums = {1,2,5,7,8};
		for (int i = 0; i < nums.length/2; i++) {
			int temp = nums[i];
			int temp1 = nums[nums.length-i-1];//第i个和第length-i-1个交换
			nums[i] = temp1;
			nums[nums.length-i-1] = temp;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		*/
		
		/*
		//数组中的最大值
		int[] numMax = {5,6,99,1,10};
		int max = numMax[0];  //假设最开始的最大值为数组中第一个元素
		for (int i = 1; i < numMax.length; i++) {  //注意这里的遍历从标号为1的元素开始！！
			int n = numMax[i];
			if (max < numMax[i]) {
				System.out.println("n="+n+"，比max="+max+"大，让max的值为n");
				max = numMax[i];  //更新最大值
				System.out.println("max变成了"+max);
			}
			else {
				System.out.println("n="+n+"，不比max="+max+"大，max的值继续为"+max);
			}
		}
		System.out.println("最大值为"+max);
		*/
		
		
		//数组中的最小值
		int[] numMin = {2,3,-8,1,0};
		int min = numMin[0];
		for (int i = 1; i < numMin.length; i++) {
			if (min > numMin[i]) {
				min = numMin[i];
			}
		}
		System.out.println("最小值为"+min);
	}

}
