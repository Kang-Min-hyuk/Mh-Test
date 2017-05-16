package parser.test.com;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DOMMovie {

	public static void main(String[] args) {
		
		String strUrl ="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml?key=430156241533f1d058c603178cc3ca0e";

		try {
			URL url = new URL(strUrl);
			
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			InputStream is = huc.getInputStream();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			
			NodeList movielist = document.getElementsByTagName("movie");
			NodeList movieCdlist = document.getElementsByTagName("movieCd");
			NodeList movieNmlist = document.getElementsByTagName("movieNm");
			NodeList repNationNmlist = document.getElementsByTagName("repNationNm");
			
			List<MovieDTO> list = new ArrayList<MovieDTO>();
			
			MovieDTO dto = null;
			
			for(int i=0; i<movielist.getLength(); i++){
				String movieCd = movieCdlist.item(i).getFirstChild().getNodeValue();
				String movieNm = movieNmlist.item(i).getFirstChild().getNodeValue();
				
				String repNationNm="";
				Node repNationNmNode = repNationNmlist.item(i).getFirstChild(); 
				if(repNationNmNode != null){
					repNationNm = repNationNmNode.getNodeValue();
				}
				dto = new MovieDTO(movieCd, movieNm, repNationNm);
				list.add(dto);
				
				System.out.println(movieCd+", "+movieNm + ", " + repNationNm);
			}
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
