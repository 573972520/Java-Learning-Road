import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

import com.rupeng.game.GameCore;

public class Key implements Runnable {


	//private static final int DOWN_Key = 40; //定义一个常量DOWN_Key，代表向下按键
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		//按键基础
		for(;;){
			int kc = GameCore.getPressedKeyCode();
			if (kc == 38) { //38表示“向上按键”的键盘码
				System.out.println("上");
			}
			if (kc == DOWN_Key) {
				System.out.println("下");
			}
			if (kc == KeyEvent.VK_LEFT) {
				System.out.println("左");
			}
			if (kc == KeyEvent.VK_RIGHT) {
				System.out.println("右");
			}
			//System.out.println(kc);
			*/
			
		    //控制精灵走动
			int marioNum = 0;
			GameCore.createSprite(marioNum, "mario");
			GameCore.setSpritePosition(marioNum, 100, 200);
			GameCore.setSpriteFlipX(marioNum, true);
			GameCore.playSpriteAnimate(marioNum, "walk", true);
			GameCore.setGameSize(300, 300);
			Dimension gameSize =  GameCore.getGameSize();  //得到游戏窗口的大小
			int gameWidth = gameSize.width; //得到游戏窗口的宽度
			int gameHeight = gameSize.height;//得到游戏窗口的高度
			Dimension spriteSize = GameCore.getSpriteSize(marioNum);//得到精灵的尺寸
			int spritesWidth = spriteSize.width;//得到精灵的宽度
			int spritesHeight = spriteSize.height;//得到精灵的高度
			for(;;){
				int kc = GameCore.getPressedKeyCode(); //得到用户的按键
				Point pos = GameCore.getSpritePosition(marioNum);//获取精灵当前位置
				if (kc == KeyEvent.VK_RIGHT||kc ==KeyEvent.VK_D) {
					if (pos.x < gameWidth-spritesWidth) { //不能超过右边界，最多为“游戏窗口宽度-精灵的宽度“
						GameCore.setSpriteFlipX(marioNum, true);
						GameCore.setSpritePosition(marioNum, pos.x+1, pos.y);
					}
				}
				else if (kc == KeyEvent.VK_LEFT||kc ==KeyEvent.VK_A){
					if (pos.x > 0) {//不能超过左边界
						GameCore.setSpriteFlipX(marioNum, false);
						GameCore.setSpritePosition(marioNum, pos.x-1, pos.y);
					}
				}
				else if (kc == KeyEvent.VK_UP||kc ==KeyEvent.VK_W) {
					if (pos.y > 0) {//不能超过上边界
						GameCore.setSpritePosition(marioNum, pos.x, pos.y-1);
					}
				}
				else if (kc == KeyEvent.VK_DOWN||kc ==KeyEvent.VK_S) {
					if (pos.y < gameHeight-spritesHeight) {//不能超过下边界，最多为“游戏窗口高度度-精灵的高度“
														  //游戏窗口的高度包含标题栏，所以还可以减去一个20 来修正一下(我这里没有减掉20)
						GameCore.setSpritePosition(marioNum, pos.x, pos.y+1);
					}
				}
				GameCore.pause(10);
			}
			
			
			
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Key());
	}

}
