import java.awt.Color;

import com.rupeng.game.GameCore;

public class Main3 implements Runnable
{

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GameCore.start(new Main3());
	}

	public void run()
	{
		/*
		GameCore.alert("老子");
		boolean b = GameCore.confirm("are you SB?");//执行方法confirm，把confirm的返回值赋值给boolean类型的变量b
		System.out.println(b);
		GameCore.alert(b);
		String name = GameCore.input("", "你的名字是什么" );
		GameCore.alert("您好,"+name);
		*/
		/*
		 * 实现一个简单的计算器
		String firstNum = GameCore.input("", "输入第一个数");
		String sendentNum = GameCore.input("", "输入第二个数");
		GameCore.alert("两个数之和="+(Integer.parseInt(firstNum)+Integer.parseInt(sendentNum)));
		*/
		/*
		//提示用户输入他的名字，然后再分别输入游戏的宽
		//度和高度，然后改变游戏的标题为“ 某某某的游戏” ，并
		//且把游戏窗口的尺寸修改为用户输入的
		String name = GameCore.input("", "输入你的名字");
		String height = GameCore.input("", "输入高度");
		String weight = GameCore.input("", "输入宽度");
		GameCore.setGameTitle(name+"的游戏");
		GameCore.setGameSize((Integer.parseInt(weight)), (Integer.parseInt(height)));
		GameCore.pause(6000);
		*/
		
		GameCore.setGameSize(943, 939);
		GameCore.loadBgView("1.jpg");
		
		GameCore.createText(0, "超级玛丽");
		GameCore.createText(1, "测试");
		GameCore.pause(3000);
		GameCore.setTextPosition(1, 300, 300);
		GameCore.setText(1,"rpeng");
		GameCore.setTextColor(1,Color.ORANGE);
		GameCore.setTextFontSize(1, 70);
		
		GameCore.pause(3000);

		 
		
	}

}
