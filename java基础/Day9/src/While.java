import com.rupeng.game.GameCore;

public class While implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		int spriteNum = 0;
		GameCore.createSprite(spriteNum, "mario");
		GameCore.setSpritePosition(spriteNum, 100, 100);
		GameCore.setSpriteFlipX(spriteNum, true);
		GameCore.playSpriteAnimate(spriteNum, "walk", true);
		int spritex = 100;
		int spritey = 100;
		for(;;){ //无限循环的走
			while (spritex <= 300) { //X轴的值逐渐增加
				GameCore.setSpritePosition(spriteNum, spritex, spritey);
				spritex++;
			}
			while (spritey <= 300) { //Y轴的值逐渐增加
				GameCore.setSpritePosition(spriteNum, spritex, spritey);
				spritey++;
			}
			while (spritex > 100) {	//X轴的值逐渐减小，直到减小到100（所以要设置spritex > 100这个要注意！！）
				GameCore.setSpritePosition(spriteNum, spritex, spritey);
				spritex--;
			}
			while (spritey > 100) { //Y轴的值逐渐减小，直到减小到100（所以要设置spritey > 100这个要注意！！）
				GameCore.setSpritePosition(spriteNum, spritex, spritey);
				spritey--;
			}
		}
		*/
		int h = 0;
		int timeNum = 0;
		GameCore.createText(timeNum, "");
			while (h <= 24) {
				int m = 0;
				while (m <= 59) {
					int s = 0;
					while (s <= 59) {
						String time = h+":"+m+":"+s;
						GameCore.setText(timeNum, time);
						s++;
					}
					m++;
				}
				h++;
			}
			
//		while (h <= 59) {
//			
//			while (m <= 59) {
//				
//				while (s <= 59) {
//					String time = h+":"+m+":"+s;
//					GameCore.setText(timeNum, time);
//					s++;
//					m++;
//					h++;
//				}
//			}
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int y = 0;
//		while (y < 5) {
//			System.out.println("love");
//			y++;
//		}
//		int i = 100;
//		while (i <= 200) {
//			System.out.println(i);
//			i++;
//		} 
		
//		int sum = 0;
//		int j = 0;
//		while (j <= 100) {
//			 sum += j;
//			 j++;
//		}
//		System.out.println(sum);
		
		GameCore.start(new While());
		
	}

}
