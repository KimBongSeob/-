package student.DTO;
import java.sql.Timestamp;
public class ReinstatementDataBean {
	private int sd_num;//학번
	private Timestamp re_loa_date;// 휴학신청 날짜
	private String loa_end_year;//-----휴학만료년도 
	private String loa_end_semester;//----휴학만료학기 -- 1,2
	private Timestamp loa_a_date; //----휴학신청승인날짜
	private Timestamp re_start_date;//복학신청 날짜
	private Timestamp re_end_date;//---복학신청승인날짜
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public Timestamp getRe_loa_date() {
		return re_loa_date;
	}
	public void setRe_loa_date(Timestamp re_loa_date) {
		this.re_loa_date = re_loa_date;
	}
	public String getLoa_end_year() {
		return loa_end_year;
	}
	public void setLoa_end_year(String loa_end_year) {
		this.loa_end_year = loa_end_year;
	}
	public String getLoa_end_semester() {
		return loa_end_semester;
	}
	public void setLoa_end_semester(String loa_end_semester) {
		this.loa_end_semester = loa_end_semester;
	}
	public Timestamp getLoa_a_date() {
		return loa_a_date;
	}
	public void setLoa_a_date(Timestamp loa_a_date) {
		this.loa_a_date = loa_a_date;
	}
	public Timestamp getRe_start_date() {
		return re_start_date;
	}
	public void setRe_start_date(Timestamp re_start_date) {
		this.re_start_date = re_start_date;
	}
	public Timestamp getRe_end_date() {
		return re_end_date;
	}
	public void setRe_end_date(Timestamp re_end_date) {
		this.re_end_date = re_end_date;
	}

}
