package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(SAXTest.class.getResource("users.xml").getFile());
		UserXMLHandler userXMLHandler = new UserXMLHandler();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(xmlFile, userXMLHandler);
	}
}
