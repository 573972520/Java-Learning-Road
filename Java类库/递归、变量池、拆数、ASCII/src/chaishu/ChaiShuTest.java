package chaishu;

public class ChaiShuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����:��һ����ÿ��λ�ϵ���������ȡ���������ǲ���
		
		/**
		 * �Ƚϱ��Ĳ���������ʹ������һ�������㣩
		 
		int num = 345;
		//ȡ�ø�λ�ϵ�����
		int getGe = num%10;
		System.out.println(getGe);
		//ȡ�ø�λ�ϵ�����
		//˼·:��ʮλ�ϵ������ƶ������ұ�
		num = num/10;
		int getShi = num%10;
		System.out.println(getShi);
		System.out.println(num);//�����num�Ѿ������34��
		//ȡ�ø�λ�ϵ�����
		//˼·:��ʮλ�ϵ������ƶ������ұ�
		num = num/10; //�����num�Ѿ������34��
		int getBai = num%10;
		System.out.println(getBai);
		*/
		chaiShu(123489);
	}
	//дһ��������������
	public static void chaiShu(int num)
	{
		while(true)
		{
			//�Ȱ����ұߵ���ȡ����
			int right = num%10;
			System.out.println(right);
			
			//�����ұߵ���������
			num = num/10;
			
			if(num == 0)
			{
				//��ͷ�ˣ��ڲ���ȥ��û��������
				break; //�������whileѭ��
			}
		}
	}

}
