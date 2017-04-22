/*
package com.rupeng.oogame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.text.Position;

import com.rupeng.game.GameCore;

public class HitBricks implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		GameCore.setGameSize(1200, 800);
		GameSprite ball = new GameSprite("ball1");
		ball.setPosition(100, 400);
		ball.playAnimate("rotate");
		GameImage imgBoard = new GameImage("1.png");
		imgBoard.setPosition(640, 720);
		int ballVX = GameCore.rand(3, 8); //x方向的分速度
		int ballVY = -1; //y方向的分速度
		
		while(true)
		{
			int keyCode = GameCore.getPressedKeyCode();
			if (keyCode == KeyEvent.VK_LEFT&&imgBoard.getPosition().x > 0)
			{
				imgBoard.moveLeft(12);
			}
			else if (keyCode == KeyEvent.VK_RIGHT&&imgBoard.getPosition().x+imgBoard.getSize().width <= GameCore.getGameSize().width) {
				imgBoard.moveRight(12);
			}
			else {
				
			}
			Point posBall = ball.getPosition();
			int xBall = posBall.x;
			int yBall = posBall.y;
			xBall += ballVX*1;
			yBall += ballVY*1;
			ball.setPosition(xBall, yBall);
			if (xBall == 0) //
			{
				ballVX = -ballVX;
			}
			if (xBall == GameCore.getGameSize().width)
			{
				ballVX = -ballVX;
			}
			if (yBall == 0)
			{
				ballVY = -ballVY;
			}
			if (yBall == GameCore.getGameSize().height)
			{
				GameCore.exit();
			}
			if (ball.isIntersectWith(imgBoard))
			{
				ballVY = -ballVY;
			}
			GameCore.pause(0);
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GameCore.start(new HitBricks());
	}

}

*/

package com.rupeng.oogame;
 
import java.awt.Point;
import java.awt.event.KeyEvent;
 
import javax.annotation.PostConstruct;
 
import com.rupeng.game.GameCore;
 
public class HitBricks implements Runnable
{
 
    @Override
    public void run()
    {
    	GameCore.setGameSize(1290, 800);
        GameImage imgBoard = new GameImage("1.png");
        imgBoard.setPosition(400, 720);
         
        GameSprite spriteBall = new GameSprite("ball1");
        spriteBall.setPosition(100, 400);
        spriteBall.playAnimate("rotate");
        int ballVX=GameCore.rand(1,4);//x方向的分速度
        int ballVY =-5;//y方向的分速度     
        
        BrickInfo[][] bricks = new BrickInfo[4][10];
        for (int i = 0; i < bricks.length; i++)
		{
        	BrickInfo[] brickRows = bricks[i];
			for (int j = 0; j < brickRows.length; j++)
			{
				brickRows[j] = new BrickInfo();
				//GameCore.rand(0, 2)==0
				 //GameCore.rand(0, 2)返回一个>=0并且<2的随机数
		        //这个数如果是0，就有砖，否则就没有
				brickRows[j].setHasBrick(GameCore.rand(0, 2)==0);
			}
		}
        
        for (int i = 0; i < bricks.length; i++)
		{
        	BrickInfo[] brickRows = bricks[i];
			for (int j = 0; j < brickRows.length; j++)
			{
				BrickInfo brickInfo = brickRows[j];
				if (brickInfo.isHasBrick())//如果这个位置有砖，则把砖显示出来
				{
					GameImage imgBrick = new GameImage("2.jpg");
					imgBrick.setPosition(j*129, i*64);
					brickInfo.setImgBrick(imgBrick);
				}
			}
		}
        
        while(true)
        {
            int keycode = GameCore.getPressedKeyCode();
            if(keycode==KeyEvent.VK_LEFT&&imgBoard.getPosition().x>0)
            {
                imgBoard.moveLeft(13);//为了让挡板移动速度快一些，所以提供了一个一次可以移动多步的重载方法
            }
            else if(keycode==KeyEvent.VK_RIGHT
                    &&imgBoard.getPosition().x+imgBoard.getSize().width<GameCore.getGameSize().width)
            {
                imgBoard.moveRight(13);
            }
            Point posBall = spriteBall.getPosition();       
             
            int xBall = posBall.x;
            int yBall = posBall.y;
            xBall+=ballVX*1;
            yBall +=ballVY*1;
             
            spriteBall.setPosition(xBall, yBall);
            if(xBall==20)//碰到了左边
            {
                ballVX=-ballVX;//横向反弹
            }
            if(xBall==GameCore.getGameSize().width-20)//到了右边
            {
                ballVX=-ballVX;//横向反弹
            }
            if(yBall==0)//碰到了上边
            {
                ballVY=-ballVY;
            }
            if(yBall==GameCore.getGameSize().height)//如果碰到下面就死了
            {
                //ballVY=-ballVY;
                GameCore.exit();
            }
            if(spriteBall.isIntersectWith(imgBoard))//当球碰到挡板的时候Y方向速度翻转，也就是反弹
            {
            	System.out.println("1");
                ballVY=-ballVY;
            }
            //再判断是否和某块砖相撞，如果是的话，把砖隐藏，把球纵向反弹
             for (BrickInfo[] brickRow : bricks)
			{
				for (BrickInfo brick : brickRow)
				{
					//如果砖还没有死，并且和球相撞了
					if (brick.isHasBrick()&&brick.isAlive()&&brick.getImgBrick().isIntersectWith(spriteBall))
					{
						brick.setAlive(false);//死掉
						brick.getImgBrick().hide();//消失
						ballVY=-ballVY;
					}
				}
			}
            GameCore.pause(1);
        }
         
         
        //GameCore.pause(100000);
    }
 
    public static void main(String[] args)
    {
        GameCore.start(new HitBricks());
    }
 
}

class BrickInfo  
{
	boolean hasBrick; //这个位置有没有砖
	boolean isAlive;  //砖块是不是活着
	GameImage imgBrick;
	public  BrickInfo()
	{
		this.imgBrick = new GameImage("2.jpg");
		this.isAlive = true;
	}
	public boolean isHasBrick()
	{
		return hasBrick;
	}
	public void setHasBrick(boolean hasBrick)
	{
		this.hasBrick = hasBrick;
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	public GameImage getImgBrick()
	{
		return this.imgBrick;
	}
	public void setImgBrick(GameImage imgBrick)
	{
		this.imgBrick = imgBrick;
	}
	

	
}

