import com.rupeng.game.GameCore;

public class dq1 implements Runnable
{

	@Override
	public void run()
	{
		GameCore.alert("234");
		GameCore.loadBgView("1.jpg");
		GameCore.playSound("1.mp3", false);
		GameCore.pause(10000);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		GameCore.start(new dq1());
	}

}
