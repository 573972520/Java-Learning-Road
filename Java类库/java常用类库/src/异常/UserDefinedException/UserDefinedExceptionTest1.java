package �쳣.UserDefinedException;

public class UserDefinedExceptionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			test(1);
		} 
		catch (My2Exception e) 
		{
			System.out.println("test���ó���:"+e.getMessage());
		}
	}
	static void test(int i) throws My2Exception
	{
		if(i < 10)
		{
			//throw new IllegalArgumentException("i����");
//			throw new UserDefinedException("�е����");
			throw new My2Exception("�е����");
			//һ���Զ����쳣�׳��������ߣ��Լ��׳��Լ���������Ϊ��������ë��
			//�׳��쳣��֪ͨ�����ߣ��ҳ�����
		}
		else
		{
			System.out.println("i���ڵ���10");
		}
		
	}
}
