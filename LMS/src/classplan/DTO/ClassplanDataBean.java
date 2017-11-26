package classplan.DTO;

public class ClassplanDataBean {
	private int cp_num;//강의계획
	private String cp_year;//개설년도
	private String cp_semester;//개설학기
	private String s_cp_division;//이수구분
	private int s_cp_credits;//이수학점
	private String s_num;//과목번호
	private String s_name;//과목이름
	private String pf_name;//교수이름
	private String cp_time;//강의시간/요일
	private int cp_max_no;//강의 최대인원
	private int cp_current_no;//강의 현재인원
	private String cr_num;//강의실 번호
	private String registration;//승인여부 / 등록여부
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
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
	public String getPf_name() {
		return pf_name;
	}
	public void setPf_name(String pf_name) {
		this.pf_name = pf_name;
	}
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
	public String getCr_num() {
		return cr_num;
	}
	public void setCr_num(String cr_num) {
		this.cr_num = cr_num;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	
}
