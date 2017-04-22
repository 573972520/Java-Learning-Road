package com.rupeng.oogame;

import java.awt.Dimension;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class GameImage extends GameRect
{
	private int number;
	public  GameImage(String imgName)
	{
		this.number = NumberCreator.getCreator().createNumber();
		GameCore.createImage(this.number, imgName);
	}
	public GameImage()
	{
		this("");
	}
	@Override
	public Dimension getSize()
	{
		// TODO Auto-generated method stub
		return GameCore.getImageSize(this.number);
	}
	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		GameCore.hideImage(this.number);
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		GameCore.showImage(this.number);
	}

	@Override
	public Point getPosition()
	{
		// TODO Auto-generated method stub
		return GameCore.getImagePosition(this.number);
	}

	@Override
	public void setPosition(int x, int y)
	{
		// TODO Auto-generated method stub
		GameCore.setImagePosition(this.number, x, y);
	}
	
	//  图片自己特有的方法
	public void setImageSource(String imgName)
	{
		GameCore.setImageSource(this.number,imgName);
	}

}
