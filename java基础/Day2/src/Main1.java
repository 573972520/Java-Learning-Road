import com.rupeng.game.GameCore;

public class Main1 implements Runnable
{
	public static void main(String[] args)
	{
		GameCore.start(new Main1());
	}

	public void run()
	{
		/*
		 * GameCore.setGameTitle("第一天练习"); GameCore.alert("林志玲");
		 * GameCore.loadBgView("2.jpg"); GameCore.playSound("HOT.mp3", true);
		 * GameCore.pause(3000); GameCore.closeSound("HOT.mp3");
		 * GameCore.alert("赵丽颖"); GameCore.loadBgView("1.jpg"); GameCore.alert(
		 * "Game over!");
		 */

		/*
		 * String myname = "如鹏网"; //myname就是变量 GameCore.setGameTitle(myname);
		 * GameCore.alert(myname);
		 */

		/*
		 * String name = "jack"; //加了类型String 声明变量name，并且把它贴到“jack”这个数据上
		 * GameCore.alert(name); GameCore.alert("name"); name = "Tom";
		 * //未加类型String， 把name变量贴到“Tom”数据上 GameCore.alert(name);
		 * //过去的就过去了，变量指向新的数据，只会影响之后指令的执行结果。不会“回头算账” int price = 21; String
		 * name1;
		 * 
		 * int age4;//先声明 age4 = 9;//在赋值
		 * 
		 * int age = 7;//声明并赋值
		 */
		
		/*
		//变量的作用域——变量在{}范围之内定义不能重名
		{
			// GameCore.alert(name);//变量必须先定义再使用
			String name = "rupeng.com";
			int age = 8;
			GameCore.alert(name);
			GameCore.alert(age);
		} // 变量的作用域
		//局部变量的作用域就是所在的{},出了作用域就不认识了
		{// 声明一个代码块
			String name = "如鹏";
			int age = 8;
			GameCore.alert(name);
			{
				//String name = "34"; //内层代码块中的变量不能和外层代码快块中的变量重复
			}
		}
		
		
		//String w1 = "12"; //不可以写在前面
		{
			String w1 = "123";
		}
		String w1 = "12";
		*/
		
		
		/*
		//局部变量使用前必须赋值，
		//String name;
		//GameCore.alert(name);
		//声明时赋值
		String name = "run";
		GameCore.alert(name);
		//使用前赋值
		String name1;
		name1 = "boy";
		GameCore.alert(name1);
		*/
		
		byte b1 = 127; //byte的取值范围是-2的7次方到2的7次方减1
		System.out.println(b1);
		
		short s2 = 22222;
		System.out.println(s2);
		
		long l2 = 2332325333513333355L;//记得后面加上L就是long类型
		System.out.println(l2);
		

	}
}
