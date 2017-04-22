package test;

import com.rupeng.game.GameCore;

public class elseIf implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		String name = GameCore.input("", "love who?");
		int nameNum = 2;
		if (name.equals("1")) {
			GameCore.createImage(nameNum);
			GameCore.setImageSource(nameNum, "1.jpg");
			
		}
		else if (name.equals("2")) {
			GameCore.createImage(nameNum);
			GameCore.setImageSource(nameNum, "2.jpg");
			
		}
		else if (name.equals("3")) {
			GameCore.createImage(nameNum);
			GameCore.setImageSource(nameNum, "3.png");
			
		}
		else if (name.equals("4")) {
			GameCore.createImage(nameNum);
			GameCore.setImageSource(nameNum, "4.png");
			
		}
		else{
			GameCore.createImage(nameNum);
			GameCore.setImageSource(nameNum, "5.jpg");
			
		}
		
		GameCore.pause(10400);
		*/
	
		
		/*
		String season = GameCore.input("", "输入月份");
		int mouth = Integer.parseInt(season);
		if (mouth==1||mouth==2||mouth==12) {
			GameCore.alert("冬天");
		}
		else if (mouth==3||mouth==4||mouth==5) {
			GameCore.alert("春天");
		}
		else if (mouth==6||mouth==7||mouth==8) {
			GameCore.alert("夏天");
		}
		else if(mouth==9||mouth==10||mouth==11){
			GameCore.alert("秋天");
		}
		else if (mouth%3 == 0) {
			GameCore.alert("被3整除"); //当输入9时，那么这条语句还是不会执行，因为如果匹配了上面的一个条件，那么下面的else if 条件就是满足也不会执行，遵循“先来后到”
		}
		else {
			GameCore.alert("error input!");
		}
		*/
		/*
		int i = 0;
		int  j = 900;
		
		if (i > 0) {
			if (j > 0) {
				GameCore.alert("i是正数，j是正数");
			}
			else{
				GameCore.alert("i是正数，j不是正数");
			}
		}
		else {
			if (j > 900) {
				GameCore.alert("i不是正数，j是正数并且大于900");
			}
			else {
				GameCore.alert("i不是正数，j是正数并且小于等于900");
			}
		}
		*/
		
		/*
		int age = 0;
		if (age > 18) {
			System.out.println("成年人");
		}
		else{
			System.out.println("未成年人");
		}
		System.out.println(age>18?"成年人":"未成年人");
		*/
		
		/*
		int age = Integer.parseInt(GameCore.input("", "输入年龄"));
		int imgNum = 0;
		GameCore.createImage(imgNum);
		GameCore.setImageSource(imgNum, age>18?"1.jpg":"2.jpg"); //和下面的if语句一样的效果
		
//		if (age > 18) {
//			GameCore.createImage(imgNum);
//			GameCore.setImageSource(imgNum, "1.jpg");
//		}
//		else {
//			GameCore.createImage(imgNum);
//			GameCore.setImageSource(imgNum, "2.jpg");
//		}
		
		GameCore.pause(5000);
		*/
		
		
		
		
		
	}

	public static void main(String[] args) {
		// DO Auto-generated method stub
		GameCore.start(new elseIf());
	}

}
