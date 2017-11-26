package classrequest.DTO;

public class ClassrequestDataBean {
	private int no;
	private int cr_num;//수강신청번호
	private int cp_num;//강의 계획 번호
	private int sd_num;// 학번
	private String g_sum;//성적
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCr_num() {
		return cr_num;
	}
	public void setCr_num(int cr_num) {
		this.cr_num = cr_num;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public String getG_sum() {
		return g_sum;
	}
	public void setG_sum(String g_sum) {
		this.g_sum = g_sum;
	}
	
	
}
