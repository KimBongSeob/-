<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="student.Service.SelectStudentService"%>
<%@ page import="student.Service.SelectReinstatementService"%>
<%@ page import="student.DTO.StudentDataBean"%>
<%@ page import="student.DTO.ReinstatementDataBean"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="student.reinstatement.Algorithm"%>
<%@ page import="java.sql.Timestamp"%>
<%
	String select_value = request.getParameter("select_value");

	int id = Integer.parseInt((String) session.getAttribute("member"));
	StudentDataBean data = SelectStudentService.getInstance().getItem(id);
	int check_request = -1;
	int check_select = -1;
	if (select_value == null) {
		select_value = "";
	}

	int year = Algorithm.getCurrent_year();// 현재 년도 가져옴.

	int semester = Algorithm.getCurrent_semester();// 현재 학기 가져옴.

	String result = "";//결과 출력문
	Timestamp loa_date = null;
	int year_end=0;
	int semester_end=0;
	

	if (!select_value.equals("")) {
		if (select_value.equals("휴학")) {// 휴학 선택이면
			if (data.getSd_re_loa().equals("0")) { // 재학 중이면
				ReinstatementDataBean item = SelectReinstatementService.getInstance().getItem(id);
				if(item == null){
					result = "휴학 신청이 가능합니다.";
					check_request = 1;
					check_select = 2;
				}else{
					if(item.getLoa_a_date() == null){
						result = "승인 대기 중 입니다.";
						check_request = 0;
					}else if(item.getRe_end_date() != null){//최상위 데이터가 복학 완료된 데이터면, 현재 복학 완료 후, 휴학 신청하는 것이므로 가능.
						result = "휴학 신청이 가능합니다.";
						check_request = 1;
						check_select = 2;
					}
				}
			} else {// 휴학 중 이면
				result = "현재 휴학 중 입니다. 중복 신청은 불가능합니다.";
				check_request = 0;
			}
		} else if (select_value.equals("복학")) { //복학 선택이면
			if (data.getSd_re_loa().equals("1")) { // 휴학 중이면
				//
				//    					데이터 가져와서
				//
				//    					휴학승인날짜 null이면 대기중이기 때문에 insert 불가능 and 복학신청도 불가능(update 불가능)
				//
				//    					휴학승인날짜 내용이 있으면
				//    						복학신청날짜 null이면
				//    							복학신청 가능update 가능
				//    							insert 가능
				//    						복학신청날짜 값 있으면
				//    							복학신청 불가능 update 불가능
				//    							insert 불가능
				//
				ReinstatementDataBean Reinstatementdata = SelectReinstatementService.getInstance().getItem(id);
				year_end = Integer.parseInt(Reinstatementdata.getLoa_end_year());
				semester_end = Integer.parseInt(Reinstatementdata.getLoa_end_semester());
				boolean check = false;
				//request.setAttribute("loa_date", Reinstatementdata.getLoa_a_date());

				if (Reinstatementdata.getLoa_a_date() == null) { // 휴학승인날짜가 null 이면 요청 승인 대기 중이기 때문에 불가능.
					result = "승인 대기 중 입니다.";
					check_request = 0;
				} else { // 휴학승인 날짜가 존재하면
					loa_date = Reinstatementdata.getLoa_a_date();
					if (Reinstatementdata.getRe_start_date() == null) { // 복학 신청날짜가 없으면

						check = Algorithm.isSubmit(year, semester, year_end, semester);
						if (check) {
							result = "복학 신청이 가능합니다. 현재 학기:" + year + "-" + semester + " 휴학만료학기:" + year_end
									+ "-" + semester_end;
							check_request = 1;
							check_select = 1;
						} else {
							result = "복학 신청이 불가능합니다. 현재 학기:" + year + "-" + semester + " 휴학만료학기:" + year_end
									+ "-" + semester_end;
							//out.println("<script>alert('"+year+"-"+semester+"');</script>");
							//out.println("<script>alert('"+year_end+"-"+semester_end+"');</script>");
							check_request = 0;
						}

					} else { // 복학 신청날짜가 있으면
						result = "이미 복학 신청을 하셨습니다.";
						check_request = 0;
					}
				}

			} else { // 재학 중 이면
				result = "현재 재학 중 입니다. 휴학 중일 때만 신청 가능합니다.";
				check_request = 0;
			}

		} else if (select_value.equals("휴학연장")) {
			if (data.getSd_re_loa().equals("1")) {
				ReinstatementDataBean Reinstatementdata = SelectReinstatementService.getInstance().getItem(id);
				year_end = Integer.parseInt(Reinstatementdata.getLoa_end_year());
				semester_end = Integer.parseInt(Reinstatementdata.getLoa_end_semester());
				boolean check = false;
				if (Reinstatementdata.getLoa_a_date() == null) { // 휴학승인날짜가 null 이면 요청 승인 대기 중이기 때문에 불가능.
					result = "승인 대기 중 입니다.";
					check_request = 0;
				} else { // 휴학승인 날짜가 존재하면
					loa_date = Reinstatementdata.getLoa_a_date();
					if (Reinstatementdata.getRe_start_date() == null) { // 복학 신청날짜가 없으면
						check = Algorithm.isSubmit(year, semester, year_end, semester);

						if (check) {
							result = "휴학 연장 신청이 가능합니다. 현재 학기:" + year + "-" + semester + " 휴학만료학기:" + year_end
									+ "-" + semester_end;
							check_request = 1;
							check_select = 2;
						} else {
							result = "휴학 연장 신청이 불가능합니다. 현재 학기:" + year + "-" + semester + " 휴학만료학기:" + year_end
									+ "-" + semester_end;

							check_request = 0;
						}

					} else { // 복학 신청날짜가 있으면
						result = "이미 복학 신청을 하셨습니다. 휴학 연장 신청을 하실 수 없습니다.";
						check_request = 0;
					}
				}
			} else {
				result = "현재 재학 중 입니다. 휴학 중일 때만 신청 가능합니다.";
				check_request = 0;
			}
		}
	}
	
%>
<?xml version='1.0' encoding='UTF-8'?>
<select_check> <result><%=result%></result> <check_request><%=check_request%></check_request>
<check_select><%=check_select%></check_select> <loa_date><%=loa_date%></loa_date>
<year_end><%=year_end%></year_end> <semester_end><%=semester_end%></semester_end>


</select_check>