package com.rupeng.oogame;

public class NumberCreator
{
	private static final NumberCreator instance = new NumberCreator();
	private NumberCreator()
	{
		
	}
	public static NumberCreator getCreator()
	{
		return instance;
	}
	private int number;
	public synchronized int createNumber()
	{
		number++;
		return number;
	}
}
