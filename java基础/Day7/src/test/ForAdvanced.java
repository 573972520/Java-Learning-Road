package test;


import com.rupeng.game.GameCore;

public class ForAdvanced implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		int x = 5;
//		for(;;){ //ÎÞÏÞÑ­»·
//			System.out.println(x);
//			GameCore.pause(100);
//		}
		
		int i = 0;
		for (; i <= 3; i++) {
			System.out.println(i);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new ForAdvanced());
	}

}
