import java.io.IOException;

public class 子类不能抛出父类没有声明的检查异常Test6
{
	public static void main(String[] args) throws IOException
	{
		show(); //有两种处理异常的方式，第一是try/catch捕获   第二是throws出去（不知道怎么处理）

		Parent obj = new Parent();
		obj.show1();

		
		Parent obj1 = new Child();
		obj1.show1();
	}

	public static void show() throws IOException
	{

	}

}

class Parent
{
	public void show1()
	{

	}
}

class Child extends Parent
{
	/*@Override
	public void show1() throws IOException //子类不能抛出父类没有声明的检查异常
	{
		
	}*/
}
