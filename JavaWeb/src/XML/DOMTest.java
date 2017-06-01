package XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//把users.xml文件中的数据封装到List<User>对象里面
		
		//1 获取document对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();
		String path = DOMTest.class.getResource("users.xml").getFile();
		Document document = documentBuilder.parse(path);
		List<User> userList = new ArrayList<User>();
		
		//2 获取想要操作的元素
		NodeList userNodeList =document.getElementsByTagName("user");
		for(int i = 0;i<userNodeList.getLength();i++)
		{
			User user = new User();
			Element userElement = (Element)userNodeList.item(i);
			String name =userElement.getAttribute("name");
			user.setName(name);
			String id = userElement.getAttribute("id");
			user.setId(id);
			//拿到email子元素
			NodeList emailNodeList = userElement.getElementsByTagName("email");
			for (int j = 0; j < emailNodeList.getLength(); j++) {
				Element emailElement = (Element)emailNodeList.item(j);
				String email = emailElement.getTextContent();
				user.setEmail(email);
			}
			//拿到phone子孙元素对象
			List<String> phones = new ArrayList<String>();
			NodeList phoneNodeList = userElement.getElementsByTagName("phone");
			for (int j = 0; j < phoneNodeList.getLength(); j++) {
				Element phoneElement = (Element)phoneNodeList.item(j);
				String phone = phoneElement.getTextContent();
				phones.add(phone);
			}
			user.setPhones(phones);
			
			userList.add(user);
		}
		System.out.println(userList);
	}
}
