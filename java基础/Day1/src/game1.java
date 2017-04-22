import com.rupeng.game.GameCore;

public class game1 implements Runnable
{
	public static void main(String[] args)
	{
		GameCore.start(new game1());
	}

	public void run()
	{
		/*
		 * GameCore.setGameSize(300, 300); GameCore.pause(3000);
		 * GameCore.setGameTitle("我是你老爹"); //修改游戏标题 //GameCore.pause(1000);
		 * GameCore.setGameSize(400, 400); GameCore.pause(2000);//暂停2000毫秒
		 * GameCore.setGameTitle("我哈哈哈哈哈哈"); GameCore.pause(1000);
		 * GameCore.setGameSize(600, 600); GameCore.pause(2000);
		 */

		/*
		 * GameCore.setGameSize(400, 400); GameCore.pause(1000);
		 * GameCore.setGameSize(500, 400); GameCore.pause(1000);
		 * GameCore.setGameSize(600, 400);
		 * GameCore.setGameTitle("哈哈哈");//修改好这个标题之后，接下来的窗口的标题全部为哈哈哈
		 * GameCore.pause(1000); GameCore.setGameSize(700, 400);
		 * GameCore.pause(1000); GameCore.setGameSize(800, 400);
		 * GameCore.pause(1000); GameCore.setGameSize(900, 400);
		 * GameCore.pause(1000);
		 */

		// GameCore.alert(12+21);
		// GameCore.alert("12+21");

		GameCore.setGameSize(1500, 900);
		GameCore.alert("进入第一关");
		GameCore.loadBgView("1.jpg");
		GameCore.playSound("1.mp3", true); // 一直重复播放
		GameCore.closeSound("1.mp3");// ? 此代码在该位置会不使音乐关闭
		GameCore.pause(3000);
		// GameCore.closeSound("1.mp3");//? 此代码在该位置会使音乐关闭
		GameCore.alert("进入第二关");
		GameCore.playSound("HOT.mp3", false);// 只播放一次
		GameCore.pause(10000);

	}

}
