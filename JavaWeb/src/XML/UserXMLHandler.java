package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserXMLHandler extends DefaultHandler{
	private User user;
	private String content; //��ʱ��¼һ����ǩ���ı�����
	
	public User getUser() {
		return user;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("��ȡ��"+qName+"�Ŀ�ʼ��ǩ");
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
		//System.out.println("��ȡ��һ���ı����ݣ�"+newInstance String(ch,start,length));
		content = new String(ch,start,length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("��ȡ��"+qName+"�Ľ�����ǩ");
		if("email".equals(qName))
		{
			user.setEmail(content);
		}else if("phone".equals(qName))
		{
			user.setPhone(content);
		}
	}
}
