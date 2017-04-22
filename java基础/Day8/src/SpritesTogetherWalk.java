

import com.rupeng.game.GameCore;

public class SpritesTogetherWalk implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
			//精灵齐步走和按照顺序走案例
		
			for (int num = 0; num < 6; num++) { //创建6个精灵（刚开始自己想的是将Y轴作为约束，但是发现后面行不通）
					GameCore.createSprite(num, "mario");
					GameCore.setSpriteFlipX(num, true);
					GameCore.playSpriteAnimate(num, "walk", true);
					GameCore.setSpritePosition(num, 20, num*80);
			}
			 //齐步走
//			for (int moveX = 0; moveX < 600; moveX++) { //外部的for循环表示X轴的增加
//				for (int num = 0; num < 6; num++) { //内部的for循环可以理解为将所有的精灵都选中，然后统一增加X轴的值
//					GameCore.setSpritePosition(num, moveX, num*80);
//				}
//			}
			
			//按照顺序走
			for (int num = 0; num < 6; num++){ //外部的for循环表示只是先选择编号为0的精灵
				for (int moveX = 0; moveX < 600; moveX++) { //内部的for循环和外部的for循环一结合，可以表示为将编号为0的精灵先进行X轴的增加，在依次按照编号顺序增加X轴值
					GameCore.setSpritePosition(num, moveX, num*80);
				}
			}
		GameCore.pause(100000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new SpritesTogetherWalk());
	}

}
