package admin.DTO;

import java.sql.Date;

public class SubspecialtyDataBean {
	//select student.d_num, d.d_name, student.sd_num, student.sd_name, SUBSPECIALTY.d_sub_num, d_sub.d_name, SUBSPECIALTY.m_date
	private int sp_no;// 부/복수전공 신청번호
	private int sd_num;//---학번
	private String sd_name;// 학생 이름
	private String d_num;//--학과번호
	private String d_name;//학과 이름
	private String d_sub_num;//--부/복수 전공번호
	private String d_sub_name;
	private Date dm_date;//--복수전공신청날짜
	private Date m_date;//--부 전공 신청날짜
	private Date a_date;//--복수전공승인날짜
	private Date ma_date;//--부전공승인날짜
	
	
	
	public int getSp_no() {
		return sp_no;
	}
	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
	}
	public String getSd_name() {
		return sd_name;
	}
	public void setSd_name(String sd_name) {
		this.sd_name = sd_name;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_sub_name() {
		return d_sub_name;
	}
	public void setD_sub_name(String d_sub_name) {
		this.d_sub_name = d_sub_name;
	}
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public String getD_sub_num() {
		return d_sub_num;
	}
	public void setD_sub_num(String d_sub_num) {
		this.d_sub_num = d_sub_num;
	}
	public Date getDm_date() {
		return dm_date;
	}
	public void setDm_date(Date dm_date) {
		this.dm_date = dm_date;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public Date getMa_date() {
		return ma_date;
	}
	public void setMa_date(Date ma_date) {
		this.ma_date = ma_date;
	}
	
	
}
