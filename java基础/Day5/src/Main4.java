import com.rupeng.game.GameCore;

public class Main4 implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		/*
		int i = 6;
		System.out.println(i==6);
		System.out.println(6!=6);
		System.out.println(3==5);
		boolean b = 3==6;
		System.out.println(b);
		*/
		/*
		int i = 4;
		String s1 = "abc123";
		String s2 = "abc123";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		String s3 = "abc" + Integer.parseInt("123");
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3)); //字符串的相等必须用equals判断，不能用==
		System.out.println(i>9);
		
		int i2 = 5;
		i2+=i+4*5;
		System.out.println(i2);
		*/
		/*
		int a = 3;
		int b = 4;
		GameCore.alert(a==b); //flase
		GameCore.alert(a=b); //4
		
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = (b1 == b2); 
		System.out.println(b3);
		System.out.println(b1=b2);
		*/
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		boolean b1 = i1==i2; //false	
		boolean b2 = i1!=i3; //true
		System.out.println(b1);
		System.out.println(b2);
		
		boolean b4 = b1&&b2; //只要一个是false，则结果就是false，只有两边但是true才为true
		boolean b5 = b2||b1;//只有有一个true，则结果就是true
		
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(!b1);
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GameCore.start(new Main4());
	}

}
