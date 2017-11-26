package board.DTO;
import java.sql.Timestamp;

public class Mvc_BoardDataBean {
	private int num; //글번호
	private String WRITER; //학번
	private String subject; //제목
	private String passwd; //비번
	private Timestamp reg_date; //작성일
	private int readcount; //조회수
	private int ref; //그룹번호
	private int re_step; //그룹 내 순서
	private int re_level; //글의 레벨
	private String content; //내용
	private String filename;
	private String realpath;
	private long filesize;
	
	public void setNum (int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	public void setWriter (String WRITER) {
		this.WRITER = WRITER;
	}
	public String getWriter() {
		return WRITER;
	}
	
	public void setSubject (String subject) {
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setReg_date (Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	
	public void setReadcount (int readcount) {
		this.readcount = readcount;
	}
	public int getReadcount() {
		return readcount;
	}
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRef() {
		return ref;
	}
	
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_step() {
		return re_step;
	}
	
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getRe_level() {
		return re_level;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilename() {
		return filename;
	}
	
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public String getRealpath() {
		return realpath;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public long getFilesize() {
		return filesize;
	}
}
