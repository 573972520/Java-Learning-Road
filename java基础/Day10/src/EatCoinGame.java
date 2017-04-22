import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import com.rupeng.game.GameCore;

public class EatCoinGame implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int SpritesNum = 500;//mario编号
		int[] nums = {10,20,30,40,50,60,70,80}; //金币编号
		int[] xData = {120,500,632,798,146,200,456,1000};
		int[] yData = {146,598,254,694,123,156,755,198};
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
		//8枚金币的位置
		for (int i = 0; i < nums.length; i++) {
			int coinNum = nums[i];
			GameCore.createSprite(coinNum, "coin");
			GameCore.setSpritePosition(coinNum, xData[i], yData[i]);
			GameCore.playSpriteAnimate(coinNum, "rotate", true);
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
			GameCore.pause(0);
		
			}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new EatCoinGame());
	}

}















/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
 
import com.rupeng.game.GameCore;
 
public class EatCoin implements Runnable
{
 
    @Override
    public void run()
    {
        //金币的横坐标和纵坐标
        int[] coinXData={50,90,180,210,300,320,350,400,300,500};
        int[] coinYData={50,100,80,40,150,55,190,360,100,200};
        //金币是否死了（被吃了）
        //boolean[] coinIsDeadData={false,false,false,false,false,false,false,false};
        boolean[] coinIsDeadData=new boolean[10];//boolean数组每个元素的默认值就是false
        //int数组每个元素的默认值是0
        int[] coinNums={1,2,3,4,5,6,7,8,9,10};//精灵编号
        for(int i=0;i<coinNums.length;i++)
        {
            int coinNum = coinNums[i];
            GameCore.createSprite(coinNum, "coin");
            int x = coinXData[i];//第i个元素的横坐标
            int y = coinYData[i];
            GameCore.setSpritePosition(coinNum, x, y);
            GameCore.playSpriteAnimate(coinNum, "rotate", true);
        }
        int marioNum=0;//马里奥编号
        GameCore.createSprite(marioNum, "mario");
        GameCore.setSpritePosition(marioNum, 0, 0);
        GameCore.playSpriteAnimate(marioNum, "walk", true);
        GameCore.setSpriteFlipX(marioNum, true);
         
        Dimension gameSize = GameCore.getGameSize();
        int gameWidth = gameSize.width;
        int gameHeight = gameSize.height-20;
        Dimension marioSize = GameCore.getSpriteSize(marioNum);
        int marioWidth = marioSize.width;
        int marioHeight = marioSize.height;
         
        int bigCoinNum=0;//大金币图片的编号
        int deadCountTextNum=0;//吃了几个金币的文本的编号
        GameCore.createImage(bigCoinNum,"coin.png");
        GameCore.setImagePosition(bigCoinNum, 700, 0);
         
        //吃掉的金币的计数
        GameCore.createText(deadCountTextNum, "X0");
        GameCore.setTextFontSize(deadCountTextNum, 50);
        GameCore.setTextColor(deadCountTextNum, Color.yellow);
        GameCore.setTextPosition(deadCountTextNum, 750, 0);
         
        while(true)
        {
            int keyCode = GameCore.getPressedKeyCode();
            //得到马里奥当前位置
            Point marioPos = GameCore.getSpritePosition(marioNum);
            int marioX = marioPos.x;
            int marioY = marioPos.y;
            if(keyCode==KeyEvent.VK_LEFT||keyCode==KeyEvent.VK_A)
            {
                if(marioX>0)
                {
                    //todo:引擎bug，true：是的，要翻转；false：不翻转。
                    GameCore.setSpriteFlipX(marioNum, false);
                    marioX--;
                    GameCore.setSpritePosition(marioNum, marioX, marioY);
                }          
                 
            }
            else if(keyCode==KeyEvent.VK_RIGHT||keyCode==KeyEvent.VK_D)
            {
                if(marioX<gameWidth-marioWidth)
                {
                    GameCore.setSpriteFlipX(marioNum, true);
                    marioX++;
                    GameCore.setSpritePosition(marioNum, marioX, marioY);
                }
            }
            else if(keyCode==KeyEvent.VK_UP||keyCode==KeyEvent.VK_W)
            {
                if(marioY>0)
                {
                    marioY--;
                    GameCore.setSpritePosition(marioNum, marioX, marioY);
                }
            }
            else if(keyCode==KeyEvent.VK_DOWN||keyCode==KeyEvent.VK_S)
            {
                if(marioY<gameHeight-marioHeight)
                {
                    marioY++;
                    GameCore.setSpritePosition(marioNum, marioX, marioY);
                }
            }
            //在while(true)之前用一个Date类型的变量记录一下当前时间
            //2中方法：System.currentTimeMillis() 获得当前的毫秒时间
            //在这里再取一下System.currentTimeMillis() 当前时间
            //把两个时间相减，如果发现相差超过30000毫秒=30秒，还有没被吃掉的金币，则认为“任务失败”
             
             
            for(int i=0;i<coinNums.length;i++)
            {
                int coinNum = coinNums[i];
                boolean coinIsDead = coinIsDeadData[i];
                if(coinIsDead)
                {
                    continue;//这个金币已经被吃掉了，不用再判断了
                }
                int coinX = coinXData[i];
                int coinY = coinYData[i];
                //得到金币的大小
                Dimension coinSize = GameCore.getSpriteSize(coinNum);
                int coinWidth = coinSize.width;
                int coinHeight = coinSize.height;
                 
                //计算金币的中心点坐标
                int coinCenterX = coinX+coinWidth/2;
                int coinCenterY = coinY+coinHeight/2;
                 
                //计算马里奥的中心点坐标
                int marioCenterX = marioX+marioWidth/2;
                int marioCenterY = marioY+marioHeight/2;
                //计算金币的中心点和mario的中心点的距离
                double distanceCoinMario = Math.pow((coinCenterX-marioCenterX)*(coinCenterX-marioCenterX)
                        +(coinCenterY-marioCenterY)*(coinCenterY-marioCenterY), 0.5);
                if(distanceCoinMario<15)//如果距离很近，就认为“吃到了”
                {
                    GameCore.hideSprite(coinNum);//隐藏被吃掉的金币
                    coinIsDeadData[i]=true;//把“死亡记录”中的对应位设置为true
                     
                    //数一下已经吃掉几个金币了
                    int eatCount=0;//被吃掉的金币的计数器
                    for(int j=0;j<coinIsDeadData.length;j++)
                    {
                        //数一共有多少金币被吃了
                        //if(coinIsDeadData[j]==true)
                        if(coinIsDeadData[j])
                        {
                            eatCount++;
                        }
                    }
                    //更新界面上“被吃掉的金币”的数量文本
                    GameCore.setText(deadCountTextNum, "X"+eatCount);
                }
            }
             
            GameCore.pause(20);
        }
    }
 
    public static void main(String[] args)
    {
        GameCore.start(new EatCoin());
    }
 
}

*/

