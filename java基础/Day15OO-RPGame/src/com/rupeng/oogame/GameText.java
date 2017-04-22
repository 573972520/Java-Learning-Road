package com.rupeng.oogame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class GameText extends GameRect
{
	private int number;
	private String text;
	public  GameText(String txt)
	{
		this.number = NumberCreator.getCreator().createNumber();
		GameCore.createText(this.number,txt);
	}
	public  GameText()
	{
		this("");
	}
	
	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		GameCore.hideText(this.number);
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		GameCore.showText(this.number);
	}

	@Override
	public Point getPosition()
	{
		return GameCore.getTextPosition(this.number);
	}

	@Override
	public void setPosition(int x, int y)
	{
		// TODO Auto-generated method stub
		GameCore.setTextPosition(this.number, x, y);
	}
	@Override
	public Dimension getSize()
	{
		// TODO Auto-generated method stub
		return GameCore.getTextSize(this.number);
	
	}
	//  文本自己特有的方法
	public void setText(String txt)
	{
		GameCore.setText(this.number, txt);
		this.text = txt;
	}
	public String getText()
	{
		return this.text;
	}
	public void setFontSize(int fontsize)
	{
		GameCore.setTextFontSize(this.number, fontsize);
	}
	public void setColor(Color color)
	{
		GameCore.setTextColor(this.number, color);
	}
}
