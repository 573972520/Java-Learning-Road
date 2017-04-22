import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class blockTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameCore.setGameSize(800, 830);
		int marioNum = 0;
		int imgNum = 0;
		GameCore.createSprite(marioNum, "mario");
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		Dimension gameSize = GameCore.getGameSize();//
		int gameWidth = gameSize.width;
		int gameHeight = gameSize.height;
		Dimension marioSize = GameCore.getSpriteSize(marioNum);//
		int marioWidth = marioSize.width;
		int marioHeight = marioSize.height;
		int[][] iconNum = { {0,4,3,4,0,3,4,3,3,4},
							{0,0,3,3,0,4,3,3,3,4},
							{0,0,4,3,0,4,4,4,3,3},
							{3,0,0,4,0,0,0,4,3,4},
							{0,3,0,4,0,3,3,4,4,4},
							{0,0,0,3,0,4,4,1,3,4},
							{0,3,0,0,0,0,0,0,3,4},
							{0,4,3,0,0,3,4,3,3,4},
							{0,0,3,0,0,0,0,0,0,0},
							{0,4,3,4,3,3,4,0,3,0}};
		for (int i = 0; i < iconNum.length; i++) {
			int[] row = iconNum[i];
			for (int j = 0; j < row.length; j++) {
				int iconData = row[j];
				if (iconData == 3) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "3.jpg");
					GameCore.setImagePosition(imgNum, j*80, i*80);
					imgNum++; //记得图片编号要改变
				}
				else if (iconData == 4) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "4.jpg");
					GameCore.setImagePosition(imgNum, j*80, i*80);
					imgNum++; //记得图片编号要改变
				}
				else {
					
				}
			}
		}
		for(;;){
			int key = GameCore.getPressedKeyCode();
			Point marioPos = GameCore.getSpritePosition(marioNum);
			if (key == KeyEvent.VK_RIGHT) {
				int marioRightX = marioPos.x+marioWidth;
				int marioUpY = marioPos.y;
				int marioDownY = marioPos.y+marioHeight;
				boolean isRightCollide = false;
				for (int i = 0; i < iconNum.length; i++) {
					int[] rowData = iconNum[i];
					for (int j = 0; j < rowData.length; j++) {
						int type = rowData[j];
						if (type == 0) {
							continue;
						}
						int brickLeftX = j*80;
						int brickUpY = i*80;
						int brickDownY = (i+1)*80;
						if (marioRightX==brickLeftX&&(marioUpY >= brickUpY&&marioUpY <= brickDownY||marioDownY >= brickUpY&&marioDownY <= brickDownY)) {
							isRightCollide = true;
							break;
						}
					}
				}
				if (!isRightCollide&&marioPos.x < gameWidth-marioWidth) {
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
			
//			if (marioPos.x >= (blockPosX-marioWidth)&&marioPos.x <= (blockPosX+blockWidth)&&marioPos.y >= (blockPosY-marioHeight)&&marioPos.y <= (blockPosY+blockHeight)) {
//				GameCore.alert("2");
//			}
			GameCore.pause(0);
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new blockTest());
	}

}
