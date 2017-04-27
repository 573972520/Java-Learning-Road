package src;

public class ExceptionDemo {

	//Ϊʲô���෽�������׳����෽��û���������쳣
	
	/*
	 * ���е��쳣������Ϊ�׳���
	 * ���԰��쳣��Ϊ���֣�����쳣�ͷǼ���쳣
	 * 
	 * 1�����һ���������ܻ��׳�����쳣������Ҫ�ڷ�������ʱ��ȷ��ָ������
	 *   ��ô������������ķ�������Ҫ��ȷָ������δ�����ܷ������쳣��
	 *   ��ͨ��try-catch������쳣��Ҳ����ͨ�������׳���ͬ���쳣
	 *   
	 * 2�����һ���������ܻ��׳��Ǽ���쳣������Ҫ�ڷ�������ʱָ�����׳����쳣
	 *   ���������߾���Ϊ�˷��������׳��쳣����ȻҲ�Ͳ���Ҫ�����쳣
	 */
	public static void main(String[] args) {//throws Exception 
		// TODO Auto-generated method stub
		
		/*
		try {
			divide(10,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); //�����java.lang.Exception: ����������Ϊ0 
			System.out.println("�������:"+e.getMessage());//���:�������:����������Ϊ0
		}
		
		divide2(10,0);//���:Exception in thread "main" java.lang.RuntimeException: ����������Ϊ0
		*/
		
		//Parent p = new Parent();
		Parent p = new Child();
		printShow(p);
	}
	
	//����쳣
	public static int divide(int chushu,int beichushu) throws Exception
	{
		if(beichushu == 0)
		{
			throw new Exception("����������Ϊ0");
		}
		return chushu/beichushu;
	}
	
	//�Ǽ���쳣
	public static int divide2(int chushu,int beichushu)
	{
		if(beichushu == 0)
		{
			throw new RuntimeException("����������Ϊ0"); //����Ҫ�ڷ������׳����쳣
		}
		return chushu/beichushu;
	}
	
	//�ڵ�ǰ����ʱ�����ǲ�����ȷ����ǰ��ķ������Ժ����า��ʱ���׳�ʲô���͵��쳣��Ϊ�˱�֤ǰ�����İ�ȫ���ͽ�ֹ���෽���׳����෽��û���������쳣
	//������෽�������׳���һ������쳣����ô����ķ������������׳����쳣�ı������쳣�����࣬����Ҳ���Բ��׳��κ��쳣
	//���䷽�������Ӳ��ܹ���������
	public static void printShow(Parent p)
	{
		p.show();
	}
}

class Parent
{
	public void show()
	{
		System.out.println("parent show...");
	}
}

class Child extends Parent
{
	@Override
	//�����
	public void show()  //throws Exception
	{
		int i = 0;
		if(i > 0)
		{
			//throw new Exception("xxx"); 
		}
		System.out.println("child show...");
	}
}

