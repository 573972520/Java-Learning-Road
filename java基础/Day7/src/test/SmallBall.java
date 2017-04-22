package test;

import java.awt.Dimension;


import com.rupeng.game.GameCore;

public class SmallBall implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ball = 0;
		double v = 0; //初始速度
		double y = 0;//初始纵坐标
		double t = 0.1;//单位时间
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 100, 0);
		for(;;){
			v = (v+9.8*t); 
			y = y+v*t;
			if (y > 300) {
				v = -v; //碰到地面，反弹就是速度反向
			}
			GameCore.setSpritePosition(ball, 100, (int)y);
			GameCore.pause(10);
		}
		
		/*
		int ball = 0;
		double vX = 2; //初始X速度
		double vY = 1;//初始Y速度
		double x = 0;//初始横坐标
		double y = 200;//初始纵坐标
		double t = 1.5;//单位时间
		Dimension gameSize = GameCore.getGameSize();
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 100, 0);
		for(;;){ 
			x = x+vX*t;
			y = y+vY*t;
			if (y <= 0||y >= gameSize.height-20) {
				vY = -vY; //碰到地面，反弹就是速度反向
			}
			if (x <= 0||x >= gameSize.width-20) {
				vX = -vX; //碰到地面，反弹就是速度反向
			}
			GameCore.setSpritePosition(ball, (int)x, (int)y);
			GameCore.pause(10);
		}
		*/
		 
		/*
		int ball = 0;
		double vx = 20;
		double vy = 0;
		double x = 0;
		double y = 20;
		double t = 0.5;
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 0, 20);
		for(;;){
			vy = vy+9.8*t;
			x = x+vx*t;
			y = y+vy*t;
			if (y > 500) {
				vy = -vy;
			}
			GameCore.setSpritePosition(ball, (int)x, (int)y);
			GameCore.pause(100);
		}
		*/
		
		/*
		int ball = 0;
		double vx = 15;
		double vy = 45;
		double x = 0;
		double y = 0;
		double t = 0.5;
		GameCore.createSprite(ball, "ball1");
		GameCore.setGameSize(1400, 900);
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 0, 200);
		for(;;){
			vy = vy-9.8*t; //刚开始Y轴的速度会越来越小
			x = x+vx*t;
			y = y+vy*t; //这里的Y不代表Y轴的坐标 因为后面的代码中有（200-y） 当速度变成负数的时候，y的数值开始变小
						//当y变成负数的时候（即小球碰到地板），这个时候，用if判断小于0时候，使Y轴的速度取相反数
			if (y < 0) {
				vy = -vy;
			}
			GameCore.setSpritePosition(ball, (int)x, (int)(200-y));
			GameCore.pause(100);
		}*/
		
//		int ball = 0;
//		double vx = 100;
//		double vy = 45;
//		double x = 0;
//		double y = 200;
//		double t = 0.5;
//		GameCore.createSprite(ball, "ball1");
//		GameCore.setGameSize(1400, 900);
//		GameCore.playSpriteAnimate(ball, "rotate", true);
//		GameCore.setSpritePosition(ball, 0, 200);
//		for(;;){
//			vy = vy-9.8*t;
//			x = x+vx*t;
//			y = y-vy*t; 
//			GameCore.setSpritePosition(ball, (int)x, (int)y);
//			GameCore.pause(100);
//		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new SmallBall());
	}

}
