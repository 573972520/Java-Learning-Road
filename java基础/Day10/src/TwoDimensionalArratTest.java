import java.io.File;

import com.rupeng.game.GameCore;

public class TwoDimensionalArratTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		GameCore.setGameSize(600, 630);
		int[][] fieldData = {{0,1,0,0,2,3,5,4},
							{0,0,1,1,2,4,2,5},
							{2,1,1,0,1,4,2,5},
							{0,0,2,1,2,3,4,5},
							{1,0,0,2,2,3,5,4},
							{0,0,1,1,2,4,2,5},
							{0,0,1,1,2,4,2,5},
							{0,0,1,1,2,4,2,5}};
		int imgNum = 0;
		for (int i = 0; i < fieldData.length; i++) { //i代表的是第几行
			int[] rowData = fieldData[i];
			for (int j = 0; j < rowData.length; j++) {
				int data = rowData[j];
				if (data == 1) {
					GameCore.createImage(imgNum, "5.png");
					GameCore.setImagePosition(imgNum, j*50,i*50);//所以这里的i是代表Y轴（纵坐标）坐标
					imgNum++;
				}
				else if(data == 2) {
					GameCore.createImage(imgNum, "6.png");
					GameCore.setImagePosition(imgNum, j*50,i*50);
					imgNum++;
				}
				else if (data == 3) {
					GameCore.createImage(imgNum, "7.png");
					GameCore.setImagePosition(imgNum, j*50,i*50);
					imgNum++;
				}
				else if (data ==4) {
					GameCore.createImage(imgNum, "8.png");
					GameCore.setImagePosition(imgNum, j*50,i*50);
					imgNum++;
				}
				else if (data == 5) {
					GameCore.createImage(imgNum, "9.png");
					GameCore.setImagePosition(imgNum, j*50,i*50);
					imgNum++;
				}
			}
		}
		GameCore.pause(50000);
		*/
		
		
		/*
		GameCore.setGameSize(400, 430);
		int[][] fieldData = {{0,1,0,0,2},{0,0,1,1,2},{2,1,1,0,1},{0,0,2,1,2},{1,0,0,2,2}};
		int imgNum = 0;
		for (int i = 0; i < fieldData.length; i++) { //i代表的是第几行
			int[] rowData = fieldData[i];
			for (int j = 0; j < rowData.length; j++) {
				int data = rowData[j];
				if (data == 1) {
					GameCore.createImage(imgNum, "3.jpg");
					GameCore.setImagePosition(imgNum, j*80,i*80);//所以这里的i是代表Y轴（纵坐标）坐标
					imgNum++;
				}
				else if(data == 2) {
					GameCore.createImage(imgNum, "4.jpg");
					GameCore.setImagePosition(imgNum, j*80,i*80);
					imgNum++;
				}
			}
		}
		GameCore.pause(50000);
		*/
		
		/*
		//连连看
		GameCore.setGameSize(500, 530);
		int[][] iconNum = { {1,5,3,4,2,3,4,2,1,5},
							{1,0,2,3,0,4,5,1,3,2},
							{1,0,2,3,0,4,5,1,3,2},
							{1,5,3,4,2,3,4,2,1,5},
							{2,3,5,4,0,1,3,2,5,4},
							{1,0,2,3,0,4,5,1,3,2},
							{2,3,5,4,0,1,3,2,5,4},
							{1,5,3,4,2,3,4,2,1,5},
							{1,0,2,3,0,4,5,1,3,2},
							{1,5,3,4,2,3,4,2,1,5}};
		int imgNum = 0;
		for (int i = 0; i < iconNum.length; i++) {
			int[] row = iconNum[i];
			for (int j = 0; j < row.length; j++) {
				int iconData = row[j];
				if (iconData == 1) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "5.png");
					GameCore.setImagePosition(imgNum, j*50, i*50);
					imgNum++; //记得图片编号要改变
				}
				else if (iconData == 2) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "6.png");
					GameCore.setImagePosition(imgNum, j*50, i*50);
					imgNum++; //记得图片编号要改变
				}
				else if (iconData == 3) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "7.png");
					GameCore.setImagePosition(imgNum, j*50, i*50);
					imgNum++; //记得图片编号要改变
				}
				else if (iconData == 4) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "8.png");
					GameCore.setImagePosition(imgNum, j*50, i*50);
					imgNum++; //记得图片编号要改变
				}
				else if (iconData == 5) {
					GameCore.createImage(imgNum);//一定记得加上GameCore.createImage()!!!
					GameCore.setImageSource(imgNum, "9.png");
					GameCore.setImagePosition(imgNum, j*50, i*50);
					imgNum++; //记得图片编号要改变
				}
			}
		}
		GameCore.pause(5000);
		*/
		int imgNum = 0;
		GameCore.setGameSize(600, 640);
		int[][] gameData = new int[10][10];
		for (int i = 0; i < gameData.length; i++) {
			int[] rowData = gameData[i];
			for (int j = 0; j < rowData.length; j++) {
				int blockData = GameCore.rand(0, 6);
				rowData[j] = blockData;
				String imgName = "";
				if (blockData == 1) {
					imgName = "9.png";
				}
				else if (blockData == 2) {
					imgName = "8.png";
				}
				else if (blockData == 3) {
					imgName = "7.png";
				}
				else if (blockData == 4) {
					imgName = "6.png";
				}
				else if (blockData == 5) {
					imgName = "5.png";
				}
				else if (blockData == 0) {
					imgName = "10.png";
				}
				else {
					GameCore.exit();
				}
				GameCore.createImage(imgNum);
				GameCore.setImageSource(imgNum, imgName);
				GameCore.setImagePosition(imgNum, j*60, i*60); //记得将位置倒过来
				imgNum++;
				
			}
			
			
		}
			GameCore.pause(10000);
		}
		
		
		

		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new TwoDimensionalArratTest());
	}

}
