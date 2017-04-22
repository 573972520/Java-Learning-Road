package OOPTest5;

public class Test2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person pKimi = new Person();
		pKimi.setName("kimi");
		pKimi.setAge(7);
		
		Person pLZY = new Person();
		pLZY.setName("林志颖");
		pLZY.setAge(37);
		
		pKimi.setFather(pLZY);
		System.out.println("孩子"+pKimi.getName()+"父亲是"+pKimi.getFather().getName());
		
	}

}
