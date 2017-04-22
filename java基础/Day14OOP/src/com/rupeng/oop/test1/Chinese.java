package com.rupeng.oop.test1;

public class Chinese extends earthMan
{
	/*
	@Override  //Annotation(标注)——用于检测语法错误
			   //JDK1.5之后，最好在override方法上面标注@Override，这样可以让编译器发现一些不应该出现的错误
	public void speak()
	{
		System.out.println("我是中国人");
	}
	*/
	
	public void baiNian()
	{
		System.out.println("过年好");
	}
//	@Override
//	public void ett()  //如果这里的定义的override方法与父类的不一样，那么@Override会检测到这个错误并且保错
//	{
//		
//	}
	
	@Override
	public void speak()
	{
		// TODO Auto-generated method stub
		super.speak(); //调用父类的super方法
//		this.speak();//无限调用自己
		System.out.println("我是中国人");
	}
	
	
}
