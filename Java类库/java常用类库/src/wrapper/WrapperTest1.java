package wrapper;

public class WrapperTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("aaa");
		//test(4); //会发生错误，在JDK1.4之前（包括1.4）这个方法就不能执行
		//int就是一个关键字，4不是从Object继承的，那么我们这么来实现这个效果呢？
		
		IntWrapper i = new IntWrapper(4); //（1）先将4int存放起来
		test(i);//（5）最后通过
	}
	
	static void test(Object obj)
	{
		if(obj instanceof IntWrapper)//（2）判断obj变量指向的对象是否是IntWrapper类型的
		{
			IntWrapper i = (IntWrapper)obj;//(3)显示转换
			System.out.println(i.getValue());//(4)拿到这个int值
		}
	}
}

class IntWrapper
{
	private int value;
	public IntWrapper(int value) //存放int
	{
		this.value = value;
	}
	public int getValue()//拿到int
	{
		return this.value;
	}
}
