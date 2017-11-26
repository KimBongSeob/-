package admin.DTO;
import java.sql.Date;
import java.sql.Timestamp;
public class ReinstatementDataBean {
	private int sd_num;//학번
	private Date re_loa_date;// 휴학신청 날짜
	private String loa_end_year;//-----휴학만료년도 
	private String loa_end_semester;//----휴학만료학기 -- 1,2
	private Date loa_a_date; //----휴학신청승인날짜
	private Date re_start_date;//복학신청 날짜
	private Date re_end_date;//---복학신청승인날짜
	private String d_name;
	private String sd_name;
	
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getSd_name() {
		return sd_name;
	}
	public void setSd_name(String sd_name) {
		this.sd_name = sd_name;
	}
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
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
	public Date getRe_loa_date() {
		return re_loa_date;
	}
	public void setRe_loa_date(Date re_loa_date) {
		this.re_loa_date = re_loa_date;
	}
	public Date getLoa_a_date() {
		return loa_a_date;
	}
	public void setLoa_a_date(Date loa_a_date) {
		this.loa_a_date = loa_a_date;
	}
	public Date getRe_start_date() {
		return re_start_date;
	}
	public void setRe_start_date(Date re_start_date) {
		this.re_start_date = re_start_date;
	}
	public Date getRe_end_date() {
		return re_end_date;
	}
	public void setRe_end_date(Date re_end_date) {
		this.re_end_date = re_end_date;
	}


}
