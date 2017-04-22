import java.awt.Point;

import com.rupeng.game.GameCore;

public class MethodTest5 implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		int marioNum = 0;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 200);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		int girlNum = 1;
		GameCore.createSprite(girlNum, "girl");
		GameCore.setSpritePosition(girlNum, 200, 100);
		GameCore.playSpriteAnimate(girlNum, "walk", true);
		loading(marioNum, 300,true);
		moveSpritesRectangle(marioNum, 100, 200,true);
		moveSpritesRectangle(girlNum, 200, 200,false);
		for (int i = 0; i < 100; i++)
		{
			moveSpritesAnyDirection(marioNum, 1, 2);
			moveSpritesAnyDirection(marioNum, 4, 2);
			GameCore.pause(10);
		}
		for (int i = 0; i < 100; i++)
		{
			moveSpritesAnyDirection(marioNum, 3, 2);
			GameCore.pause(10);
		}
		
		while (true)
		{
			GameCore.pause(1);
		}
	}

//方法：一次声明，多次调用。这样起到了“复用代码”的作用
//对于调用者来说，也不用关心方法内部是怎么样实现的，方法封装了内部的细节
	// 精灵向右移动一个像素
	static void moveSpritesRight(int spritesNum)
	{
		Point pos = GameCore.getSpritePosition(spritesNum);
		int x = pos.x;
		int y = pos.y;
		x++;
		GameCore.setSpriteFlipX(spritesNum, true);
		GameCore.setSpritePosition(spritesNum, x, y);
	}

	// 循环的上下左右移动精灵（不能指定移动方向）
	static void moveSprites(int spritesNum)
	{
		Point pos = GameCore.getSpritePosition(spritesNum);
		int x = pos.x;
		int y = pos.y;

		for (int i = 0; i < 200; i++)
		{
			GameCore.setSpriteFlipX(spritesNum, true);
			GameCore.setSpritePosition(spritesNum, x, y);
			x = x+2 ;
		}
		for (int i = 0; i < 200; i++)
		{
			GameCore.setSpritePosition(spritesNum, x, y);
			y++;
		}
		for (int i = 0; i < 200; i++)
		{
			GameCore.setSpriteFlipX(spritesNum, false);
			GameCore.setSpritePosition(spritesNum, x, y);
			x= x-2;
		}
		for (int i = 0; i < 200; i++)
		{
			GameCore.setSpritePosition(spritesNum, x, y);
			y--;
		}
	}

	// 指定方向的移动精灵
	static void moveSpritesAnyDirection(int spritesNum, int direction, int nPixel)
	//三个变量，分别是精灵的编号，指向移动的方法，移动的距离
	{
		Point pos = GameCore.getSpritePosition(spritesNum);
		int x = pos.x;
		int y = pos.y;
		if (direction == 1) // 向上
		{
			y -= nPixel;
			GameCore.setSpritePosition(spritesNum, x, y);
		} else if (direction == 2)// 向下
		{
			y += nPixel;
			GameCore.setSpritePosition(spritesNum, x, y);
		} else if (direction == 3)// 向左
		{
			x -= nPixel;
			GameCore.setSpritePosition(spritesNum, x, y);
		} else if (direction == 4)// 向右
		{
			x += nPixel;
			GameCore.setSpritePosition(spritesNum, x, y);
		} else
		{
			System.err.println("direction is error!");
		}
	}
	
	//使精灵走矩形(嵌套了moveSpritesAnyDirection这个方法！)
	static void moveSpritesRectangle(int spritesNum,int width,int height,boolean isFlipX)
	//变量为：精灵编号，X轴行走的距离，Y轴行走的距离
	{
		//RIGHT
		for (int i = 0; i < width; i++)
		{
			GameCore.setSpriteFlipX(spritesNum, isFlipX);
			moveSpritesAnyDirection(spritesNum, 4, 1);
			GameCore.pause(10);
		}
		//DOWN
		for (int i = 0; i < height; i++)
		{
			moveSpritesAnyDirection(spritesNum, 2, 1);
			GameCore.pause(10);
		}
		//LEFT
		for (int i = 0; i < width; i++)
		{
			GameCore.setSpriteFlipX(spritesNum, !isFlipX);
			moveSpritesAnyDirection(spritesNum, 3, 1);
			GameCore.pause(10);
		}
		//UP
		for(int i=0;i < height;i++)
		{
			moveSpritesAnyDirection(spritesNum, 1, 1);
			GameCore.pause(10);
		}
	}

	//精灵循环左右跑
	static void loading (int spritesNum,int loadingWidth,boolean isFlipX)
	{
		while (true)
		{
			for (int i = 0; i < loadingWidth; i++)
			{
				GameCore.setSpriteFlipX(spritesNum, isFlipX);
				moveSpritesAnyDirection(spritesNum, 4, 1);
			}
			for (int i = 0; i < loadingWidth; i++)
			{
				GameCore.setSpriteFlipX(spritesNum, !isFlipX);
				moveSpritesAnyDirection(spritesNum, 3, 1);
			}
		}
		
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new MethodTest5());
	}

}
