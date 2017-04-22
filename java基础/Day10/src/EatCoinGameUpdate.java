import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import com.rupeng.game.GameCore;

public class EatCoinGameUpdate implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int SpritesNum = 500;//mario编号
		int[] nums = {10,20,30,40,50,60,70,80}; //金币编号
//		int[] xData = {120,500,632,798,146,200,456,1000};
//		int[] yData = {146,598,254,694,123,156,755,198};
		int[] xData = new int[10];
		int[] yData = new int[10];
//		for (int i = 0; i < yData.length; i++) {
//			int randX = GameCore.rand(2, 1000);
//			int randY = GameCore.rand(3, 500);
//		}
		//金币是否死了，使用boolean数组
		boolean[] coinIsData = new boolean[8];//boolean数组每个元素的默认值是false
		
		GameCore.loadBgView("2.jpg");
		GameCore.setGameSize(1280, 800);
		GameCore.createSprite(SpritesNum, "mario");
		GameCore.setSpritePosition(SpritesNum, 10, 10);
		GameCore.playSpriteAnimate(SpritesNum, "walk", true);
		//获取游戏窗口大小
		Dimension gameSize = GameCore.getGameSize();
		int gameWidth = gameSize.width;
		int gameHeiht = gameSize.height;
		//获取mario的大小
		Dimension spriteSize = GameCore.getSpriteSize(SpritesNum);
		int spriteWidth = spriteSize.width;
		int spriteHeight = spriteSize.height;
		
		int coinImgNum = 2;//大金币图片编号
		GameCore.createImage(coinImgNum, "0.png");
		GameCore.setImagePosition(coinImgNum, 1100, 50);
		int scoreNum = 0;//分数文本编号
		GameCore.createText(scoreNum, "X0");
		GameCore.setTextFontSize(scoreNum, 30);
		GameCore.setTextColor(scoreNum, Color.BLACK);
		GameCore.setTextPosition(scoreNum, 1150, 50);
		int[] bombPosX = {200,500,400};//炸弹X轴
		int[] bombPosY = {300,333,409};//炸弹Y轴
		int[] bombNum = {34,56,89};//炸弹编号
		int leftTimeNum = 33;//剩余时间计时器
		GameCore.createText(leftTimeNum, "还剩40秒");
		GameCore.setTextPosition(leftTimeNum, 900, 20);
		GameCore.setTextFontSize(leftTimeNum, 30);
		GameCore.setTextColor(leftTimeNum, Color.red);
		int gameOverTextNum = 3;
		
		long startMS = System.currentTimeMillis();//得到游戏开始前的毫秒数
		//8枚金币的位置
		for (int i = 0; i < nums.length; i++) {
			int randX = GameCore.rand(2, 1000);
			int randY = GameCore.rand(3, 500);
			int coinNum = nums[i];
			GameCore.createSprite(coinNum, "coin");
			GameCore.setSpritePosition(coinNum, randX, randY);
			GameCore.playSpriteAnimate(coinNum, "rotate", true);
		}
		
		//炸弹位置
		for (int i = 0; i < bombNum.length; i++) {
			int x = bombPosX[i];
			int y = bombPosY[i];
			GameCore.createSprite(bombNum[i], "bomb");
			GameCore.setSpritePosition(bombNum[i], x, y);
			GameCore.playSpriteAnimate(bombNum[i], "laser", true);
		}
	
		//控制mario移动
		for(;;){
			int kc = GameCore.getPressedKeyCode();
			Point pos = GameCore.getSpritePosition(SpritesNum);
			if (kc == KeyEvent.VK_RIGHT) {
				if (pos.x < gameWidth-spriteWidth) {
					GameCore.setSpriteFlipX(SpritesNum, true);
					GameCore.setSpritePosition(SpritesNum, pos.x+1, pos.y);
				}
			}
			else if (kc == KeyEvent.VK_LEFT) {
				if (pos.x > 0) {
					GameCore.setSpriteFlipX(SpritesNum, false);
					GameCore.setSpritePosition(SpritesNum, pos.x-1, pos.y);
				}
				
			}
			else if (kc == KeyEvent.VK_UP) {
				if (pos.y > 0) {
					GameCore.setSpritePosition(SpritesNum, pos.x, pos.y-1);
				}
			}
			else if (kc == KeyEvent.VK_DOWN) {
				if (pos.y < gameHeiht-spriteHeight-30) {
					GameCore.setSpritePosition(SpritesNum, pos.x, pos.y+1);
				}
			}
			
			for (int i = 0; i < nums.length; i++) {
				int coinNum = nums[i];   
				boolean coinIsDead = coinIsData[i];//这里的判断有什么意义，删除这段代码游戏还是会正常运行？
				if (coinIsDead) {                  //这里的判断有什么意义，删除这段代码游戏还是会正常运行？
					continue;//这个金币已经被吃掉了，不用再判断了       
				}                                      
				Dimension coinSize = GameCore.getSpriteSize(coinNum);
				int coinWidth = coinSize.width;
				int coinHeight = coinSize.height;
				int coinX = xData[i];
				int coinY = yData[i];
				//计算金币中心点坐标
				int coinCenterX = coinX+coinWidth/2;
				int coinCenterY = coinY+coinHeight/2;
				//计算马里奥中心点坐标
				int marioCenterX = pos.x+spriteWidth/2;
				int marioCenterY = pos.y+spriteHeight/2;
				double distanceCoinMario = Math.pow((marioCenterX-coinCenterX)*(marioCenterX-coinCenterX)+(marioCenterY-coinCenterY)*(marioCenterY-coinCenterY), 0.5);
				if (distanceCoinMario < 15) {
					GameCore.hideSprite(coinNum);
					coinIsData[i] = true;//将金币死亡的数组对应的变为true
					//数一下，已经吃了多少金币了
					int eatCoinCount = 0;//被吃掉的金币的计数器
					for (int j = 0; j < coinIsData.length; j++) {
						//数一数有多少金币被吃了
						if (coinIsData[j] == true) {
							eatCoinCount++;
						}
					}
					GameCore.setText(scoreNum, "X"+eatCoinCount);
				}
			}
			
			for (int i = 0; i < bombNum.length; i++) {
				                                  
				Dimension bombSize = GameCore.getSpriteSize(bombNum[i]);
				int bombWidth = bombSize.width;
				int bombHeight = bombSize.height;
				int bombX = bombPosX[i];
				int bombY = bombPosY[i];
				//计算地雷中心点坐标
				int bombCenterX = bombX+bombWidth/2;
				int bombCenterY = bombY+bombHeight/2;
				//计算马里奥中心点坐标
				int marioCenterX = pos.x+spriteWidth/2;
				int marioCenterY = pos.y+spriteHeight/2;
				double distanceCoinMario = Math.pow((marioCenterX-bombCenterX)*(marioCenterX-bombCenterX)+(marioCenterY-bombCenterY)*(marioCenterY-bombCenterY), 0.5);
				if (distanceCoinMario < 15) {
					GameCore.createText(bombNum[i], "Game Over");
					GameCore.setTextFontSize(bombNum[i], 60);
					GameCore.setTextPosition(bombNum[i], 600, 350);
					GameCore.setTextColor(bombNum[i], Color.YELLOW);
					GameCore.pause(10000);
			 
			}
			
			long currentMS = System.currentTimeMillis();
			long leftSeconds = 40-(currentMS-startMS)/1000;
			GameCore.setText(leftTimeNum, "还剩"+leftSeconds+"秒");
			if (leftSeconds > 0&&leftSeconds <=10) {
				GameCore.setTextColor(leftTimeNum, leftSeconds%2==0?Color.RED:Color.black);
				}
			else if (leftSeconds <= 0) {
				GameCore.createText(gameOverTextNum, "Game Over");
				GameCore.setTextFontSize(gameOverTextNum, 60);
				GameCore.setTextColor(gameOverTextNum, Color.YELLOW);
				GameCore.setTextPosition(gameOverTextNum, 550, 300);
				GameCore.pause(5000);
				GameCore.exit();
			}
			
			GameCore.pause(0);
		
				}
			
			
			
			}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new EatCoinGameUpdate());
	}

}

