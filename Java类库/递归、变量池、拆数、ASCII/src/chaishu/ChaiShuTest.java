package chaishu;

public class ChaiShuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//拆数:把一个数每个位上的数字依次取出来，就是拆数
		
		/**
		 * 比较笨的拆数方法（使用余数一步步运算）
		 
		int num = 345;
		//取得个位上的数字
		int getGe = num%10;
		System.out.println(getGe);
		//取得个位上的数字
		//思路:把十位上的数字移动到最右边
		num = num/10;
		int getShi = num%10;
		System.out.println(getShi);
		System.out.println(num);//这里的num已经变成了34了
		//取得个位上的数字
		//思路:把十位上的数字移动到最右边
		num = num/10; //这里的num已经变成了34了
		int getBai = num%10;
		System.out.println(getBai);
		*/
		chaiShu(123489);
	}
	//写一个方法用来拆数
	public static void chaiShu(int num)
	{
		while(true)
		{
			//先把最右边的数取出来
			int right = num%10;
			System.out.println(right);
			
			//把最右边的数丢弃掉
			num = num/10;
			
			if(num == 0)
			{
				//拆到头了，在拆下去就没有意义了
				break; //跳出这个while循环
			}
		}
	}

}
