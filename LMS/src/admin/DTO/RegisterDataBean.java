package admin.DTO;

import java.sql.Date;

public class RegisterDataBean {
	private int sd_num;
	private Date src_request_date;// --변동 신청 날짜
	private Date src_date;//-- 학적변동 날짜
	private String src_value;//-- 학적 변동 내용 -> ( 신청 / 완료 )
	public int getSd_num() {
		return sd_num;
	}
	public void setSd_num(int sd_num) {
		this.sd_num = sd_num;
	}
	public Date getSrc_request_date() {
		return src_request_date;
	}
	public void setSrc_request_date(Date src_request_date) {
		this.src_request_date = src_request_date;
	}
	public Date getSrc_date() {
		return src_date;
	}
	public void setSrc_date(Date src_date) {
		this.src_date = src_date;
	}
	public String getSrc_value() {
		return src_value;
	}
	public void setSrc_value(String src_value) {
		this.src_value = src_value;
	}

	
}
