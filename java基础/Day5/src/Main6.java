
public class Main6 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		System.out.println((i1>4)&&(i2<6));
		System.out.println(!(i1>4)||!(i2<6));
		*/
		
		/*
		{
		int i = 8;
		boolean b = (i>5)&&(i=i+5)>10; //true && true
		System.out.println(b);
		System.out.println(i); //i = 13
		}
		{
		int i = 8;
		boolean b = (i>15)&&(i=i+5)>10; //false && true
		//短路运算 （对于上述表达式，因为前面的结果是false，然后为了省事，后面的算式就不运算了）
		System.out.println(b);
		System.out.println(i); //i = 8
		}
		{
		int i = 8;
		boolean b = (i=i+5)>10&&(i>15); //true && false 
		//短路运算 （对于上述表达式，因为前面的结果是true，然后计算后面的算式）
		System.out.println(b);
		System.out.println(i); //i = 13
		}
		//短路运算：对于&&，一旦遇到左边的为false，那么结果一定是false了 ，所以就不再计算后面的表达式了
		 */
		
		/*
		{
		int i = 8;
		boolean b = (i>10||(i=i+6)>10); 
		System.out.println(b);//true 
		System.out.println(i); //i = 14
		}
		{
		int i = 8;
		boolean b = (i>1||(i=i+6)>10); 
		System.out.println(b);//true 
		System.out.println(i); //i = 8
		}
		//短路运算，对于||,一旦遇到左边的为true，那么结果一定是true，因此就不计算右边的表达式了
		*/
		
		/*
		int i = 1;
		int j = (i>3?555:3243);
		System.out.println(j);
		
		String k = (i>4)||(3!=5)?"2":"ddss"; //注意变量的类型是String ！
		System.out.println(k);
		*/
		
		int i = 4;
		System.out.println(i%3 == 0); //证明是否能被3整除
		int j = 9;
		boolean b = (j%3==0);
		System.out.println(b);
		String c = (j%3==0)?"yes":"no";
		System.out.println(c);
		
		
		
	}
}
