package string成员方法;

public class StringBufferPersonTest {

	public StringBufferPersonTest speak() //返回的是自己本身的对象
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
		 * 上面代码的原理
		Person p1 = p.speak();
		p1.eat();
		*/
	}

}
