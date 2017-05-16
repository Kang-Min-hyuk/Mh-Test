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

// �Ľ� : �����͸� �о���̸鼭 � ���������� �ؼ��Ͽ� ó���ϴ� ����.

// �ڹٿ��� ��밡���� XML�ļ� 2����
// - DOM  (Document Object Model) parser
//		: xml ���� ��ü�� �о���� �� ������ �±������� ����ϴ� ���.		  

// - SAX  (Simple API XML) parser
//		: �о���� �±������� ������ �ʿ��� ��ŭ �κ������� ó���Ҽ� �ִ� ���.
//        �̺�Ʈ ó�� ���
// DOM �ļ��� �Ľ�(Parsing)
public class DOMParser {

	public static void main(String[] args) {

		String strUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.xml?key=430156241533f1d058c603178cc3ca0e";

		try {
			URL url = new URL(strUrl);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			InputStream is = con.getInputStream();

			// DOM �ļ��� �Ľ�
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

			is.close(); // �Է½�Ʈ�� �ڿ� �ݱ�
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

}
