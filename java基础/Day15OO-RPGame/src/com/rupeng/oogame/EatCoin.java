package com.rupeng.oogame;

import com.rupeng.game.GameCore;

public class EatCoin implements Runnable
{
	private int score = 0;
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		CionInfo[] coins = new CionInfo[10];
		for (int i = 0; i < coins.length; i++)
		{
			coins[i] = new CionInfo();
			coins[i].getSprite().setPosition(GameCore.rand(140, 600), GameCore.rand(160, 600));
			
		}
		
		GameSprite mario = new GameSprite("mario");
		mario.setPosition(0, 0);
		mario.playAnimate("walk");
		
		GameText txtScore = new GameText();
		txtScore.setPosition(600, 0);
		while(true)
		{
			mario.move();
			GameCore.pause(0);
			for (CionInfo coin : coins)
			{
				//判断mario是否和遍历到的coin碰撞
				//如果死了就没有必要判断了
				if (coin.isAlive()&&mario.isIntersectWith(coin.getSprite()))
				{
					coin.setAlive(false);
					coin.getSprite().hide();
					score++;
					txtScore.setText(Integer.toString(score));
				}
		}
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new EatCoin());
	}

}
class CionInfo
{
	private boolean isAlive;
	private GameSprite sprite;
	
	public  CionInfo()
	{
		this.isAlive = true;
		this.sprite = new GameSprite("coin");
		this.sprite.playAnimate("rotate");
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	public GameSprite getSprite()
	{
		return sprite;
	}
	public void setSprite(GameSprite sprite)
	{
		this.sprite = sprite;
	}
	
}
