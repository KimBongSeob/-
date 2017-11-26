package noticeboard.DTO;
import java.sql.Timestamp;
public class StudentDataBean {
	
	private int no;
	private int sd_num;// 학번
	private String sd_name; // 학생이름
	private String sd_passwd;// 학생 pw
	private String d_num;// 학과번호
	private String d_sub_num;// 부/복수전공번호
	private String sd_jumin;//학생 생일월일
	private String sd_hpone;//학생 핸드폰 번호
	private String sd_address;//학생 주소
	private String sd_email;//학생 이메일
	private String sd_ac_no;//계좌번호
	private String sd_ac_name;//계좌은행이름
	private int sd_grade;//현재학년
	private int sd_semester;//이수학기
	private Timestamp sd_start_date;//입학날짜
	private Timestamp sd_end_date;//졸업날짜
	private String sd_re_loa;//재학인지 휴학인지 상태값
	private String sd_specialty;//전공,부전공,복수전공인지 상태값
	private int sd_status;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
	public Timestamp getSd_start_date() {
		return sd_start_date;
	}
	public void setSd_start_date(Timestamp sd_start_date) {
		this.sd_start_date = sd_start_date;
	}
	public Timestamp getSd_end_date() {
		return sd_end_date;
	}
	public void setSd_end_date(Timestamp sd_end_date) {
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
	public int getSd_status() {
		return sd_status;
	}
	public void setSd_status(int sd_status) {
		this.sd_status = sd_status;
	}
}
