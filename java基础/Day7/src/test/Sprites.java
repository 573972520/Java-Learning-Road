package test;

import com.rupeng.game.GameCore;

public class Sprites implements Runnable {

	//根据性别选择图片（两种方法）
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		boolean b =GameCore.confirm("sex");
		int marioNum = 1; //统一变量
		System.out.println(b);
		if (b == true) {
			GameCore.createSprite(marioNum, "guizi");
			GameCore.playSpriteAnimate(marioNum, "jump", true);
			GameCore.pause(2000);
			//System.out.println("11");
		}else {
			GameCore.createSprite(marioNum, "bomb");
			GameCore.playSpriteAnimate(marioNum, "fire", true);
			GameCore.pause(2000);
			//GameCore.alert("223");
		}
		*/
		
		
		String s = GameCore.input("", "are you sex?");
		int marioNum = 1;
		System.out.println(s);
		if (s.equals("man")) {     //特别注意判断String类型要使用equals() !!!
			GameCore.createSprite(marioNum, "guizi");
			GameCore.playSpriteAnimate(marioNum, "jump", true);
			GameCore.pause(2000);
		}else {
			GameCore.createSprite(marioNum, "bomb");
			GameCore.playSpriteAnimate(marioNum, "fire", true);
			GameCore.pause(2000);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Sprites());
	}

}
