package �쳣;

public class ThrowableTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = null;
		//Integer i1 = 4;
		try //�����ܻᷢ���쳣�Ĵ�����try������
		{
			System.out.println("aaa");
			if(true)
			{
				throw new RuntimeException("��FUCk��");
			}
			int i2 = i1;
			System.out.println("bbb"); //������int i2 = i1���д��뷢���쳣(try������е��쳣��)��ʱ����ôtry�����������Ĵ���Ͳ���ִ���ˣ�����try������Ĵ��뻹�ǻ�ִ��
			
		}
		
		//��ȷ���쳣�����ǳ�����ȶ��ԵĹؼ�
		catch(RuntimeException e)
		{
			//���ֻ��catch�쳣�������д��������"�ڶ�����"(�ǳ�����)
			//System.out.println("����,"+e.getMessage());
			//e.printStackTrace();//���ǣ������ˣ�������Ϣ��...(ֻ�Ǹ����������Ϣ��û�д����쳣)�������������һ���õ��쳣������
		}
		
		//һ������catch��ǰ�����catchס�˸����쳣������Ͳ���catch������쳣��
		//��������Ĵ���ᱨ��(��ΪNullPointerException��ArrayIndexOutOfBoundsException�ĸ��඼��RuntimeException)
		/*
		catch(NullPointerException e) //catchץס�쳣, NullPointerExceptionΪҪץס��catch�����쳣������, eΪ����쳣����
		{
			//��������ץס���쳣,(����NullPointerException) ��ô�ͻ�ִ��catch�еĴ���
			System.out.println("i1����Ϊnull");
			System.out.println(e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e) //����catch����쳣
		{
			System.out.println("���鷶Χ������С");
		}
		*/
		System.out.println("ccc");//try��֮��Ĵ���������ô������ִ��
	}

}
		
