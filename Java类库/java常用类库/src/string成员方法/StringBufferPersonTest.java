package string��Ա����;

public class StringBufferPersonTest {

	public StringBufferPersonTest speak() //���ص����Լ�����Ķ���
	{
		System.out.println("hi");
		return this;
	}

	public StringBufferPersonTest eat() {
		System.out.println("eat");
		return this;
	}

	public StringBufferPersonTest sleep() {
		System.out.println("huhuhu");
		return this;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBufferPersonTest p1 = new StringBufferPersonTest();
		p1.speak().sleep().eat();
		/**
		 * ��������ԭ��
		Person p1 = p.speak();
		p1.eat();
		*/
	}

}
