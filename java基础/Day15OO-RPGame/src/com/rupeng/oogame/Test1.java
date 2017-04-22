package com.rupeng.oogame;

import com.rupeng.game.GameCore;

public class Test1 implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		/*
		GameText txt1 = new GameText();
		txt1.setText("Hello");
		for (int i = 0; i < 100; i++)
		{
			txt1.moveRight();
			GameCore.pause(0);
		}
		*/
		
		
		GameSprite mario = new GameSprite("mario");
		mario.playAnimate("walk");
		mario.setPosition(100, 100);
		
		GameSprite bomb = new GameSprite("bomb");
		bomb.playAnimate("fire");
		bomb.setPosition(400, 200);
		
		
		while(true)
		{
			mario.move();
			GameCore.pause(10);
			if (mario.isIntersectWith(bomb) == true)
			{
				System.out.println("1");
			}
			else {
				System.out.println("2");
			}
			
		}
		
		
		
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new Test1());
	}

}
