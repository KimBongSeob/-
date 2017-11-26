package noticeboard.DTO;
import java.sql.Timestamp;
public class ScholarshipDataBean {
	private int no;
	private int sd_num;// 학번
	private String year;// 년도
	private int grade;// 학년
	private String semester;// 학기
	private String name;// 장학금이름
	private int sum;// 장학금
	private Timestamp sys_date;// 작성날짜
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Timestamp getSys_date() {
		return sys_date;
	}
	public void setSys_date(Timestamp sys_date) {
		this.sys_date = sys_date;
	}
	
	public String getList() {
		return getYear()+"/"+getGrade()+"/"+getSemester();
	}
}