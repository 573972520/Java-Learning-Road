package com.rupeng.oogame;
import java.awt.Point;



abstract public class GameObject
{
	public abstract void hide();
	public abstract void show();
	public abstract Point getPosition();
	public abstract void setPosition(int x,int y);
	
	public void moveRight(int stepCount)
	{
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int x = pos.x;
		x+=stepCount;
		this.setPosition(x, pos.y);
	}
	public void moveRight()
	{
		//调用getPosition()就是了，会有一个”龟孙子“实现这个方法
		/*
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int x = pos.x;
		x+=8;
		this.setPosition(x, pos.y);
		*/
		moveRight(1);
	}
	public void moveLeft(int stepCount)
	{
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int x = pos.x;
		x-=stepCount;
		this.setPosition(x, pos.y);
	}
	public void moveLeft()
	{
		//调用getPosition()就是了，会有一个”龟孙子“实现这个方法
		/*
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int x = pos.x;
		x-=8;
		this.setPosition(x, pos.y);
		*/
		moveLeft(1);
	}
	public void moveUp()
	{
		//调用getPosition()就是了，会有一个”龟孙子“实现这个方法
		
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int y = pos.y;
		y-=4;
		this.setPosition(pos.x,y);
	}
	public void moveDown()
	{
		//调用getPosition()就是了，会有一个”龟孙子“实现这个方法
		
		Point pos = this.getPosition();  //this.getPosition 调用当前对象的方法（反正对象不会是GameObject而是text、image、sprite其中一个）
		int y = pos.y;
		y+=4;
		this.setPosition(pos.x,y);
	}

}
