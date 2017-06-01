package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserXMLHandler extends DefaultHandler{
	private User user;
	private String content; //临时记录一个标签的文本内容
	
	public User getUser() {
		return user;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("读取到"+qName+"的开始标签");
		if("user".equals(qName))
		{
			user = new User();
			String id = attributes.getValue("id");
			String name = attributes.getValue("name");
			user.setId(id);
			user.setName(name);
		}
		else if("email".equals(qName))
		{
			
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println("读取到一段文本内容："+newInstance String(ch,start,length));
		content = new String(ch,start,length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("读取到"+qName+"的结束标签");
		if("email".equals(qName))
		{
			user.setEmail(content);
		}else if("phone".equals(qName))
		{
			user.setPhone(content);
		}
	}
}
