package com.rupeng.test.static1;

public class MyDir
{
	private MyDir()
	{
		
	}
	//限定了这个类只能有着四个对象
	//设置为final是为了避免使用者提供MyDir.Up = null的方式释放对象
	public static final MyDir Up = new MyDir();
	public static final MyDir Down = new MyDir();
	public static final MyDir Left = new MyDir();
	public static final MyDir Right = new MyDir();
}
