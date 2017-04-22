package com.rupeng.oop.test3;

import com.rupeng.oop.test1.Japanese;

public class Test3
{

	public static void main(String[] args)
	{
		
		/*
		// TODO Auto-generated method stub
		earthMan d1 = createMan(); //创建的还是莫斯科MoSiKeRen()的对象
		//这里没有new earthMan(),只是声明了earthMan类型的变量指向createMan()返回的对象
		d1.sayHello();
		
		ErGuoRen e1 = (ErGuoRen)d1;
		e1.fight();
		ErGuoRen e2 = (ErGuoRen)createMan();
		e2.fight();
		*/
		
		earthMan d1 = createSMan(); 
		d1.sayHello();

		if (d1 instanceof ErGuoRen)
		{
			earthMan e1 = createSMan(); 
			e1.sayHello();
		}
		else {
			System.out.println("不是俄国人");
		}
	}
	
	public static earthMan createMan()
	{
		return new MoSiKeRen();
	}
	
	public static  earthMan createSMan()
	{
		if (System.currentTimeMillis()%2 == 0)
		{
			return new com.rupeng.oop.test3.Japanese();
		}
		else 
		{
			return new MoSiKeRen();
		}
	}

}
