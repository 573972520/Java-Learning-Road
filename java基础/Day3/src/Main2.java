import com.rupeng.game.GameCore;

public class Main2 implements Runnable
{
	public static void main(String[] args)
	{
		GameCore.start(new Main2());
	}

	public void run()
	{
		/*
		String s1 = "rupeng";
		String s2 = "baidu";
		s1 = s2; //让s1指向s2当前指向的数据，赋值操作
		System.out .println(s1);
		
		byte b = 5;
		int i = 9;
		i = b; //赋值操作，两边类型不一致，就会有类型转换
		//把范围小的赋值给范围大的变量是可以的，发生一次隐式转换
		System.out.println(i);
		
		int t = 12;
		byte e = (byte)t; //告诉编译器说：接受吧，没事的，你能撑得下（显示类型转换）
		//但是数据太大的话会溢出例如int t = 1233时，会输出-47
		System.out.println(e);
		*/
		/*
		double d1 = 3.14D;
		double d2 = 3.14;
		double d3 = 3;
		//float f1 = 3.14; //小数常量默认是double类型，不能从double转换成float
		float f2 = 3.14F;
		float f3 = f2;
		
		double d5 = f2;
		float f5 = (float)d5;
		int i2 = (int)d5;
		System.out.println(f3);
		System.out.println(d5);
		System.out.println(f5);
		System.out.println(i2);
		*/
		/*
		System.out.println(3.22*3.99);
		System.out.println(3/9);
		System.out.println(3/9.0);
		System.out.println(3/9F);
		System.out.println(3/9D);
		System.out.println(3.0/9);
		System.out.println(3F/9);
		System.out.println(3F/9F);
		System.out.println((6/4)*2.0);//int和int运算，结果还是int
		System.out.println((6.0/4)*2.0);
		System.out.println((1/3)*3);
		System.out.println((1.0/3)*3);
		*/
		/*
		boolean b1 = true;
		boolean b2 = false;
		String s1 = "我\\\"叶良辰\\\"是最SB的";
		String s2 = "sfasd\nssada\ts";
		String s3 = "a\\\\na";
		System.out.println(s2.length());
		System.out.println(s2);
		System.out.println(s1.length());
		System.out.println(s1);
		System.out.println(s3.length());
		System.out.println(s3);
		*/
		/*
		int i = 5;
		//string s0 = (string)i; //数据类型中，只有整数类型、小数类型之间才能进行显示或者隐式的转换
		String s1 = String.valueOf(i); //int -> String
		String s2 = Integer.toString(i);//int -> String
		System.out.println(s1);
		System.out.println(s2);
		
		int i2 = Integer.parseInt(s1);
		System.out.println(i2);
		
		char c1 = 'a'; //单个字符
		char c2 = ' ';
		char c3 = '\n';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		*/
		/*
		System.out.println("rupeng"+123);//字符串和字符串相加，还是字符串
		System.out.println(123+"rupeng"+123);
		System.out.println(123+321+"rupeg");//
		System.out.println("repeng"+123+321);
		System.out.println("repeng"+(123+321));
		System.out.println(3.3+4.66+"rep"+4.3+2.567);
		*/
		/*
		int i = 5; 
		i = i+5;  //先计算右边的值，再把计算结果赋值给左边的变量
		i++;
		System.out.println(i);
		
		int j = 4;
		int b = j; //把j当前的值赋给b
		j = 10;
		System.out.println(b);
		*/
		/*
		 * 交换两个变量的值(方法一)
		int i = 3;
		int j = 5;
		System.out.println("i="+i+"    j="+j);
		int temp = i;
		i = j;
		j = temp;
		System.out.println("i="+i+"    j="+j);
		*/
		/*
		//交换两个变量的值(方法二)
		int i = 3;
		int j = 5;
		System.out.println("i="+i+"    j="+j);
		i = i+j;
		j = i-j;
		i = i-j;
		System.out.println("i="+i+"    j="+j);
		*/
		
		/*
		 * 赋值表达式
		 int a = 5;
		 int b = (a=6);
		 System.out.println(b);
		 b = (a=a+3);
		 System.out.println(b);
		 
		 System.out.println(b=66);
		  */
		/*
		//i++,这个自增赋值表达式的值是自增之前的值
		 int i = 6;
		 int j = i++;
		 System.out.println(j); //j的值为6
		 */
		
		/*
		//i++,这个自增赋值表达式的值是自增之后的值
		 int i = 6;
		 int j = ++i;
		 System.out.println(j);//j的值为7
		 */
		/*
		int i = 5;
		//System.out.println(i++); //结果为5
		//System.out.println(++i); //结果为6
		//但是如果它们两个一起的话的结果便不一样了
		System.out.println(i++); //结果为5
		System.out.println(++i); //结果为7（因为i已经增加一了）
		*/
		/*
		int i = 5;
		//System.out.println(i--); //结果为5
		//System.out.println(--i); //结果为4
		//但是如果它们两个一起的话的结果便不一样了
		System.out.println(i--); //结果为5
		System.out.println(--i); //结果为3（因为i已经增加一了）
		*/
		
		 

	}
}
