import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class TwoDimensionalArrayGame implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int marioNum = 0;
		GameCore.createSprite(marioNum, "mario");
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		int blockNum = 1;
		GameCore.createImage(blockNum, "3.jpg");
		GameCore.setImagePosition(blockNum, 300, 300);
		Dimension gameSize = GameCore.getGameSize();//
		int gameWidth = gameSize.width;
		int gameHeight = gameSize.height;
		Dimension marioSize = GameCore.getSpriteSize(marioNum);//
		int marioWidth = marioSize.width;
		int marioHeight = marioSize.height;
//		int marioPosX = GameCore.getSpriteX(marioNum);
//		int marioPosY = GameCore.getSpriteY(marioNum);
		Dimension blockSize = GameCore.getImageSize(blockNum);//
		int blockWidth = blockSize.width;
		int blockHeight = blockSize.height;
		Point blockPos = GameCore.getSpritePosition(blockNum);
		int blockPosX = GameCore.getImageX(blockNum);
		int blockPosY = GameCore.getImageY(blockNum);
//		System.out.println(blockPosX);
//		System.out.println(blockPosY);
		//
		for(;;){
			int key = GameCore.getPressedKeyCode();
			Point marioPos = GameCore.getSpritePosition(marioNum);
			if (key == KeyEvent.VK_RIGHT) {
				if (marioPos.x < gameWidth-marioWidth) {
					GameCore.setSpriteFlipX(marioNum, true);
					GameCore.setSpritePosition(marioNum, marioPos.x+1, marioPos.y);
				}
			}
			if (key == KeyEvent.VK_LEFT) {
				if (marioPos.x > 0) {
					GameCore.setSpriteFlipX(marioNum, false);
					GameCore.setSpritePosition(marioNum, marioPos.x-1, marioPos.y);
				}
			}
			if (key == KeyEvent.VK_UP) {
				if (marioPos.y > 0) {
					GameCore.setSpritePosition(marioNum, marioPos.x, marioPos.y-1);
				}
			}
			if (key == KeyEvent.VK_DOWN) {
				if (marioPos.y < gameHeight-marioHeight-30) {
					GameCore.setSpritePosition(marioNum, marioPos.x, marioPos.y+1);
				}
			}
			if (marioPos.x >= (blockPosX-marioWidth)&&marioPos.x <= (blockPosX+blockWidth)&&marioPos.y >= (blockPosY-marioHeight)&&marioPos.y <= (blockPosY+blockHeight)) {
				GameCore.alert("2");
			}
		}
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new TwoDimensionalArrayGame());
	}

}
