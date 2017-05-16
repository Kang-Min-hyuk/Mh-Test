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

// 파싱 : 데이터를 읽어들이면서 어떤 데이터인지 해석하여 처리하는 과정.

// 자바에서 사용가능한 XML파서 2종류
// - DOM  (Document Object Model) parser
//		: xml 문서 전체를 읽어들인 후 각각의 태그정보를 사용하는 방식.		  

// - SAX  (Simple API XML) parser
//		: 읽어들인 태그정보가 있으면 필요한 만큼 부분적으로 처리할수 있는 방식.
//        이벤트 처리 방식
// DOM 파서로 파싱(Parsing)
public class DOMParser {

	public static void main(String[] args) {

		String strUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.xml?key=430156241533f1d058c603178cc3ca0e";

		try {
			URL url = new URL(strUrl);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			InputStream is = con.getInputStream();

			// DOM 파서로 파싱
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);

			NodeList companyList = document.getElementsByTagName("company");
			NodeList companyCdList = document.getElementsByTagName("companyCd");
			NodeList companyNmList = document.getElementsByTagName("companyNm");
			NodeList filmoNamesList = document.getElementsByTagName("filmoNames");
			
			List <CompanyDTO>list = new ArrayList<CompanyDTO>();
			CompanyDTO dto = null;

			for (int i = 0; i < companyList.getLength(); i++) {
				String companyCd = companyCdList.item(i).getFirstChild().getNodeValue();
				String companyNm = companyNmList.item(i).getFirstChild().getNodeValue();

				String filmoNames = "";
				Node filmoNamesNode = filmoNamesList.item(i).getFirstChild();
				if (filmoNamesNode != null) {
					filmoNames = filmoNamesNode.getNodeValue();
				}
				dto = new CompanyDTO(companyCd, companyNm, filmoNames);
				list.add(dto);

				System.out.println(companyCd + ", " + companyNm + ", " + filmoNames);
			}

			is.close(); // 입력스트림 자원 닫기
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

}
