package com.rupeng.oogame;

import java.awt.Dimension;

import com.rupeng.game.GameCore;;

public abstract class GameRect extends GameObject
{
	/**
	 * 获得文档的大小
	 * @return
	 */
	public abstract Dimension getSize();
	
	public boolean isIntersectWith(GameRect rect2)
	{
		//是否左不相交：this的左边缘的x坐标>rect2的右边缘的x坐标
		boolean isNotRectLeft = this.getPosition().x > rect2.getPosition().x+rect2.getSize().width;
		//是否右不相交：this的右边缘的x坐标<rect2的左边缘的x坐标
		boolean isNotRectRight = this.getPosition().x+this.getSize().width < rect2.getPosition().x;
		//是否上不相交：this的上边缘的y坐标>rect2的下边缘的y坐标
		boolean isNotRectUp = this.getPosition().y  > rect2.getPosition().y+rect2.getSize().height;
		//是否下不相交：this的的下边缘的y坐标<rect2的上边缘的y坐标
		boolean isNotRectDown = this.getPosition().y+getSize().height < rect2.getPosition().y;
		//老师写的判断
		return !isNotRectLeft&&!isNotRectRight&&!isNotRectUp&&!isNotRectDown;
		//自己写的判断
//		boolean isNotIntersect = isNotRectLeft||isNotRectRight||isNotRectUp||isNotRectDown;
//		return !isNotIntersect;
	}
	
//	/**
//	 * 判断当前对象是否碰撞了游戏窗口的边缘
//	 * @return
//	 */
//	public boolean isHitGameWindow()
//	{
//		if (this.getPosition().x <= 0)
//		{
//			return true;
//		}
//		if (this.getPosition().x+this.getSize().width >= GameCore.getGameSize().width)
//		{
//			return true;
//		}
//		if (this.getPosition().y <= 0)
//		{
//			return true;
//		}
//		if (this.getPosition().y+this.getSize().height >= GameCore.getGameSize().height)
//		{
//			return true;
//		}
//		return false;
//		
//	}
}
