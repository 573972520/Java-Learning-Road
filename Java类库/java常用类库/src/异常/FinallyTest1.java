package �쳣;

public class FinallyTest1 {

	public static void main(String[] args) {
		try 
		{
			int[] nums = {3,5,9};
			System.out.println(nums[9]);//�������鷶Χ
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("���鳬����Χ");
		}
		finally//һ��������Դ�Ļ���
		{
			System.out.println("����finally"); //���۳����Ƿ����쳣��finally�еĴ��붼��ִ��
		}
		//final��������һ�������ϣ�������ʾ�����ܱ����¸�ֵ����һ���౻����Ϊfinal����ʾ����������������µ����࣬������Ϊ���౻�̳С����������ϱ��final������������ܱ����أ�
		//finally
	}

}
