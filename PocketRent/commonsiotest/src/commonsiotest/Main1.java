package commonsiotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.zip.InflaterOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class Main1 {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		String s = "d:aa/bbb/ccc.txt";
		System.out.println("文件名:"+FilenameUtils.getName(s));
		System.out.println("路径:"+FilenameUtils.getFullPath(s));
		System.out.println("后缀:"+FilenameUtils.getExtension(s));
		System.out.println("纯文件名:"+FilenameUtils.getBaseName(s));
	}
	
	public static void main(String[] args) throws IOException {
		File srcDir = new File("D:\\Document\\如鹏课程\\如鹏课程文件\\掌上租\\apachecommons\\commons");
		File destDir = new File("D:\\Document\\如鹏课程\\如鹏课程文件\\掌上租\\代码测试");
		//FileUtils.copyDirectory(srcDir, destDir);
		//FileUtils.cleanDirectory(destDir);
		//FileUtils.deleteDirectory(destDir);
		
		//String s = FileUtils.readFileToString(new File("D:\\Document\\如鹏课程\\如鹏课程文件\\掌上租\\test.txt"), "UTF-8");
		//System.out.println(s);
		List<String> list = FileUtils.readLines(new File("D:\\Document\\如鹏课程\\如鹏课程文件\\掌上租\\test.txt"),"UTF-8"); 
		for(int i = 0;i<list.size();i++)
		{
			System.out.println(i+"---"+list.get(i));
		}
		
		
		URL url = new URL("http://www.rupeng.com");
		//使用之前的方法（复杂麻烦）
		InputStream inStream = url.openStream();
		InputStreamReader inReader = new InputStreamReader(inStream);
		BufferedReader buffReader = new BufferedReader(inReader);
		String line;
		while((line=buffReader.readLine()) != null)
		{
			System.out.println(line);
		}
		buffReader.close();
		inReader.close();
		inStream.close();
		
		//使用IOUtils的toString方法（方便简单）
		
//		String html = IOUtils.toString(url, "UTF-8");
//		System.out.println(html);
			
	}

}
