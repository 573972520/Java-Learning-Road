package com.rupeng.game.oo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class RPSprite
{
	private int number;

	public RPSprite(String spriteName)
	{
		this.number = NumberCreator.getCreator().createNumber();
		GameCore.createSprite(number, spriteName);
	}

	public void setPosition(int x, int y)
	{
		GameCore.setSpritePosition(this.number, x, y);
	}

	public void playAnimate(String animateName, boolean isRepeat)
	{
		GameCore.playSpriteAnimate(this.number, animateName, isRepeat);
	}

	public void playAnimate(String animateName)
	{
		playAnimate(animateName, true);
	}

	public Point getPosition()
	{
		return GameCore.getSpritePosition(this.number);
	}

	public Dimension getSize()
	{
		return GameCore.getSpriteSize(this.number);
	}

	public void setFlipX(boolean isFlipX)
	{
		GameCore.setSpriteFlipX(this.number, isFlipX);
	}

	public void setFlipY(boolean isFlipY)
	{
		GameCore.setSpriteFlipY(this.number, isFlipY);
	}
	public void show()
	{
		GameCore.showSprite(this.number);
	}
	public void moveRight(int moveCount)
	{
		if (moveCount <= 0)
		{
			GameCore.alert("步数必须是正数！");
			System.out.println("步数必须是正数！");
		} 
		else
		{
			for (int i = 0; i < moveCount; i++)
			{
				Point pos = getPosition();
				int x = pos.x;
				int y = pos.y;
				x++;
				setPosition(x, y);
			}
		}
	}
	public void moveLeft(int moveCount)
	{
		if (moveCount <= 0)
		{
			GameCore.alert("步数必须是正数！");
			System.out.println("步数必须是正数！");
		} 
		else
		{
			for (int i = 0; i < moveCount; i++)
			{
				Point pos = getPosition();
				int x = pos.x;
				int y = pos.y;
				x--;
				setPosition(x, y);
			}
		}
	}
	public void moveUp(int moveCount)
	{
		if (moveCount <= 0)
		{
			GameCore.alert("步数必须是正数！");
			System.out.println("步数必须是正数！");
		} 
		else
		{
			for (int i = 0; i < moveCount; i++)
			{
				Point pos = getPosition();
				int x = pos.x;
				int y = pos.y;
				y--;
				setPosition(x, y);
			}
		}
	}
	public void moveDown(int moveCount)
	{
		if (moveCount <= 0)
		{
			GameCore.alert("步数必须是正数！");
			System.out.println("步数必须是正数！");
		} 
		else
		{
			for (int i = 0; i < moveCount; i++)
			{
				Point pos = getPosition();
				int x = pos.x;
				int y = pos.y;
				y++;
				setPosition(x, y);
			}
		}
	}
	public void moveSprite()
	{
		int keyCode = GameCore.getPressedKeyCode();
		Point pos = getPosition();
		int x = pos.x;
		int y = pos.y;
		if (keyCode == KeyEvent.VK_LEFT)
		{
			setFlipX(false);
			x--;
			setPosition(x, y);
		}
		if (keyCode == KeyEvent.VK_RIGHT)
		{
			setFlipX(true);
			x++;
			setPosition(x, y);
		}
		if (keyCode == KeyEvent.VK_UP)
		{
			y--;
			setPosition(x, y);
		}
		if (keyCode == KeyEvent.VK_DOWN)
		{
			y++;
			setPosition(x, y);
		}
		if (keyCode == KeyEvent.VK_SPACE )
		{
			moveUp(50);
			moveDown(50);
		}
	}


}
