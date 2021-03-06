
public class JVMTest1
{

	public static void main(String[] args) //栈内存用来存储方法执行时创建的局部变量
	//方法每执行一次，就会在栈内存中开辟一块内存空间，称为栈帧，方法执行结束后，这个栈帧随即被销毁回收

	{
		int age1 = 116; //在main方法的内存空间中创建局部变量，创建出来的局部变量默认值为0，接着再将116赋值给这个局部变量
		Dog dog1 = new Dog(); //（1）先将Dog类的信息加载到方法区中，即下面的class Dog{}
		//这行代码分三个阶段执行，第一、先将Dog类型的变量dog1创建出来。 --> 变量dog1会在main方法的内存空间中创建并且初始值为null
		//第二、使用new关键字创建出Dog对象。 -->使用new关键字创建出来的对象都存储在堆内存中,会设置这个对象的首地址（例如地址为0x10）
		//第三、将创建出来的对象赋值给变量  --> 将变量dog1的默认值null改成首地址0x10，使变量指向这个对象
		User user1 = new User();//（1）先将User类的信息加载到方法区中，即下面的class User{}
		//这行代码分三个阶段执行，第一、先将User类型的变量user1创建出来。 --> 变量user1会在main方法的内存空间中创建并且初始值为null
		//第二、使用new关键字创建出User对象。 -->使用new关键字创建出来的对象都存储在堆内存中,会设置这个对象的首地址（例如地址为0x20）
		//因为User里有两个字段（age、dog 字段就是类的成员变量（包括public,private,protected））会给它们两个分配内存空间默认值分别为0、null
		//第三、将创建出来的对象赋值给变量  --> 将变量User的默认值null改成首地址0x10，使变量指向这个对象
		user1.setAge(age1);//方法调用，会在栈内存开辟一块内存空间，使User里面的age字段的值改为116
							//方法结束，栈帧被销毁
		user1.setDog(dog1);//同上
	}

}

class Dog//被加载的类的信息存储在方法区中，包括类声明、字段、方法等信息
{

}

class User//被加载的类的信息存储在方法区中，包括类声明、字段、方法等信息
{
	private int age;
	private Dog dog;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Dog getDog()
	{
		return dog;
	}

	public void setDog(Dog dog)
	{
		this.dog = dog;
	}

}
