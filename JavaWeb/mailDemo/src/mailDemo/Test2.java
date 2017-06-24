package mailDemo;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

import javax.activation.URLDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class Test2 {

	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.sina.com"); //smtp服务器地址
		props.setProperty("mail.smtp.auth", "true"); //指定连接时需要验证用户信息
		System.setProperty("mail.mime.encodefilename", "true");
		
		
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
		message.setSubject("测试邮件");
		//设置邮件内容
		imageMessage(message);
		
		//3、发送邮件
		Transport.send(message);
	}

	
	public static void htmlMessage(Message message) throws MessagingException
	{
		//把邮件体的内容设置为HTML格式的文本
		
		//创建资源对象
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText("<h1>hello JavaMail</h1><br />你好JavaMail!", "UTF-8", "html");
		
		
		//包裹资源对象
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		
		//把数据放入邮件体里面
		
		message.setContent(multipart);
	}
	
	
	public static void attachmentMessage(Message message) throws MessagingException, IOException
	{
		//把邮件体的内容设置为包含附件的内容
		
		//创建资源对象
		String file = Test2.class.getResource("/颜色资料.zip").getFile();
		System.out.println(file);
		file = URLDecoder.decode(file,"UTF-8"); //解码
		System.out.println(file);
		
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.attachFile(file);
		
		//包裹资源对象
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		
		//把数据放入邮件体里面
		
		message.setContent(multipart);
	}
	
	public static void imageMessage(Message message) throws MessagingException, IOException
	{
		//把邮件体的内容设置为HTML格式的文本
		
		//创建资源对象
		MimeBodyPart bodyPart = new MimeBodyPart();
		//bodyPart.setText("<h1>hello JavaMail</h1><br />你好JavaMail!<br /><img src='http://www.rupeng.com/imgs/new/logo.png' />", "UTF-8", "html");
		bodyPart.setText("<h1>hello JavaMail</h1><br />你好JavaMail!<br /><img src='cid:mail01' />", "UTF-8", "html");
		
		
		//创建图片附件资源
		String file = Test2.class.getResource("/mail.jpg").getFile();
		file = URLDecoder.decode(file,"UTF-8");
		MimeBodyPart bodyPart2 = new MimeBodyPart();
		bodyPart2.attachFile(file);
		bodyPart2.setDisposition(MimeBodyPart.INLINE);
		bodyPart2.setContentID("mail01");
		
		
		//包裹资源对象
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		multipart.addBodyPart(bodyPart2);
		
		//把数据放入邮件体里面
		
		message.setContent(multipart);
	}
	
	
	
}
