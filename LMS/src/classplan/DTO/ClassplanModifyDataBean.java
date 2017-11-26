package classplan.DTO;

import java.sql.Date;

public class ClassplanModifyDataBean {
	private int cp_num ;// 강의계획번호
	private Date cp_date; //작성일자
	private String cp_year; //개설년도
	private String cp_semester; //개설학기
	private String s_name; //과목이름
	private String s_num; //과목번호
	private int s_cp_credits;//이수학점
	private String cp_time;// 강의시간/요일
	private String d_num;// 과번호
	private String d_name;// 과이름
	private String cr_num;//강의실 번호
	private String pf_num;//교수 번호
	private String pf_name;//교수이름
	private String pf_email;//교수 이메일
	private String s_cp_division;//과목 이수구분
	private int cp_max_no;// 강의 최대인원
	private String cp_outline;//강의개요
	private String cp_textbook;//교재
	private String cp_sub_textbook;//부교재
	private String cp_valuation;// 평가방법
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
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
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public int getS_cp_credits() {
		return s_cp_credits;
	}
	public void setS_cp_credits(int s_cp_credits) {
		this.s_cp_credits = s_cp_credits;
	}
	public String getCp_time() {
		return cp_time;
	}
	public void setCp_time(String cp_time) {
		this.cp_time = cp_time;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getCr_num() {
		return cr_num;
	}
	public void setCr_num(String cr_num) {
		this.cr_num = cr_num;
	}
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
	public String getPf_email() {
		return pf_email;
	}
	public void setPf_email(String pf_email) {
		this.pf_email = pf_email;
	}
	public String getS_cp_division() {
		return s_cp_division;
	}
	public void setS_cp_division(String s_cp_division) {
		this.s_cp_division = s_cp_division;
	}
	public int getCp_max_no() {
		return cp_max_no;
	}
	public void setCp_max_no(int cp_max_no) {
		this.cp_max_no = cp_max_no;
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
	
}
