
public class MyGenericArrayList<T>
{
	private Object[] data;
	private int currentSize = 0; //当前的数据条数

	public MyGenericArrayList() //构造函数，用于初始化成员变量
	{
		this.data = new Object[5];
	}

	/**
	 * 添加数据元素到集合中
	 * @param obj
	 */
	public void add(T obj)
	{
		//需要扩容
		if (currentSize >= this.data.length)
		{
			Object[] newData = new Object[this.data.length + 5];
			//把旧的数据拷贝到newData中
			for (int i = 0; i < this.data.length; i++)
			{
				newData[i] = data[i];
			}
			this.data = newData; //让data对象指向新的数组对象，这样旧的那个数组对象就抛弃了
		}
		//不需要扩容
		data[currentSize] = obj; //将数据赋给data数组
		currentSize++;
	}

	/**
	 * 获取数据的条数
	 * @return
	 */
	public int size()
	{
		return this.currentSize;
	}

	/**
	 * 获取集合中第index个元素
	 * @param index 从0开始
	 * @return
	 */
	public T get(int index)
	{
		if (index >= currentSize) //大于等于是因为序号是从0开始的
		{
			throw new IllegalArgumentException("超出集合元素的个数");
		}
		return (T) this.data[index]; //将数组类型的显式转换成T类型
	}

	public static void main(String[] args)
	{
		MyGenericArrayList<String> m1 = new MyGenericArrayList<String>();
		m1.add("23");
		m1.get(2);

		MyGenericArrayList<Integer> m2 = new MyGenericArrayList<Integer>();
		m2.add(23);
		m2.get(2);
	}
}
