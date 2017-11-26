package student.reinstatement;

import java.text.SimpleDateFormat;
import java.util.Date;

import student.DTO.ReinstatementDataBean;

public class Algorithm {
	// 현재 년도를 구하는 메소드
	public static int getCurrent_year() {
		Date dt = new Date();// 시간
		SimpleDateFormat sdf_y = new SimpleDateFormat("yyyy"); // 년
		int year = Integer.parseInt(sdf_y.format(dt).toString());// 현재 년도 가져옴.
		return year;
	}

	// 현재 학기를 구하는 메소드
	public static int getCurrent_semester() {
		Date dt = new Date();// 시간
		SimpleDateFormat sdf_m = new SimpleDateFormat("mm"); // 월
		String m = sdf_m.format(dt).toString(); // 현재 몇 월인지 가져옴.
		int check_m = Integer.parseInt(m); // 월이 1~6 , 7~12 인지 체크
		int semester = 0;// 학기

		if (check_m <= 6) {
			semester = 1;// 1학기 지정
		} else {
			semester = 2;// 2학기 지정
		}
		return semester;
	}

	// 현재 년도, 현재 학기, 휴학만료년도, 휴학만료학기를 매개변수로 받아와 신청 가능 여부를 알려주는 메소드.
	public static boolean isSubmit(int year, int semester, int year_end, int semester_end) {
		boolean check = false;
		if (year < year_end) {
			check = true;
		} else if (year == year_end) {
			if (semester == semester_end) {
				check = true;
			} else if (semester < semester_end) {
				check = true;
			} else {
				check = false;
			}
		} else {
			check = false;
		}
		return check;
	}

	public static ReinstatementDataBean setItem(int date, int date_b,int request_semester) {
		// int date, int date_b 현재 년도 선택 현재 학기 선택
		ReinstatementDataBean item = new ReinstatementDataBean();
		//int request_semester = 5;// 신청 학기

		int semester = 2; // 학기 구분자
		int loa_year = 0;// 휴학 만료 년도 (현재 년도+만료년도)
		int sum_year = 0; // 휴학 만료 년도 저장
		int sum_semester = 0; // 휴학 만료 학기 저장

		if (date_b == 1) {
			sum_year = (request_semester / semester);//
			sum_semester = (request_semester % semester) + (semester - 1);//
		} else if (date_b == 2) {
			if (request_semester % semester == 0) {
				sum_year = (request_semester / semester);//
				sum_semester = (request_semester % semester) + semester;//
			} else {
				sum_year = (request_semester / semester) + (semester - 1);//
				sum_semester = (request_semester % semester);//
			}
		}
		loa_year = date + sum_year;
		item.setLoa_end_year("" + loa_year);
		item.setLoa_end_semester("" + sum_semester);
		return item;
	}
}
