import java.util.Scanner;

import com.rupeng.game.GameCore;

public class BreakandContinueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); //要求用户输入一行文本，以回车结束
//		System.out.println(s);
//		sc.close();
		int sum = 0;
		for(;;){
			String s = sc.nextLine();
			if (s.equals("ok")) {
				break;
			}
			else {
				int i = Integer.parseInt(s);
				if (i < 0) {
					continue;
				}
				sum = sum+i;
			}
		}
		System.out.println(sum);
		*/
		
		String s = GameCore.input("", "input number");
		int sum = 0;
		for(;;){
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

}
