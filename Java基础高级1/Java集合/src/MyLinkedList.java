
public class MyLinkedList
{

	private MyLinkedListNode firstNode = null;//头节点

	/**
	 * 添加元素
	 * @param obj 需要添加的元素的数据
	 */
	public void add(Object obj)
	{
		if (firstNode == null)//如果头节点为null
		{
			firstNode = new MyLinkedListNode();//创建一个节点
			firstNode.setData(obj);//将创建的节点赋值
		}
		else//如果头节点不为null
		{
			MyLinkedListNode currentNode = firstNode;
			while (currentNode.getNext() != null)
			//移动到最后一个节点
			{
				currentNode = currentNode.getNext(); //将最后一个节点的值赋给currentNode
			}
			//走到这里currentNode就是指向最后一个元素

			//创建一个新节点
			MyLinkedListNode newNode = new MyLinkedListNode();
			newNode.setData(obj);
			currentNode.setNext(newNode);//让之前的最后一个元素的next指向这个新节点，这样新节点就成了新的最后一个节点		}
		}
	}

	public int size()
	{
		if (firstNode == null)
		{
			return 0;
		}
		MyLinkedListNode currentNode = firstNode;
		int count = 0;
		while (currentNode != null)
		{
			//currentNode指向当前节点的下一个节点
			currentNode = currentNode.getNext();
			count++;
		}
		//运行到这里currentNode就指向了最后一个元素的next,也就是null 
		return count;
	}

	public Object get(int index)
	{
		MyLinkedListNode currentNode = firstNode;
		int count = 0;
		while (currentNode != null)
		{
			if (count == index)//如果到了要找的序号
			{
				return currentNode.getData(); //把节点数据返回
			}
			//currentNode指向当前节点的下一个节点
			currentNode = currentNode.getNext();
			count++;
		}
		return null; //没有找到
	}
}


