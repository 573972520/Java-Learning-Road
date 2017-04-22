package com.rupeng.oop.test;

public class Test5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int i = 1+2;
		System.out.println(i);
		
		earthMan d1 = new earthMan()
		{
			
			@Override
			public void speak()
			{
				// TODO Auto-generated method stub
				System.out.println(i);
			}
		};
	}

}


