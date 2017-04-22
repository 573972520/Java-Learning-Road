import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class MethodTest6 implements Runnable
{
	static boolean isIntersect(Point pointR1,int widthR1,int heightR1,Point pointR2,int widthR2,int heightR2)
	{
		//R1的上边缘的Y坐标大于R2的下边缘的Y坐标；
		boolean result1 = pointR1.y > pointR2.y+heightR2;
		//R1的左边缘的X坐标大于R2的右边缘的X坐标；
		boolean result2 = pointR1.x > pointR2.x+widthR2;
		//R1的右边缘的X坐标小于R2的左边缘的X坐标；
		boolean result3 = pointR1.x+widthR1 < pointR2.x;
		//R1的下边缘的Y坐标小于R2的上边缘的Y坐标；
		boolean result4 = pointR1.y+heightR1 < pointR2.y;
		//是否不相交
		boolean isNotIntersect = result1||result2||result3||result4;//只要有一个true，就是不相交
		return !isNotIntersect;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		GameCore.setGameSize(800, 800);
		int marioNum = 100;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 0, 100);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
//		int girlNum = 111;
//		GameCore.createSprite(girlNum, "girl");
//		GameCore.setSpritePosition(girlNum, 200, 200);
//		GameCore.playSpriteAnimate(girlNum, "walk", true);
		Dimension marioSize = GameCore.getSpriteSize(marioNum);
		int marioWidth = marioSize.width;
		int marioHeight = marioSize.height;
//		Dimension girlSize = GameCore.getSpriteSize(girlNum);
//		int girlWidth = girlSize.width;
//		int girlHeight = girlSize.height;
		
		int[] coinXData = new int [10];
		int[] coinYData = new int [10];
		int[] coinNum = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < coinXData.length; i++)
		{
			int data = GameCore.rand(100, 800);
			coinXData[i] =data;
			int data1 = GameCore.rand(100, 700);
			coinYData[i] =data1;
			GameCore.createSprite(coinNum[i], "coin");
			GameCore.setSpritePosition(coinNum[i], coinXData[i], coinYData[i]);
			GameCore.playSpriteAnimate(coinNum[i], "rotate", true);
		}
		
		int[] brickXData = {100,300,600};
		int[] brickYData = {200,30,555};
		int[] brickNum = {77,99,88};
		for (int i = 0; i < brickYData.length; i++)
		{
			GameCore.createImage(brickNum[i], "3.jpg");
			GameCore.setImagePosition(brickNum[i], brickXData[i], brickYData[i]);
		}
		while (true)
		{
			for (int i = 0; i < coinXData.length; i++)
			{
				Point marioPos = GameCore.getSpritePosition(marioNum);
				Point coinPos = GameCore.getSpritePosition(coinNum[i]);
				Dimension coinSize = GameCore.getSpriteSize(coinNum[i]);
				int coinWidth = coinSize.width;
				int coinHeight = coinSize.height;
				if (isIntersect(marioPos, marioWidth, marioHeight, coinPos, coinWidth, coinHeight))
					{
						GameCore.hideSprite(coinNum[i]);
					}
			}
			for (int i = 0; i < brickNum.length; i++)
			{
				Point marioPos = GameCore.getSpritePosition(marioNum);
				Point brickPos = GameCore.getImagePosition(brickNum[i]);
				Dimension brickSize = GameCore.getImageSize(brickNum[i]);
				int brickWidth = brickSize.width;
				int brickHeight = brickSize.height;
				if (isIntersect(marioPos, marioWidth, marioHeight, brickPos, brickWidth, brickHeight))
					{
						GameCore.exit();
					}
			}
			
			int keyCode = GameCore.getPressedKeyCode();
			Point marioPos = GameCore.getSpritePosition(marioNum);
//			Point marioPos = GameCore.getSpritePosition(marioNum);
//			Point girlPos = GameCore.getSpritePosition(girlNum);
			int x = marioPos.x;
			int y = marioPos.y;
			if (keyCode == KeyEvent.VK_UP)
			{
				GameCore.setSpritePosition(marioNum, x, y-10);
			}
			if (keyCode == KeyEvent.VK_DOWN)
			{
				GameCore.setSpritePosition(marioNum, x, y+10);
			}
			if (keyCode == KeyEvent.VK_LEFT)
			{
				GameCore.setSpriteFlipX(marioNum, false);
				GameCore.setSpritePosition(marioNum, x-10, y);
			}
			if (keyCode == KeyEvent.VK_RIGHT)
			{
				GameCore.setSpriteFlipX(marioNum, true);
				GameCore.setSpritePosition(marioNum, x+10, y);
			}
			
//			if (isIntersect(marioPos, marioWidth, marioHeight, girlPos, girlWidth, girlHeight))
//			{
//				System.out.println("1");
//			}else {
//				System.out.println("2");
//			}
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new MethodTest6());
	}

}
