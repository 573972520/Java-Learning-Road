package 异常;

public class ThrowableTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = null;
		//Integer i1 = 4;
		try //将可能会发生异常的代码用try包起来
		{
			System.out.println("aaa");
			if(true)
			{
				throw new RuntimeException("我FUCk了");
			}
			int i2 = i1;
			System.out.println("bbb"); //当发现int i2 = i1这行代码发现异常(try代码块中的异常点)的时候，那么try块里面的下面的代码就不会执行了，但是try块外面的代码还是会执行
			
		}
		
		//正确的异常处理是程序的稳定性的关键
		catch(RuntimeException e)
		{
			//如果只是catch异常，不进行处理，相对于"掩耳盗铃"(非常严重)
			//System.out.println("错误,"+e.getMessage());
			//e.printStackTrace();//哥们，出错了，出错信息是...(只是告诉你出错信息，没有处理异常)，所以这个不是一个好的异常处理方法
		}
		
		//一连串的catch，前面如果catch住了父类异常，下面就不能catch子类的异常了
		//所以下面的代码会报错(因为NullPointerException和ArrayIndexOutOfBoundsException的父类都是RuntimeException)
		/*
		catch(NullPointerException e) //catch抓住异常, NullPointerException为要抓住（catch）的异常的类型, e为这个异常对象
		{
			//当发生被抓住的异常,(比如NullPointerException) 那么就会执行catch中的代码
			System.out.println("i1不能为null");
			System.out.println(e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e) //可以catch多个异常
		{
			System.out.println("数组范围超出大小");
		}
		*/
		System.out.println("ccc");//try块之后的代码无论怎么样都会执行
	}

}
		
