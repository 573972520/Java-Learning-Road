package com.rupeng.oogame;

import com.rupeng.game.GameCore;

public class JingPingMei implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		GameSprite mario = new GameSprite("mario");
		mario.setFlipX();
		mario.setPosition(0, 300);
		mario.playAnimate("walk");
		
		GameSprite girl = new GameSprite("girl");
		girl.setPosition(300, 300);
		girl.playAnimate("walk");
		
		String[] words = {"在一起","如鹏网观光团飘过！","<<<=========","如鹏网送上贺礼，祝百年好合！"};
		GameText[] text = new GameText[words.length];//这一刻，一个GameText对象都没有，只是5个“坑”，5个null
		
		for (int i = 0; i < 270; i++)
		{
			mario.moveRight();
		}
		for (int i = 0; i < words.length; i++)
		{
			GameText text2 = new GameText(words[i]);
			text2.setPosition(600+i*50, 100*i);
			text[i] = text2;//把创建的对象填到数组的坑中
		}
		
		for (int i = 0; i < 650; i++)
		{
			/*
			for (int j = 0; j < text.length; j++)
			{
				GameText txt = text[j];
				txt.moveLeft();
			}
			*/
			for (GameText text3 : text) //增强for循环
			{
				text3.moveLeft();
			}
		}
		for (int i = 0; i < 500; i++)
		{
			mario.moveRight();
			girl.moveRight();
		}
		GameCore.pause(34);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new JingPingMei());
	}

}
