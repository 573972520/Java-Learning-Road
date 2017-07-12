package com.rupeng.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
	
	//58%的中国的程序猿从来没有写过单元测试
	//只有10%的人认真写过单元测试

	//标注@BeforeClass的方法会在Calc运行之前执行一次
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//标注@AfterClass的方法会在Calc运行之后执行一次
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//@Before每个测试方法执行之前都会执行
	@Before
	public void setUp() throws Exception {
	}

	//@After每个测试方法执行之后都会执行
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
