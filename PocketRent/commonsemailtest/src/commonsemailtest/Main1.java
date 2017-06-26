package commonsemailtest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Main1 {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		HtmlEmail email = new HtmlEmail(); //发送html格式邮件
		email.setHostName("smtp.163.com");//SMTP服务器
		email.setCharset("UTF-8");
		//登陆邮件服务器的用户名和密码
		email.setAuthentication("rupengtest01@163.com", "123rupeng");
		email.addTo("18767920515@163.com");
		email.setFrom("rupengtest01@163.com");
		email.setSubject("test");
		email.setMsg("hello<a href='http://www.baidu.com'>点击查看百度</a>");
		email.send();
	}

}
