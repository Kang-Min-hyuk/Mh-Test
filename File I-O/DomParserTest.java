package parser.test.com;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DomParserTest {

	public static void main(String[] args) {
		String strUrl = "http://rss.donga.com/culture.xml";
		
		try {
			URL url = new URL(strUrl);
			InputStream is = url.openStream();
			InputSource inputSource = new InputSource(is);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputSource);
			
			NodeList itemList = document.getElementsByTagName("item");
			
			for (int i=0; i<itemList.getLength(); i++) {
				// i��° ���ڵ�(��)
				Element itemEle = (Element) itemList.item(i);
				// i��° title Į��(��)
				NodeList titleList = itemEle.getElementsByTagName("title");
				Element titleEle = (Element) titleList.item(0);
				String title = getCharacterDataFromElement(titleEle);
				// i��° link Į��(��)
				NodeList linkList = itemEle.getElementsByTagName("link");
				Element linkEle = (Element) linkList.item(0);
				String link = getCharacterDataFromElement(linkEle);
				// i��° pubDate Į��(��)
				NodeList pubDateList = itemEle.getElementsByTagName("pubDate");
				Element pubDateEle = (Element) pubDateList.item(0);
				String targetStrDate = pubDateEle.getFirstChild().getNodeValue();
				
				// ��¥���� ���ڿ��� �ؼ��ϴ� ��� ����
				SimpleDateFormat dateParser = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
				Date date = dateParser.parse(targetStrDate);
				// �ѱ� ǥ�������� ��¥ ���ڿ� ��ȯ
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
				String strDate = sdf.format(date);
				
				
				// i��° media:content Į��(��)
				NodeList mediaList = itemEle.getElementsByTagName("media:content");
				String strImg = "";
				if (mediaList.getLength() > 0) {
					Element mediaEle = (Element) mediaList.item(0);
					strImg = mediaEle.getAttribute("url");
				}
				
				System.out.println(strDate + ", " + title + ", " + link + ", " + strImg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
	
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	}

} // DomParserTest








