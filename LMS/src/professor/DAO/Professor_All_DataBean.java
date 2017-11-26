package professor.DAO;

import java.util.Date;

public class Professor_All_DataBean {
	
	private int no;
	private String s_num;
	private String s_name;
	private String s_cp_division;
	private int s_cp_credits;
	private String d_num;
	
	
// ClassplanDataBean
/*	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}*/
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
/*	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}*/
	
	//SubjectDataBean
	
	private int cp_num;
	private String cr_num;
	private String pf_num;
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
	
	
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
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

	//DepartmentDataBean

/*	private int no;
	private String d_num;*/
	private String d_name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
	//StudentDataBean
	
//	private int no;
	private int sd_num;
	private String sd_name;
	private String sd_passwd;
//	private String d_num;
	private String d_sub_num;
	private String sd_jumin;
	private String sd_hpone;
	private String sd_address;
	private String sd_email;
	private String sd_ac_no;
	private String sd_ac_name;
	private Date sd_start_date;
	private Date sd_end_date;
	private String sd_re_loa;
	private String sd_specialty;
	
/*	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}*/
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public String getSd_name() {
		return sd_name;
	}
	public void setSd_name(String sd_name) {
		this.sd_name = sd_name;
	}
	public String getSd_passwd() {
		return sd_passwd;
	}
	public void setSd_passwd(String sd_passwd) {
		this.sd_passwd = sd_passwd;
	}
/*	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}*/
	public String getD_sub_num() {
		return d_sub_num;
	}
	public void setD_sub_num(String d_sub_num) {
		this.d_sub_num = d_sub_num;
	}
	public String getSd_jumin() {
		return sd_jumin;
	}
	public void setSd_jumin(String sd_jumin) {
		this.sd_jumin = sd_jumin;
	}
	public String getSd_hpone() {
		return sd_hpone;
	}
	public void setSd_hpone(String sd_hpone) {
		this.sd_hpone = sd_hpone;
	}
	public String getSd_address() {
		return sd_address;
	}
	public void setSd_address(String sd_address) {
		this.sd_address = sd_address;
	}
	public String getSd_email() {
		return sd_email;
	}
	public void setSd_email(String sd_email) {
		this.sd_email = sd_email;
	}
	public String getSd_ac_no() {
		return sd_ac_no;
	}
	public void setSd_ac_no(String sd_ac_no) {
		this.sd_ac_no = sd_ac_no;
	}
	public String getSd_ac_name() {
		return sd_ac_name;
	}
	public void setSd_ac_name(String sd_ac_name) {
		this.sd_ac_name = sd_ac_name;
	}
	public Date getSd_start_date() {
		return sd_start_date;
	}
	public void setSd_start_date(Date sd_start_date) {
		this.sd_start_date = sd_start_date;
	}
	public Date getSd_end_date() {
		return sd_end_date;
	}
	public void setSd_end_date(Date sd_end_date) {
		this.sd_end_date = sd_end_date;
	}
	public String getSd_re_loa() {
		return sd_re_loa;
	}
	public void setSd_re_loa(String sd_re_loa) {
		this.sd_re_loa = sd_re_loa;
	}
	public String getSd_specialty() {
		return sd_specialty;
	}
	public void setSd_specialty(String sd_specialty) {
		this.sd_specialty = sd_specialty;
	}
	
	
	//ClassrequestDataBean.java
	
/*	private int no;
	private int cr_num;
	private int cp_num;
	private int sd_num;*/
	private String g_sum;
	
/*	public int getNo() {
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
	}*/
	public String getG_sum() {
		return g_sum;
	}
	public void setG_sum(String g_sum) {
		this.g_sum = g_sum;
	}
	
	//Subject_Classplan_DepartmentDataBean.java
	
	
	
}

