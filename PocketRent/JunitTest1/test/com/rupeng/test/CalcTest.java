package com.rupeng.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rupeng.aa.Calc;

public class CalcTest {
	
	//58%的中国的程序猿从来没有写过单元测试
	//只有10%的人认真写过单元测试

	//标注@BeforeClass的方法会在Calc运行之前执行一次
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	//标注@AfterClass的方法会在Calc运行之后执行一次
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	//@Before每个测试方法执行之前都会执行
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	//@After每个测试方法执行之后都会执行
	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void test() {
		System.out.println("@Test");
		int i = Calc.add(1, 2);
		assertEquals(i, 3);
		
		assertEquals(Calc.add(1, -1), 0);
		/*if(i != 3)
		{
			fail("失败");
		}*/
	}
	
	@Test  //必须写上这个@Test 不然Junit不会调用这个方法
	public void test2()
	{
		System.out.println("@Test2");
		assertEquals(Calc.add(1, 5), 6);
	}
	
}
