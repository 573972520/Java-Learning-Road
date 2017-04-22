import java.awt.Color;

import com.rupeng.game.GameCore;

public class ArrayTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		//int数组转换成String数组
		int[] nums = {123,1456,878};
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			String sValue = Integer.toString(nums[i]);
			strs[i] = sValue;
		}
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		*/
		
		/*
		//数组对应输出
		String[] names = {"王大力","小明","散发"};
		int[] scores = {90,50,70};
		for (int i = 0; i < names.length; i++) {
			String result = names[i];
			System.out.println(result+(scores[i]>80?"优":(scores[i]<60?"不及格":"及格")));
		}
		*/
		
		/*
		//算一个长度相等的int数组逐位和
		int[] num1 = {3,5,8};
		int[] num2 = {5,5,99};
		int[] result = new int[num2.length];
		for (int i = 0; i < num2.length; i++) {
			int num1Value = num1[i];
			int num2Value = num2[i];
			int sum = num1Value+num2Value;
			result[i] = sum;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		*/
		
		/*
		//反向循环输出一个数组的值
		int[] nums = {3,1,9,7,5};
		//方法一
//		for(;;){
//			for (int i = 0; i < nums.length; i++) {
//				int j = nums[nums.length-1-i];
//				GameCore.alert(j);
//			}
//		}
		//方法二
		for(;;){
			for (int i = nums.length-1; i>=0; i--) {
				int j = nums[i];
				GameCore.alert(j);
			}
		}
		*/
		
		/*
		//霓虹灯效果（正向）
		String[] names = {"12","sarf","df","asd"};
		for (int j = 0; j < names.length; j++) {
			String name = names[j];
			GameCore.createText(j, name);
			GameCore.setTextPosition(j, 200, j*100);
		}
		for (int i = 0; i < names.length; i++) {
			//把除了当前的Text之外的Txet颜色变成黑色
			for (int j = 0; j < names.length; j++) {
				if (j != i) {
					GameCore.setTextColor(j, Color.BLACK);
				}
			}
			//把当前的Text变成红色
			GameCore.setTextColor(i, Color.RED);
			if (i == names.length-1) { //数组长度减去1才是下标的最大值 
				i = -1; //从头开始  这里设置为-1是因为在最外面的for循环中i会加1，所以这样会使i等于0，从而使之重新开始
			}
			GameCore.pause(500);
		}
		GameCore.pause(10000);
		*/
		
		
		//霓虹灯效果（正向）
		String[] names = {"12","sarf","df","asd"};
		for (int j = 0; j < names.length; j++) {
			String name = names[j];
			GameCore.createText(j, name);
			GameCore.setTextPosition(j, 200, j*100);
		}
		for (int i = names.length-1; i >= 0; i--) {
			//把除了当前的Text之外的Txet颜色变成黑色
			for (int j = 0; j < names.length; j++) {
				if (j != i) {
					GameCore.setTextColor(j, Color.BLACK);
				}
			}
			//把当前的Text变成红色
			GameCore.setTextColor(i, Color.RED);
			if (i == 0) {
				i = names.length; //从头开始，使i值为数组长度，然后在最外层的for循环中减去1，使之变成下标的最大值
			}
			GameCore.pause(500);
		}
		GameCore.pause(10000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new ArrayTest());
		
	}

}
