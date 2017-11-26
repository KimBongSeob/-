package professor.DTO;

import java.sql.Date;

public class ProfessorDataBean {
	private int no;//
	private String pf_num;//교번
	private String pf_name;//교수이름
	private String pf_passwd;//교수 pw
	private String d_num;//학과번호
	private Date pf_jumin;//교수 생일월일
	private String pf_hpone;//교수 핸드폰 번호
	private String pf_address;//교수 주소
	private String pf_email;//교수 이메일
	private String pf_ac_no;//교수 계좌번호
	private String pf_ac_name;//계좌은행이름
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getPf_passwd() {
		return pf_passwd;
	}
	public void setPf_passwd(String pf_passwd) {
		this.pf_passwd = pf_passwd;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	
	public Date getPf_jumin() {
		return pf_jumin;
	}
	public void setPf_jumin(Date pf_jumin) {
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
	
}
