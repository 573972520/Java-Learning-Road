import java.util.Stack;

public class java_collection_Test7_栈StackTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//栈的特点：先入后出（First In Last Out）
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(4);
		stack1.push(45); //放入元素
		stack1.push(445);
		stack1.push(44555);
		while (!stack1.empty()) //判断栈内元素不为空
		{
			System.out.println("peek=" + stack1.peek()); //瞟一眼顶部的元素
			int i = stack1.pop(); //取出顶部的元素
			System.out.println(i);
		}
	}

}
