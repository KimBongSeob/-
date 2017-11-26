package student.DTO;
import java.sql.Date;
public class StudentRegisterDataBean {
	private int sd_num;// 학번
	private String d_name;// 학과이름
	private String sd_name; // 학생이름
	private String sd_re_loa;//재학인지 휴학인지 이름
	private Date sd_jumin;//학생 생일월일
	private int sd_grade;//현재학년
	private int sd_semester;//이수학기
	private Date sd_start_date;//입학날짜
	private Date sd_end_date;//졸업날짜
	private String sd_address;//학생 주소
	private String sub_type;//전공/부전공/복수전공 구분
	private String sub_name;//부전공/복수전공 이름
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getSd_name() {
		return sd_name;
	}
	public void setSd_name(String sd_name) {
		this.sd_name = sd_name;
	}
	public String getSd_re_loa() {
		return sd_re_loa;
	}
	public void setSd_re_loa(String sd_re_loa) {
		this.sd_re_loa = sd_re_loa;
	}

	public Date getSd_jumin() {
		return sd_jumin;
	}
	public void setSd_jumin(Date sd_jumin) {
		this.sd_jumin = sd_jumin;
	}
	public int getSd_grade() {
		return sd_grade;
	}
	public void setSd_grade(int sd_grade) {
		this.sd_grade = sd_grade;
	}
	public int getSd_semester() {
		return sd_semester;
	}
	public void setSd_semester(int sd_semester) {
		this.sd_semester = sd_semester;
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
	public String getSd_address() {
		return sd_address;
	}
	public void setSd_address(String sd_address) {
		this.sd_address = sd_address;
	}
	public String getSub_type() {
		return sub_type;
	}
	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
}