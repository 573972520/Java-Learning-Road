import com.rupeng.game.GameCore;

public class IF implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		int age = Integer.parseInt(GameCore.input("", "输入年龄"));
		if (age>=18) {
			GameCore.loadBgView("1.jpg");
			GameCore.pause(2000);
		}else {
			GameCore.alert("未满18岁不能看");
		}
		*/
		
		
		/*
		int age = Integer.parseInt(GameCore.input("", "输入年龄"));
		if (age<=0) {
			GameCore.alert("草泥马你是SB啊,重新输入啊！");
			int j = Integer.parseInt(GameCore.input("", "输入年龄"));
			if (j>=0) {
				GameCore.loadBgView("1.jpg");
				GameCore.pause(2000);
			}
		}else {
			GameCore.loadBgView("1.jpg");
			GameCore.pause(2000);
		}
		*/
		
		
		/*
		int i = 6;
		if (i=6) {//if后面的表达式不是boolean值，所以出错
			
		}
		*/
		
		
		
		boolean b = false;
		if (b=true) {  //相对于if(true)  if后面的表达式是boolean值就行
			System.out.println(b);
		}
		
		
		
		/*
		int i = 5;
		if (i) { //在C语言中这个if（i）相对于if（i>0），但是在java中不能这样用
			
		}
		*/
		
		
		
		/*
		int i =3;
		if (i>5)  //如果if省略大括号，则编译器会将它最下面的一行代码自动加上大括号
			System.out.println("1");
			System.out.println("2");
		//所以使用if时，那怕只有一句话也必须使用大括号
		*/
		
		/*
		int j = 2;
		if (j>5); //在if后面加上分号的时候，相对于if（j>5）{} ，使if成为了一个空的代码体
		{
			System.out.println("123");
		}
		*/
		
	
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new IF());
	}

}
