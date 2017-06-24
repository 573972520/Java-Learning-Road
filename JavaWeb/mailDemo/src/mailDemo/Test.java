package mailDemo;


import java.awt.Transparency;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Test {

	public static void main(String[] args) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.sina.com"); //smtp服务器地址
		props.setProperty("mail.smtp.auth", "true"); //指定连接时需要验证用户信息
		
		//1、创建Session对象
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//指定邮箱用户名和密码，注意用户名不带@xx.xx
				return new PasswordAuthentication("xhs19960426","7775407540");
			}	
			
		});
		
		
		
		//2、创建和编写邮件
		Message message = new MimeMessage(session);
		//设置发件人
		message.setFrom(new InternetAddress("xhs19960426@sina.com"));
		//设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress("18767920515@163.com"));
		//设置标题
		message.setSubject("test");
		//设置邮件内容
		message.setText("hello");
		
		
		//3、发送邮件
		Transport.send(message);
		
	}

}
