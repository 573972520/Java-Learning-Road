package digui.one;

public class Prepare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		a();
		c();
	}
	
	//�ݹ�׼��֪ʶ��
	
	//1  ����ִ��˳��
	//��main��������a����ʱ��������뵽a������ִ��a�����Ĵ��룬
	//��a�����е���b����ʱ�򣬳������뵽b�����У�ִ��b�����Ĵ��룬
	//��b����ִ����ɵ�ʱ��������b������ִ����ɣ�b�������أ�����ͻص���a������
	public static void a()
	{
		System.out.println("a");
		b();
		System.out.println("c");
	}
	public static void b()
	{
		System.out.println("b");
	}
	
	//2  ����ִ��ʱ�ڴ�����ʲô
	//ÿ��������ÿ��ִ�У�java���������Ϊ���������ջ�ڴ��з���һ�鵥����������ڴ�ռ�
	//��һ������ִ����ɵ�ʱ�������������ո�����������ִ�з�����ڴ�ռ�
	public static void c()
	{
		int i = 1;
		d();
		System.out.println(i);
	}
	public static void d()
	{
		int i = 5;
	}
}
