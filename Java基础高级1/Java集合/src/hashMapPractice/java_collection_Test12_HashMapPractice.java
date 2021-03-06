package hashMapPractice;

import java.util.HashMap;
import java.util.Set;

public class java_collection_Test12_HashMapPractice
{

	public static void main(String[] args)
	{

		// 以char为key，次数为value的HashMap
		String s = "asdfioh89hwe9vhwqfpjsdv  bawemfgpwehtguiwerbgvisdfnasdp[fhweribvweoi  fweuipcasdp[vjseriovwer";
		HashMap<Character, Integer> data = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) //遍历s每个char
		{
			char ch = s.charAt(i);
			if (!data.containsKey(ch)) //如果输入的ch没有再次重复的出现（即第一次出现这个ch），那么value设置为1（即设置这个未曾出现过的ch的初始值为1）
			{
				data.put(ch, 1);
			} else //如果data中再次出现了这个ch,那么增加这个ch的value一次
			{
				int count = data.get(ch); //取出这个再次出现的ch的value（即次数）
				count++;
				data.put(ch, count);
			}
		}
		Set<Character> keySet = data.keySet(); //keySet方法返回所有的key值，并且因为key值不应该重复，所以使用Set接口(因为Set中的重复的元素只会保留一份，这样与key的性质很容易对应)
		for (char ch : keySet)
		{
			int count = data.get(ch);
			System.out.println(ch + "出现了" + count + "次");
		}

		/*//keySet方法
		Map map = new HashMap();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "d");
		map.put(5, "q");
		map.put(5, "d"); //不管key是否重复(当然理论上key不应该重复)，keySet方法还是只会返回一个key
		Set keys1 = map.keySet(); //keySet方法：获取所有的key值
		Set keys2 = map.keySet();
		System.out.println(keys1);
		System.out.println(keys2);*/
	}


}
