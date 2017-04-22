package com.rupeng.game.oo;

import com.rupeng.game.GameCore;

public class RPImages
{
	private int imageNum;
	public  RPImages(String imageName)
	{
		this.imageNum = NumberCreator.getCreator().createNumber();
		GameCore.createImage(this.imageNum, imageName);
	}
	public void  imagePosition(int x,int y)
	{
		GameCore.setImagePosition(this.imageNum, x, y);
	}

}
