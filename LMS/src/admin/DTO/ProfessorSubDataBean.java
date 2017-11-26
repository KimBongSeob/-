package admin.DTO;
import java.sql.Date;
public class ProfessorSubDataBean {
	private String pf_name;//교수이름
	private String pf_num;//교수번호
	private String d_name;//학과이름
	private String d_num;//학과번호
	private String pf_email;//email
	private Date pf_jumin;
	private int pf_status;
	

	public Date getPf_jumin() {
		return pf_jumin;
	}
	public void setPf_jumin(Date pf_jumin) {
		this.pf_jumin = pf_jumin;
	}
	public int getPf_status() {
		return pf_status;
	}
	public void setPf_status(int pf_status) {
		this.pf_status = pf_status;
	}
	public String getPf_name() {
		return pf_name;
	}
	public void setPf_name(String pf_name) {
		this.pf_name = pf_name;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getPf_num() {
		return pf_num;
	}
	public void setPf_num(String pf_num) {
		this.pf_num = pf_num;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public String getPf_email() {
		return pf_email;
	}
	public void setPf_email(String pf_email) {
		this.pf_email = pf_email;
	}
	
	

}
