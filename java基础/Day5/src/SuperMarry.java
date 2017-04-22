
import com.rupeng.game.GameCore;

public class SuperMarry implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		/*
		GameCore.setGameTitle("Super Marry");
		GameCore.setGameSize(580, 828);
		GameCore.loadBgView("2.jpg");
		GameCore.playSound("1.mp3", true);
		
		int titleNum = 1;
		GameCore.createText(titleNum, "Super Marry");
		GameCore.setTextPosition(titleNum, 180, 80);
		GameCore.setTextColor(titleNum, Color.BLUE);
		GameCore.setTextFontSize(titleNum, 40);
		
		int selectY = 500;
		int startNum = 2;
		GameCore.createText(startNum, "1-Start");
		GameCore.setTextPosition(startNum, 200, selectY);
		
		selectY+=50;
		int opitionNum = 3;
		GameCore.createText(opitionNum, "2-Opition");
		GameCore.setTextPosition(opitionNum, 200, selectY);
		
		selectY+=50;
		int exitNum = 4;
		GameCore.createText(exitNum, "3-Exit");
		GameCore.setTextPosition(exitNum, 200, selectY);
		
		GameCore.pause(5000);
		*/
		
		GameCore.setGameSize(900, 900);
		GameCore.createImage(1,"3.png");
		GameCore.setImagePosition(1, 100, 110);
		GameCore.pause(3000);
		
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GameCore.start(new SuperMarry()); 
	}

}
