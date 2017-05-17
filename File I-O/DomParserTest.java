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
				// i번째 레코드(행)
				Element itemEle = (Element) itemList.item(i);
				// i번째 title 칼럼(열)
				NodeList titleList = itemEle.getElementsByTagName("title");
				Element titleEle = (Element) titleList.item(0);
				String title = getCharacterDataFromElement(titleEle);
				// i번째 link 칼럼(열)
				NodeList linkList = itemEle.getElementsByTagName("link");
				Element linkEle = (Element) linkList.item(0);
				String link = getCharacterDataFromElement(linkEle);
				// i번째 pubDate 칼럼(열)
				NodeList pubDateList = itemEle.getElementsByTagName("pubDate");
				Element pubDateEle = (Element) pubDateList.item(0);
				String targetStrDate = pubDateEle.getFirstChild().getNodeValue();
				
				// 날짜정보 문자열을 해석하는 방법 제공
				SimpleDateFormat dateParser = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
				Date date = dateParser.parse(targetStrDate);
				// 한국 표현식으로 날짜 문자열 변환
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				String strDate = sdf.format(date);
				
				
				// i번째 media:content 칼럼(열)
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








