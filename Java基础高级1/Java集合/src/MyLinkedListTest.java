
public class MyLinkedListTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList();
		list.add("123");
		list.add("abc");
		list.add("hello");
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

}
