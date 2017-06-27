import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,8,9,31};
		System.out.println(toString(nums));
		String[] strs = {"saf","32rfdsf","32rfsd"};
		System.out.println(toString(strs));
		
		List<Object> list = toList(strs);
		for(Object obj : list)
		{
			System.out.println(obj);
		}
		
	}
	private static List<Object> toList(Object arrays)
	{
		if(arrays.getClass().isArray() == false)
		{
			throw new IllegalArgumentException("不是数组对象");
		}
		List<Object> list = new ArrayList<>();
		int len = Array.getLength(arrays);
		for(int i = 0;i<len;i++)
		{
			Object item = Array.get(arrays, i);
			list.add(item);
		}
		return list;
	}
	
	//能处理全部类型的数组
	public static String toString(Object arrays) //Object[]  String[]  Int[]  之间没有继承关系
	{
		
		if(!arrays.getClass().isArray())  //判断传入对象的类型是不是数组类型
		{
			throw new IllegalArgumentException("传入的不是数组");
		}
		StringBuffer sb = new StringBuffer();
		int len = Array.getLength(arrays);  //获取数组的长度 
		for(int i = 0;i<len;i++)
		{
			sb.append(Array.get(arrays, i)); //获取数组第i个元素的值
			if(i != len - 1)
			{
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	
	//只能处理int类型的数组
	/*public static String toString(int[] arrays)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<arrays.length;i++)
		{
			sb.append(arrays[i]);
			if(i != arrays.length - 1)
			{
				sb.append("|");
			}
		}
		return sb.toString();
	}
*/
	
	
}
