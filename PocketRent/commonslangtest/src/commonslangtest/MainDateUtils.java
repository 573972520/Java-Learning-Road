package commonslangtest;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.xml.crypto.Data;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;

public class MainDateUtils {

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		/*
		Date date = new Date();
		System.out.println(date);
		Date d1 = DateUtils.addDays(date, -3);
		Date d2 = DateUtils.addHours(date, 3);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(DateUtils.isSameDay(date, d1));
		
		Date d3 = DateUtils.parseDate("2008-9-8", "yyyy-MM-dd");
		System.out.println(d3);
		*/
		
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		for(int i = 0;i<10;i++)
		{
			FileUtils.readLines(new File("F:\\Programming\\Notes\\JAVA.xmind"));
		}
		
		sw.stop();
		System.out.println(sw.getTime());
		
		
	}

}
