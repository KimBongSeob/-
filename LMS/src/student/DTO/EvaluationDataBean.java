package student.DTO;

public class EvaluationDataBean {
	
    private String s_name; // 교과목명
    private String pf_name; // 교수이름
    private String s_num; // 과목번호
    private String cp_time; // 강의시간
    private int cr_num; // 수강신청 번호
	
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
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getCp_time() {
		return cp_time;
	}
	public void setCp_time(String cp_time) {
		this.cp_time = cp_time;
	}
	public int getCr_num() {
		return cr_num;
	}
	public void setCr_num(int cr_num) {
		this.cr_num = cr_num;
	}

	
}
