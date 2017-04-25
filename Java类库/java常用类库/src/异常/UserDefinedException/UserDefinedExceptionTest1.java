package 异常.UserDefinedException;

public class UserDefinedExceptionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			test(1);
		} 
		catch (My2Exception e) 
		{
			System.out.println("test调用出错:"+e.getMessage());
		}
	}
	static void test(int i) throws My2Exception
	{
		if(i < 10)
		{
			//throw new IllegalArgumentException("i错误");
//			throw new UserDefinedException("有点错误");
			throw new My2Exception("有点错误");
			//一般自定义异常抛出给调用者，自己抛出自己处理，鉴定为：脑子有毛病
			//抛出异常是通知调用者：我出错了
		}
		else
		{
			System.out.println("i大于等于10");
		}
		
	}
}
