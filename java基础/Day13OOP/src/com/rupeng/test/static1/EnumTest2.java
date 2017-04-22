package com.rupeng.test.static1;

public class EnumTest2
{
	public static void main(String[] args)
	{
		
		MyDir dir1 = MyDir.Down;
		MyDir dir2 =  MyDir.Left;
		
		f1(dir1);
		System.out.println(MyDir.Left);
		f1(dir2);
		f1(MyDir.Left);
		
	}
	static void f1(MyDir dir)
	{
		if (dir == MyDir.Left)
		{
			System.out.println("Left");
		} 
		else if (dir == MyDir.Right)
		{
			System.out.println("Right");
		} 
		else if (dir == MyDir.Up)
		{
			System.out.println("Up");
		} 
		else if (dir == MyDir.Down)
		{
			System.out.println("Down");
		}
	}
}
