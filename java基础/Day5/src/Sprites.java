import com.rupeng.game.GameCore;

public class Sprites implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		/*
		int marioNum = 0;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 100);
		GameCore.playSpriteAnimate(marioNum, "idle", true);
		*/
		
		int marioNum = 0;
		int marioY = 200;
		int leftX = 110;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 100);
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		GameCore.pause(200);
	
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10; marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		leftX+=10;marioY+=10;
		GameCore.setSpritePosition(marioNum, leftX, marioY);GameCore.pause(200);
		/*
		GameCore.alert("换X轴方向");
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.alert("换Y轴方向");
		GameCore.setSpriteFlipY(marioNum, true);
		
		GameCore.pause(10000);
		*/
		
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GameCore.start(new Sprites());
	}

}
