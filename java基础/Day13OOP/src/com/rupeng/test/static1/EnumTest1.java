package com.rupeng.test.static1;

public class EnumTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Dir d1 = Dir.Right;
		Dir d2 = Dir.Up;
		Dir d3 = Dir.Left;
		Dir d4 = Dir.Down;
		//Dir d5 =d1 new Dir();//枚举不能new，只能用”类型.名字“获取可选值
		f1(d1);
		f1(Dir.Down);
	}

	static void f1(Dir dir)
	{
		if (dir == Dir.Left)
		{
			System.out.println("Left");
		} 
		else if (dir == Dir.Right)
		{
			System.out.println("Right");
		} 
		else if (dir == Dir.Up)
		{
			System.out.println("Up");
		} 
		else if (dir == Dir.Down)
		{
			System.out.println("Down");
		}
	}

}
