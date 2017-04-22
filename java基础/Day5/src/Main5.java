import com.rupeng.game.GameCore;

public class Main5 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		//练习：大于18岁显示一张图片和音乐
		int age = Integer.parseInt(GameCore.input("","输入年龄")); //注意哦，这里需要转换成int类型的
		int picNum = 0;
		GameCore.createImage(picNum);
		GameCore.setImagePosition(picNum, 100, 100);
		GameCore.setImageSource(picNum, age>=18?"1.jpg":"2.jpg");
		GameCore.playSound(age>=18?"1.mp3":"2.mp3", true);
		GameCore.pause(50000);
		*/
		//练习：小于10岁显示5图片，大于等于10岁小于18岁显示2图片，大于等于18岁小于80岁显示4图片，大于等于80岁显示3图片 
		int age = Integer.parseInt(GameCore.input("","输入年龄"));
		int picNum = 0;
		GameCore.createImage(picNum);
		GameCore.setImagePosition(picNum, 100, 100);
		GameCore.setImageSource(picNum, age>=18?(age>=80?"3.png":"4.png"):(age>=10)?"2.jpg":"5.jpg");
		GameCore.pause(50000);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Main5()); 
	}

}
