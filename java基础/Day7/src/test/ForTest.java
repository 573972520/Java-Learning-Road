package test;


import com.rupeng.game.GameCore;

public class ForTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//从左往右排列精灵，每次新增80个X轴，放8个精灵
//		for (int i = 0; i < 600; i+=80) {
//				GameCore.createSprite(i, "mario"); //在这里要注意精灵的编号不能固定，因为一旦编号固定，接下来的精灵就不能显示出来，
//												  //因为下一个精灵的编号与前面一个精灵的编号重复了。
//				GameCore.setSpritePosition(i, i, 200); //所以在这里使用变量i
//				GameCore.setSpriteFlipX(i, true);
//				GameCore.playSpriteAnimate(i, "jump", true);
//				GameCore.pause(100);
//		}
		//从上往下排列精灵，每次新增77个Y轴，最多增加到500
//		for (int i = 0; i <= 500; i+=77) {
//			GameCore.createSprite(i, "mario");
//			GameCore.setSpritePosition(i, 100, i); 
//			GameCore.setSpriteFlipX(i, true);
//			GameCore.playSpriteAnimate(i, "jump", true);
//			GameCore.pause(100);
//		}
		//从原点向（500,500）放9个精灵
//		for (int i = 0; i <= 500; i+=55.4) {
//			GameCore.createSprite(i, "mario");
//			GameCore.setSpritePosition(i, i, i); 
//			GameCore.setSpriteFlipX(i, true);
//			GameCore.playSpriteAnimate(i, "jump", true);
//			GameCore.pause(100);
//		}
		//从上往下走
//		int spritesNum = 0;
//		GameCore.setGameSize(900, 800);
//		GameCore.createSprite(spritesNum, "mario");
//		GameCore.setSpritePosition(spritesNum, 100, 0); 
//		GameCore.setSpriteFlipX(spritesNum, true);
//		GameCore.playSpriteAnimate(spritesNum, "walk", true);
//		for (int i = 0; i <= 500; i+=1) {
//			GameCore.setSpritePosition(spritesNum, 100, i); 
//			GameCore.pause(20);
//		}
//		GameCore.pause(50200);
		//从右往左走
//		int spritesNum = 0;
//		GameCore.setGameSize(900, 800);
//		GameCore.createSprite(spritesNum, "mario");
//		GameCore.setSpritePosition(spritesNum, 500, 100); 
//		GameCore.playSpriteAnimate(spritesNum, "walk", true);
//		for (int i = 500; i > 0; i-=1) {
//			GameCore.setSpritePosition(spritesNum, i, 100); 
//			GameCore.pause(20);
//		}
		//走正方形
//		int spritesNum = 0;
//		GameCore.setGameSize(900, 800);
//		GameCore.createSprite(spritesNum, "mario");
//		GameCore.setSpritePosition(spritesNum, 100, 0); 
//		GameCore.setSpriteFlipX(spritesNum, true);
//		GameCore.playSpriteAnimate(spritesNum, "walk", true);
//		for (int i = 0; i <= 200; i++) {
//			GameCore.setSpritePosition(spritesNum, i, 0); 
//			GameCore.pause(10);
//		}
//		for (int i = 0; i <= 200; i++) {
//			GameCore.setSpritePosition(spritesNum, 200, i); 
//			GameCore.pause(10);
//		}
//		GameCore.setSpriteFlipY(spritesNum, true);
//		for (int i = 200; i > 0; i--) {
//			GameCore.setSpritePosition(spritesNum, i, 200); 
//			GameCore.pause(10);
//		}
//		for (int i = 200; i > 0; i--) {
//			GameCore.setSpritePosition(spritesNum, 0, i); 
//			GameCore.pause(10);
//		}
		
		//输入数字，然后执行动画
		int inputNum =Integer.parseInt(GameCore.input("", "输入一个正整数"));
			if (inputNum > 0) {
				int spritesNum = 0;
				GameCore.createSprite(spritesNum, "mario");
				GameCore.setSpritePosition(spritesNum, 0, 10);
				GameCore.playSpriteAnimate(spritesNum, "walk", true);
					for (int i = 0; i <= inputNum; i++) {
						GameCore.setSpritePosition(spritesNum, i, 10);
						GameCore.pause(10);
					}
			}
			else {
				GameCore.alert("Error");
			}
		GameCore.pause(10000);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new ForTest());
	}

}
