package com.rupeng.game.oo;

import java.awt.Color;

import com.rupeng.game.GameCore;

public class Test1 implements Runnable
{
	public static void main(String[] args)
	{
		/*
		int n1 = NumberCreator.getCreator().createNumber();
		System.out.println(n1);
		int n2 = NumberCreator.getCreator().createNumber();
		System.out.println(n2);
		int n3 = NumberCreator.getCreator().createNumber();
		System.out.println(n3);
		int n4 = NumberCreator.getCreator().createNumber();
		System.out.println(n4);
		int n5 = NumberCreator.getCreator().createNumber();
		System.out.println(n5);
		*/
		GameCore.start(new Test1());
	}

	@Override
	public void run()
	{
		/*
		// TODO Auto-generated method stub
		int marioNum = NumberCreator.getCreator().createNumber();
		int girlNum = NumberCreator.getCreator().createNumber();
		
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 0);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		GameCore.createSprite(girlNum,"girl");
		GameCore.setSpritePosition(girlNum, 200, 0);
		GameCore.playSpriteAnimate(girlNum, "walk", true);
		*/
		
		
		RPSprite mario = new RPSprite("mario");
		mario.setPosition(100, 100);
		mario.playAnimate("walk");
		

		
//		mario.moveRight(500);
//		mario.moveLeft(200);
//		mario.moveDown(200);
//		mario.moveUp(100);
		
		/*
		RPSprite girl = new RPSprite("girl");
//		girl.setPosition(500, 300);
		girl.playAnimate("ti");
		*/
		
		/*
		RPText test = new RPText("8sdfsdf8");
		test.textFontSize(50);
		test.textPosition(100, 250);
		test.textColor(Color.red);
		RPImages imageTest = new RPImages("1.jpg");
		imageTest.imagePosition(55, 100);
		*/
		while(true)
		{
			mario.moveSprite();
			GameCore.pause(5);
		}
		
		
		
	}
}
