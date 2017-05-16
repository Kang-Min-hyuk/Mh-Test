package parser.test.com;

public class MovieDTO {

	String movieCd;
	String movieNm;
	String repNationNm;
	
	
	public MovieDTO() {
	
	}
	public MovieDTO(String movieCd, String movieNm, String repNationNm) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.repNationNm = repNationNm;
	}
	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getrepNationNm() {
		return repNationNm;
	}
	public void setrepNationNm(String repNationNm) {
		this.repNationNm = repNationNm;
	}
	

}
