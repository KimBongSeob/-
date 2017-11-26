package student.DTO;
import java.sql.Date;

public class SubspecialtyDataBean { // 복수/부전공 신청 DTO클래스

	private int sp_no; // 복수/부전공 번호
	private int sd_num; // 학번
	private String d_num; // 현재 자신의 소속 학과 번호
	private String d_sub_num; // 신청한 복수/부전공 학과 번호
	private Date dm_date; // 복수전공 신청날짜
	private Date m_date; // 부전공 신청날짜
	private Date a_date; // 복수전공 승인날짜
	private Date ma_date; // 부전공 승인날짜
	
	public int getSp_no() {
		return sp_no;
	}
	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
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
