package mailDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//使用简陋的URLConnection发送HTTP请求（post请求）
		//使用HTTPClient工具包发送HTTP请求会更好一点
		
		//先把请求参数放入map，方便后续的URL编码、拼接等操作
		Map<String,String> map = new HashMap<String,String>();
		map.put("api_user", "573972520_test_fkwI6M");
		map.put("api_key", "3lmViUZYYf0YCwWL");
		map.put("from", "18767920515@163.com");
		map.put("template_invoke_name", "test_template");
		map.put("substitution_vars", "{\"to\":[\"573972520@qq.com\"],\"sub\":{\"%name%\":[\"蛋蛋\"]}}");
		
		//
		StringBuffer params = new StringBuffer();
		Set<Entry<String,String>> entrySet = map.entrySet();
		for(Entry<String,String> entry : entrySet)
		{
			//给请求参数的key和value进行URL编码
			String key = URLEncoder.encode(entry.getKey(), "UTF-8");
			String value = URLEncoder.encode(entry.getValue(), "UTF-8");
			//编码之后使用=、&进行拼接
			params.append(key).append("=").append(value).append("&");
		}
		
		//删除最后多余的&
		params.deleteCharAt(params.length() - 1);
		
		URL url = new URL("http://www.sendcloud.net/webapi/mail.send_template.json");
		URLConnection connection = url.openConnection();//打开连接
		connection.setDoOutput(true);//设置输出流可用，即发生post方式请求需要使用输出流
		OutputStream ouput = connection.getOutputStream();
		
		//把请求参数发生给sendCloud服务器，服务器收到请求之后，会向指定的收件人发生模板邮件
		ouput.write(params.toString().getBytes());

		
		//读取响应信息
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		StringBuffer result = new StringBuffer();
		while((line = reader.readLine()) != null)
		{
			result.append(line);
		}
		System.out.println(result);
		
		ouput.close();
		reader.close();
		
	}

}
