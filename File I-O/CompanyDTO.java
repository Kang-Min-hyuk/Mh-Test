package parser.test.com;

public class CompanyDTO {

	private String comCd;
	private String comNm;
	private String filmNm;
	
	
	
	public CompanyDTO(String comCd, String comNm, String filmNm) {
		super();
		this.comCd = comCd;
		this.comNm = comNm;
		this.filmNm = filmNm;
	}
	public String getComCd() {
		return comCd;
	}
	public void setComCd(String comCd) {
		this.comCd = comCd;
	}
	public String getComNm() {
		return comNm;
	}
	public void setComNm(String comNm) {
		this.comNm = comNm;
	}
	public String getFilmNm() {
		return filmNm;
	}
	public void setFilmNm(String filmNm) {
		this.filmNm = filmNm;
	}
	

}
