package digui.one;

public class Digui {
	//递归方法
	//递归的定义：方法自己调用自己就是递归
	
	public static void a()
	{
		a(); //这样就是递归方法
	}
	//如果递归方法没有限制（方法没有返回的时候），程序最终肯定会抛出StackOverflowError
	//递归重要特点：（1）要有合理的返回条件，对于tellStory方法来说，他的返回条件是i == 3
	//递归重要特点：（2）递推条件:方法如何自己调用自己，可以理解为方法自己调用自己的公式：直接调用tellStory()
	public static void tellStory(int i )
	{
		System.out.println(i + "从前有个庙...");
		if(i == 13)
		{
			return;//不讲了，休息
		}
		i++;
		tellStory(i);
	}
	
	public static void main(String[] args)
	{
		tellStory(1);
	}
}
