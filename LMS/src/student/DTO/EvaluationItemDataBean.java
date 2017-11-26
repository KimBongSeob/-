package student.DTO;

public class EvaluationItemDataBean {
	
	private int no;
	private int cr_num;
	private String list_1;
	private String list_2;
	private String list_3;
	private String list_4;
	private String list_5;
	private int e_sum;
	
	public int getNo() {
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
	public String getList_1() {
		return list_1;
	}
	public void setList_1(String list_1) {
		this.list_1 = list_1;
	}
	public String getList_2() {
		return list_2;
	}
	public void setList_2(String list_2) {
		this.list_2 = list_2;
	}
	public String getList_3() {
		return list_3;
	}
	public void setList_3(String list_3) {
		this.list_3 = list_3;
	}
	public String getList_4() {
		return list_4;
	}
	public void setList_4(String list_4) {
		this.list_4 = list_4;
	}
	public String getList_5() {
		return list_5;
	}
	public void setList_5(String list_5) {
		this.list_5 = list_5;
	}
	public int getE_sum() {
		return e_sum;
	}
	public void setE_sum(int e_sum) {
		this.e_sum = e_sum;
	}
	@Override
	public String toString() {
		return "EvaluationItemDataBean [no=" + no + ", cr_num=" + cr_num + ", list_1=" + list_1 + ", list_2=" + list_2
				+ ", list_3=" + list_3 + ", list_4=" + list_4 + ", list_5=" + list_5 + ", e_sum=" + e_sum + "]";
	}
	
}
