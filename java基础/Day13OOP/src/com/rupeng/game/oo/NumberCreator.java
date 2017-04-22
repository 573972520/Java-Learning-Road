package com.rupeng.game.oo;

public class NumberCreator
{
	private static NumberCreator instance = new NumberCreator();
	public static NumberCreator getCreator()
	{
		return instance;
	}
	private  NumberCreator()
	{
		
	}
	private int number;
	public int createNumber()
	{
		number++;
		return number;
	}
}
