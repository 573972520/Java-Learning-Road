import com.rupeng.game.GameCore;

public class Time implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		int timeNum = 0;
		GameCore.createText(timeNum, ":");
		GameCore.setTextPosition(timeNum, 100, 100);
		for (int hour = 0; hour < 60; hour++) {
			for (int min = 0; min < 60; min++) {
				for (int send = 0; send < 60; send++) {
					String time = hour+":"+min+":"+send;
					GameCore.setText(timeNum, time);
					GameCore.pause(50);
				}
			}
		}
		
		
		GameCore.pause(2000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Time());
	}
	
}
