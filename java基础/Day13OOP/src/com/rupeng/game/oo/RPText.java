package com.rupeng.game.oo;

import java.awt.Color;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class RPText
{
	private int textNum;
	//自己写的
//	public RPText(String textContent)
//	{
//		this.textNum = NumberCreator.getCreator().createNumber();
//		GameCore.createText(this.textNum, textContent);
//	}
	
	
	//老师写的
	public  RPText()
	{
		//System.out.println("1");
		//构造函数中如果通过this调用其它构造函数，则必须是第一行代码 
		this(""); //调用另外一个重载的构造函数，复用代码
		//java中可以在构造函数中调用this()来调用其它重载的构造函数
	}
	public RPText(String text)
	{
		this.textNum = NumberCreator.getCreator().createNumber();
		GameCore.createText(this.textNum, text);
	}
	/*
	//在普通方法中不能调用构造函数
	public void sayHello()
	{
		this("");
	}
	*/
	

	
	
	public void textPosition(int x, int y)
	{
		GameCore.setTextPosition(this.textNum, x, y);
	}
	public void textColor(Color setColor)
	{
		GameCore.setTextColor(this.textNum, setColor);
	}
	public void textFontSize(int fontSize)
	{
		if (fontSize <= 0)
		{
			GameCore.alert("请输入正数");
		} 
		else
		{
			GameCore.setTextFontSize(this.textNum, fontSize);
		}
	}

}
