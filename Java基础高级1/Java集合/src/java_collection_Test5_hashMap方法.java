import java.util.HashMap;

public class java_collection_Test5_hashMap方法
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HashMap map1 = new HashMap();
		map1.put("河北", "石家庄"); // 存入键值对
		map1.put("河北1", "1");
		map1.put("1", "3");
		Object obj1 = map1.get("河北");
		System.out.println(obj1);
		Object obj2 = map1.get("四川");
		System.out.println(obj2); //null
		boolean b1 = map1.containsKey("四川");
		System.out.println(b1);//false

		HashMap map2 = new HashMap();
		map2.put("cc", "99");
		map2.put("tom", "60");
		map2.put("tom", "哈哈");//key不能重复，用新的value替换旧的value
		map2.put("jerry", "100");
		map2.put("lang", "60");
		Object obj3 = map2.get("tom"); //根据键查询到值
		System.out.println(obj3); //当键重复之后，会将旧的覆盖

		map2.remove("tom");//移除key为“tom”的键值对
		Object obj4 = map2.get("tom"); //根据键查询到值
		System.out.println(obj4); //null
		map2.clear();
		System.out.println(map2.size());

	}

}
