package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserXMLHandler extends DefaultHandler{
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("读取到"+qName+"的开始标签");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("读取到一段文本内容："+new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("读取到"+qName+"的结束标签");
	}
}
