package date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
				//new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		String s = sdf.format(now);
		System.out.println(s);
		
		try {
			Date d2 = sdf.parse("2019-9-8");
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
