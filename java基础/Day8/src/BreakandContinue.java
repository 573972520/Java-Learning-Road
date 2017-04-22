import java.util.Scanner;

import com.rupeng.game.GameCore;

public class BreakandContinue implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		for (int i = 0; i < 5; i++) {
			System.out.println("i="+i);
			if (i == 2) {
				break; //提前退出for循环
			}
			System.out.println(i);
		}
		System.out.println("Over");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("i="+i);
			if (i == 2) {
				continue; //在本次for循环中，循环体中之后的代码不执行，即下面的System.out.println(i)不执行了
			}
			System.out.println(i);
		}
		System.out.println("Over");
		*/
		
		//int inputNum = Integer.parseInt(GameCore.input("", "input number"));
		

		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (j == 2) {
					//break; //j==2之后的数字全部不显示
					continue;//只是不显示j==2
				}
				System.out.println("i="+i+",j="+j);
			}
		}
		*/
		
		//连续输入数字，直到输入OK的时候，停止输入，然后返回总和（在BreakandContinueTest中有另外一种方法）
		int sum = 0;
		for(;;){
			String s = GameCore.input("", "input number");
			if (s.equals("ok")) {
				break;
			}
			else {
				int i = Integer.parseInt(s);
				if (i < 0) {
					continue;
				}
				sum += i;
			}
		}
		System.out.println(sum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new BreakandContinue());
		
		
	}

}
