package digui.one;

public class Digui {
	//�ݹ鷽��
	//�ݹ�Ķ��壺�����Լ������Լ����ǵݹ�
	
	public static void a()
	{
		a(); //�������ǵݹ鷽��
	}
	//����ݹ鷽��û�����ƣ�����û�з��ص�ʱ�򣩣��������տ϶����׳�StackOverflowError
	//�ݹ���Ҫ�ص㣺��1��Ҫ�к���ķ�������������tellStory������˵�����ķ���������i == 3
	//�ݹ���Ҫ�ص㣺��2����������:��������Լ������Լ����������Ϊ�����Լ������Լ��Ĺ�ʽ��ֱ�ӵ���tellStory()
	public static void tellStory(int i )
	{
		System.out.println(i + "��ǰ�и���...");
		if(i == 13)
		{
			return;//�����ˣ���Ϣ
		}
		i++;
		tellStory(i);
	}
	
	public static void main(String[] args)
	{
		tellStory(1);
	}
}
