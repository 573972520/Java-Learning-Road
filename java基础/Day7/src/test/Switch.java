package test;

import com.rupeng.game.GameCore;

public class Switch implements Runnable {

	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		/*
		int i = 1;
		switch (i) { //这里的i为表达式，表达式的类型可以是byte、short、int、char、JDK5之后还可以是枚举类型，JDK7之后还可以是string
		case 6:
			System.out.println("F");
			break; //  case最后必须写一个break
			
		case 2:
			System.out.println("E");
			break;
			
		default:
			System.out.println("Error");
			break;
		}
		*/
	
		int i = 5;
		switch (i) {
		case 3:
		case 4:
		case 5:
			System.out.println("春天");
			break;    //当没有写break，那么代码会一直执行到所有的case之后，或者遇到第一个break
					 //break代表“后面的case不做判断了”
		case 6:
		case 7:
		case 8:
			System.out.println("夏天");
			break;
			
		case 10:
		case 9:
		case 11:
			System.out.println("秋天");
			break;
			
		case 12:
		case 1:
		case 2:
			System.out.println("春天");
			break;
			
		default:
			System.out.println("Error");
			break;
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Switch());
	}

}
