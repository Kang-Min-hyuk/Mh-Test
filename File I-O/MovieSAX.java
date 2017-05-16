package parser.test.com;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;



public class MovieSAX {

	public static void main(String[] args) {
		
		String strurl="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml?key=430156241533f1d058c603178cc3ca0e";
		List<MovieDTO> list = null;
		try {
			URL url = new URL(strurl);
			InputStream is = url.openStream();
			InputSource source = new InputSource(is);
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser ps = factory.newSAXParser();
			XMLReader reader = ps.getXMLReader();
			
			ActHandler handler = new ActHandler();
		
			reader.setContentHandler(handler);
			reader.parse(source);
			
			list = handler.getList();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(MovieDTO dto: list){
			System.out.println(dto.movieCd+ ", " + dto.movieNm + ", " + dto.repNationNm);
		}
	}

}


class ActHandler extends DefaultHandler{
		
	String value;
	MovieDTO dto;
	List<MovieDTO> list = new ArrayList<MovieDTO>();
	
	public List<MovieDTO> getList() {
		return list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			
			if(qName.equals("movie")){
				dto = new MovieDTO();
				
			}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		value = new String(ch,start,length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("movieCd")){
			dto.setMovieCd(value);
		} else if(qName.equals("movieNm")){
			dto.setMovieNm(value);
		} else if(qName.equals("repNationNm")){
			dto.setrepNationNm(value);
		} else if(qName.equals("movie")){
			list.add(dto);
		}
	
		value = "";
		
	}

}