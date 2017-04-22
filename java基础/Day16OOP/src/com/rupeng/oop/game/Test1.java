package com.rupeng.oop.game;

public class Test1
{

	public static void main(String[] args)
	{
		/*
		// TODO Auto-generated method stub
		Flyable f1 = new AirPlane();
		f1.fly();
		//f1.zhuolu();//不能调用，因为变量类型是Flyable，所以只能调用fly这个方法
		AirPlane a1 = (AirPlane)f1;
		a1.zhuolu();
		*/
		
		//调用者可以不用管返回的到底是哪个类的对象
		//只有知道你返回的这个对象的类实现了Flyable接口就可以了
		//既然实现了Flyable接口，那么我就可以调用这个接口的方法
		Flyable f1 = createAFlyable(1);
		f1.fly();
		Flyable f2 = createAFlyable(6);
		f2.fly();
		
		
	}
	
	//工厂模式
	static Flyable createAFlyable(int i)
	{
		Flyable dest;
		
		if (i%2 == 0)
		{
			dest =  new Bird();
		}
		else {
			dest =  new AirPlane();
		}
		//return dest;
		return new FlayChecker(dest);//装饰者模式
	}

}
