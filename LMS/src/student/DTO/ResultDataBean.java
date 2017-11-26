package student.DTO;

public class ResultDataBean {
	
	private int cp_num;//강의계획
	private String cp_year;//개설년도
	private String cp_semester;//개설학기
	private String s_cp_division;//이수구분
	private int s_cp_credits;//이수학점
	private String pf_name;//교수이름
	private String s_name;//과목이름
	private String s_num;
	private String g_sum;//성적
	
	
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
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
	public String getPf_name() {
		return pf_name;
	}
	public void setPf_name(String pf_name) {
		this.pf_name = pf_name;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getG_sum() {
		return g_sum;
	}
	public void setG_sum(String g_sum) {
		this.g_sum = g_sum;
	}

}
