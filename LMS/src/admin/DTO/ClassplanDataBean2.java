package admin.DTO;

import java.util.Date;

public class ClassplanDataBean2 {
	
	//private int no;
	private int cp_num;
	//private String s_num;
	private String cr_num;
	//private String pf_num;
	private String cp_time;
	private int cp_max_no;
	private int cp_current_no;
	private String cp_outline;
	private String cp_textbook;
	private String cp_sub_textbook;
	private String cp_valuation;
	private String cp_schedule;
	private Date cp_date;
	private String cp_year;
	private String cp_semester;
	private String registration;
	
	/*public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}*/
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	/*public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}*/
	public String getCr_num() {
		return cr_num;
	}
	public void setCr_num(String cr_num) {
		this.cr_num = cr_num;
	}
	/*public String getPf_num() {
		return pf_num;
	}
	public void setPf_num(String pf_num) {
		this.pf_num = pf_num;
	}*/
	public String getCp_time() {
		return cp_time;
	}
	public void setCp_time(String cp_time) {
		this.cp_time = cp_time;
	}
	public int getCp_max_no() {
		return cp_max_no;
	}
	public void setCp_max_no(int cp_max_no) {
		this.cp_max_no = cp_max_no;
	}
	public int getCp_current_no() {
		return cp_current_no;
	}
	public void setCp_current_no(int cp_current_no) {
		this.cp_current_no = cp_current_no;
	}
	public String getCp_outline() {
		return cp_outline;
	}
	public void setCp_outline(String cp_outline) {
		this.cp_outline = cp_outline;
	}
	public String getCp_textbook() {
		return cp_textbook;
	}
	public void setCp_textbook(String cp_textbook) {
		this.cp_textbook = cp_textbook;
	}
	public String getCp_sub_textbook() {
		return cp_sub_textbook;
	}
	public void setCp_sub_textbook(String cp_sub_textbook) {
		this.cp_sub_textbook = cp_sub_textbook;
	}
	public String getCp_valuation() {
		return cp_valuation;
	}
	public void setCp_valuation(String cp_valuation) {
		this.cp_valuation = cp_valuation;
	}
	public String getCp_schedule() {
		return cp_schedule;
	}
	public void setCp_schedule(String cp_schedule) {
		this.cp_schedule = cp_schedule;
	}
	public Date getCp_date() {
		return cp_date;
	}
	public void setCp_date(Date cp_date) {
		this.cp_date = cp_date;
	}
	public String getCp_year() {
		return cp_year;
	}
	public void setCp_year(String cp_year) {
		this.cp_year = cp_year;
	}
	public String getCp_semester() {
		return cp_semester;
	}
	public void setCp_semester(String cp_semester) {
		this.cp_semester = cp_semester;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	
	//
	
	//private int no;//
	private String pf_num;//교번
	private String pf_name;//교수이름
	private String pf_passwd;//교수 pw
	//private String d_num;//학과번호
	private String pf_jumin;//교수 생일월일
	private String pf_hpone;//교수 핸드폰 번호
	private String pf_address;//교수 주소
	private String pf_email;//교수 이메일
	private String pf_ac_no;//교수 계좌번호
	private String pf_ac_name;//계좌은행이름
	/*public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}*/
	public String getPf_num() {
		return pf_num;
	}
	public void setPf_num(String pf_num) {
		this.pf_num = pf_num;
	}
	public String getPf_name() {
		return pf_name;
	}
	public void setPf_name(String pf_name) {
		this.pf_name = pf_name;
	}
	public String getPf_passwd() {
		return pf_passwd;
	}
	public void setPf_passwd(String pf_passwd) {
		this.pf_passwd = pf_passwd;
	}
	/*public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}*/
	public String getPf_jumin() {
		return pf_jumin;
	}
	public void setPf_jumin(String pf_jumin) {
		this.pf_jumin = pf_jumin;
	}
	public String getPf_hpone() {
		return pf_hpone;
	}
	public void setPf_hpone(String pf_hpone) {
		this.pf_hpone = pf_hpone;
	}
	public String getPf_address() {
		return pf_address;
	}
	public void setPf_address(String pf_address) {
		this.pf_address = pf_address;
	}
	public String getPf_email() {
		return pf_email;
	}
	public void setPf_email(String pf_email) {
		this.pf_email = pf_email;
	}
	public String getPf_ac_no() {
		return pf_ac_no;
	}
	public void setPf_ac_no(String pf_ac_no) {
		this.pf_ac_no = pf_ac_no;
	}
	public String getPf_ac_name() {
		return pf_ac_name;
	}
	public void setPf_ac_name(String pf_ac_name) {
		this.pf_ac_name = pf_ac_name;
	}
	
	//
	
	private int no;//
	private String s_num;//--과목번호(학수번호)
	private String s_name;//--교과목명
	private String s_cp_division;//--이수구분
	private int s_cp_credits;//--이수학점
	private String d_num;//학과번호
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_cp_division() {
		return s_cp_division;
	}
	public void setS_cp_division(String s_cp_division) {
		this.s_cp_division = s_cp_division;
	}
	public int getS_cp_credits() {
		return s_cp_credits;
	}
	public void setS_cp_credits(int s_cp_credits) {
		this.s_cp_credits = s_cp_credits;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	
}
