import java.util.HashMap;

public class java_collection_Test6_泛型Test1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//没有泛型
		HashMap map = new HashMap();
		map.put("cc", 12);

		//有泛型
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("cc", 12);
		//map1.put("cc1", "12"); //报错
		int i = map1.get("hello"); //get方法返回Integer类型

		HashMap<Integer, Double> map2 = new HashMap<Integer, Double>();
		map2.put(4, 3.14);
		map2.get(33);//get方法返回Double类型

	}

}
