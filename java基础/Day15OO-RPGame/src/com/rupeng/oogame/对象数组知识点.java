package com.rupeng.oogame;

public class 对象数组知识点
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person[] persons = new Person[5];//只是创建了可以盛放5个Person对象的数组
//		但是没有放Person对象
//		数组每个元素的默认值是：int：0、  String:null、  boolean：false， 类数组的每个元素的默认值都是：null
		//persons[3] = new Person();
		/*
		for (int i = 0; i < persons.length; i++)
		{
			Person p = persons[i];
			System.out.println(p);
			//结果为：
//			null //未赋值，默认为null
//			null
//			null
//			com.rupeng.oogame.Person@15db9742 //手动赋值
//			null
		}
		//和上面的for循环一样的效果
		for (Person p : persons) //增强for循环	 遍历persons数组中的每个元素，每次遍历的元素用p代替 	
		{
			System.out.println(p);
		}
		*/
		
		
		
		for (int i = 0; i < persons.length; i++)
		{
			persons[i] = new Person();
		}
		for (Person p : persons) 
		{
			System.out.println(p);
//			结果为：
//			com.rupeng.oogame.Person@15db9742
//			com.rupeng.oogame.Person@6d06d69c
//			com.rupeng.oogame.Person@7852e922
//			com.rupeng.oogame.Person@4e25154f
//			com.rupeng.oogame.Person@70dea4e
		}
		
		
		
		/*
		for (Person p : persons)
		{
			p = new Person();
		}
		//上面的代码相对于
		for (int i = 0; i < persons.length; i++)
		{
			Person p = persons[i];
			p = new Person(); //又把p指向别人了，所以不会改改变persons[i]的值
			
			下面是正确的写法（会改变persons[i]的值）
			persons[i] = new Person();
		}
		for (Person p : persons) 
		{
			System.out.println(p);
//			结果:
//			null
//			null
//			null
//			null
//			null
		}
		*/
		//增强for循环一般用于使用数组每个元素，不适合给数组元素赋值
	}

}

class Person
{
	
}