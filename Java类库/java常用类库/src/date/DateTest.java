package date;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		System.out.println(now);
		
		int year = now.getYear();//���Ƽ�ʹ��
		System.out.println(year);
		int hour = now.getHours();
		System.out.println(hour);
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(now);
		int year1 = c1.get(Calendar.YEAR);
		System.out.println(year1);
		int minute = c1.get(Calendar.MINUTE);
		System.out.println(minute);
		}

}
