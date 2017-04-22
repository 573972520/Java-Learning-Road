import com.rupeng.game.GameCore;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class KeyBoom implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int marioNum = 0;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 200);
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		GameCore.setGameSize(300, 300);
		Dimension gameSize =  GameCore.getGameSize();  //得到游戏窗口的大小
		int gameWidth = gameSize.width; //得到游戏窗口的宽度
		int gameHeight = gameSize.height;//得到游戏窗口的高度
		Dimension spriteSize = GameCore.getSpriteSize(marioNum);//得到精灵的尺寸
		int spritesWidth = spriteSize.width;//得到精灵的宽度
		int spritesHeight = spriteSize.height;//得到精灵的高度
		
		int tuoluoNum = 1;
		GameCore.createSprite(tuoluoNum, "tuoluo");
		GameCore.setSpritePosition(tuoluoNum, 100, 100);
		GameCore.playSpriteAnimate(tuoluoNum, "rotate", true);
		Point tuoluoPos = GameCore.getSpritePosition(tuoluoNum);
		//初始是一个隐藏状态的一个炸弹
		//不能在要爆炸的时候，再去创建这个精灵，否则会造成重复创建
		//如果将下面创建炸弹的代码放到判断距离是否小于20的if语句中时，系统会报错误(编号为2的sprite已经存在，不能重复创建)，因为程序会一直判断这个距离，每判断一次就会创建一个炸弹，但是编号却一直是2，所以会报错！
		int bombNum = 2;
		GameCore.createSprite(bombNum, "bomb");
		GameCore.setSpritePosition(bombNum, 100, 100);
		GameCore.hideSprite(bombNum);
		
		
		for(;;){
			int kc = GameCore.getPressedKeyCode(); //得到用户的按键
			Point pos = GameCore.getSpritePosition(marioNum);//获取精灵当前位置
			if (kc == KeyEvent.VK_RIGHT||kc ==KeyEvent.VK_D) {
				if (pos.x < gameWidth-spritesWidth) { //不能超过右边界，最多为“游戏窗口宽度-精灵的宽度“
					GameCore.setSpriteFlipX(marioNum, true);
					GameCore.setSpritePosition(marioNum, pos.x+1, pos.y);
				}
			}
			else if (kc == KeyEvent.VK_LEFT||kc ==KeyEvent.VK_A){
				if (pos.x > 0) {//不能超过左边界
					GameCore.setSpriteFlipX(marioNum, false);
					GameCore.setSpritePosition(marioNum, pos.x-1, pos.y);
				}
			}
			else if (kc == KeyEvent.VK_UP||kc ==KeyEvent.VK_W) {
				if (pos.y > 0) {//不能超过上边界
					GameCore.setSpritePosition(marioNum, pos.x, pos.y-1);
				}
			}
			else if (kc == KeyEvent.VK_DOWN||kc ==KeyEvent.VK_S) {
				if (pos.y < gameHeight-spritesHeight) {//不能超过下边界，最多为“游戏窗口高度度-精灵的高度“
													  //游戏窗口的高度包含标题栏，所以还可以减去一个20 来修正一下(我这里没有减掉20)
					GameCore.setSpritePosition(marioNum, pos.x, pos.y+1);
				}
			}
			//pow(a,b)表示a的b次方，例如pow(4,0.5)表示根号4，pow(4,2)表示4的2次方
			double distion = Math.pow((tuoluoPos.x - pos.x)*(tuoluoPos.x - pos.x)+(tuoluoPos.y - pos.y)*(tuoluoPos.y - pos.y), 0.5);
			//表示（X1-X2）*（X1-X2）+(Y1-Y2)*(Y1-Y2)的平方根
			//从而计算出了两个点的距离
			if (distion < 20) {
//下面三行代码不能写在if语句中，错误原因——会重复创建编号为2的炸弹。会导致错误！
//				int bombNum = 2;
//				GameCore.createSprite(bombNum, "bomb");
//				GameCore.setSpritePosition(bombNum, 100, 100);
				GameCore.hideSprite(tuoluoNum);//隐藏陀螺
				GameCore.showSprite(bombNum);//显示炸弹
				GameCore.playSpriteAnimate(bombNum, "fire", true);//播放炸弹效果
			}
			GameCore.pause(10);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new KeyBoom());
	}

}
