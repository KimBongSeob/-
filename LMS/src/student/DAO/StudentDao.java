package student.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classplan.DTO.ClassplanDataBean;
import classplan.DTO.ClassplanModifyDataBean;
import jdbc.jdbcUtil;
import professor.DTO.ProfessorDataBean;
import professor.DTO.ProfessorSubDataBean;
import student.DTO.DepartmentDataBean;
import student.DTO.EvaluationDataBean;
import student.DTO.EvaluationItemDataBean;
import student.DTO.RegisterDataBean;
import student.DTO.ReinstatementDataBean;
import student.DTO.ResultDataBean;
import student.DTO.ScholarshipDataBean;
import student.DTO.StudentDataBean;
import student.DTO.StudentRegisterDataBean;
import subject.DTO.SubjectDataBean;

public class StudentDao {
	private static StudentDao instance = new StudentDao();

	public static StudentDao getInstance() {
		return instance;
	}

	private StudentDao() {
	}

	// 작성 날짜 순으로 장학금테이블 모든 속성 select
	public List<ScholarshipDataBean> selectScholarship_All(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from SCHOLARSHIP where SD_NUM = ? order by SYS_DATE");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ScholarshipDataBean> itemList = new ArrayList<ScholarshipDataBean>();
			do {
				ScholarshipDataBean item = makeItemScholarshipResultSet(rs);
				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	public List<ScholarshipDataBean> selectScholarship(Connection conn, int id, String year, int grade, String semester)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from SCHOLARSHIP where SD_NUM = ? and year = ? and GRADE = ? and SEMESTER = ?");
			pstmt.setInt(1, id);
			pstmt.setString(2, year);
			pstmt.setInt(3, grade);
			pstmt.setString(4, semester);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ScholarshipDataBean> itemList = new ArrayList<ScholarshipDataBean>();
			do {
				ScholarshipDataBean article = makeItemScholarshipResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	public StudentDataBean selectStudent(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDataBean item = null;
		try {
			pstmt = conn.prepareStatement("select * from student where sd_num = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = makeItemStudentResultSet(rs);
			}
			return item;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	private ScholarshipDataBean makeItemScholarshipResultSet(ResultSet rs) throws SQLException {
		ScholarshipDataBean item = new ScholarshipDataBean();
		item.setNo(rs.getInt("NO"));
		item.setSd_num(rs.getInt("SD_NUM"));
		item.setYear(rs.getString("YEAR"));
		item.setGrade(rs.getInt("GRADE"));
		item.setSemester(rs.getString("SEMESTER"));
		item.setName(rs.getString("NAME"));
		item.setSum(rs.getInt("SUM"));
		item.setSys_date(rs.getTimestamp("SYS_DATE"));
		return item;
	}

	private ReinstatementDataBean makeItemReinstatementResultSet(ResultSet rs) throws SQLException {
		ReinstatementDataBean item = new ReinstatementDataBean();
		item.setSd_num(rs.getInt("sd_num"));
		item.setRe_loa_date(rs.getTimestamp("RE_LOA_DATE"));
		item.setLoa_end_year(rs.getString("LOA_END_YEAR"));
		item.setLoa_end_semester(rs.getString("LOA_END_SEMESTER"));
		item.setLoa_a_date(rs.getTimestamp("LOA_A_DATE"));
		item.setRe_start_date(rs.getTimestamp("RE_START_DATE"));
		item.setRe_end_date(rs.getTimestamp("RE_END_DATE"));
		return item;
	}

	private RegisterDataBean makeItemRegisterResultSet(ResultSet rs) throws SQLException {
		RegisterDataBean item = new RegisterDataBean();
		item.setSd_num(rs.getInt("sd_num"));
		item.setSrc_request_date(rs.getDate("SRC_REQUEST_DATE"));
		item.setSrc_date(rs.getDate("SRC_DATE"));
		item.setSrc_value(rs.getString("SRC_VALUE"));
		return item;
	}

	private StudentDataBean makeItemStudentResultSet(ResultSet rs) throws SQLException {
		StudentDataBean item = new StudentDataBean();
		/*
		 * no; sd_num;// 학번 sd_name; // 학생이름 sd_passwd;// 학생 pw d_num;// 학과번호
		 * d_sub_num;// 부/복수전공번호 sd_jumin;//학생 생일월일 sd_hpone;//학생 핸드폰 번호
		 * sd_address;//학생 주소 sd_email;//학생 이메일 sd_ac_no;//계좌번호
		 * sd_ac_name;//계좌은행이름 sd_grade;//현재학년 sd_semester;//이수학기
		 * sd_start_date;//입학날짜 sd_end_date;//졸업날짜 sd_re_loa;//재학인지 휴학인지 상태값
		 * sd_specialty;//전공,부전공,복수전공인지 상태값
		 */ item.setNo(rs.getInt("NO"));
		item.setSd_num(rs.getInt("SD_NUM"));
		item.setSd_name(rs.getString("SD_NAME"));
		item.setSd_passwd(rs.getString("sd_passwd"));
		item.setD_num(rs.getString("d_num"));
		item.setD_sub_num(rs.getString("d_sub_num"));
		item.setSd_jumin(rs.getDate("sd_jumin"));
		item.setSd_hpone(rs.getString("sd_hpone"));
		item.setSd_address(rs.getString("sd_address"));
		item.setSd_email(rs.getString("sd_email"));
		item.setSd_ac_no(rs.getString("sd_ac_no"));
		item.setSd_ac_name(rs.getString("sd_ac_name"));
		item.setSd_grade(Integer.parseInt(rs.getString("sd_grade")));
		item.setSd_semester(Integer.parseInt(rs.getString("sd_semester")));
		item.setSd_start_date(rs.getTimestamp("sd_start_date"));
		item.setSd_end_date(rs.getTimestamp("sd_end_date"));
		item.setSd_re_loa(rs.getString("sd_re_loa"));
		item.setSd_specialty(rs.getString("sd_specialty"));

		return item;
	}

	// 학생 학적정보 databean 객체 생성
	private StudentRegisterDataBean makeItemStudentRegisterResultSet(ResultSet rs) throws SQLException {
		StudentRegisterDataBean item = new StudentRegisterDataBean();
		// sd_num;// 학번
		// d_name;// 학과이름
		// sd_name; // 학생이름
		// sd_re_loa;//재학인지 휴학인지 이름
		// sd_jumin;//학생 생일월일
		// sd_grade;//현재학년
		// sd_semester;//이수학기
		// sd_start_date;//입학날짜
		// sd_end_date;//졸업날짜
		// sd_address;//학생 주소
		// sub_type//전공/부전공/복수전공 구분;
		// sub_name//부전공/복수전공 이름;
		item.setSd_num(rs.getInt("SD_NUM"));
		item.setD_name(rs.getString("d_name"));
		item.setSd_name(rs.getString("SD_NAME"));
		item.setSd_re_loa(rs.getString("sd_re_loa"));
		item.setSd_jumin(rs.getDate("sd_jumin"));
		item.setSd_grade(Integer.parseInt(rs.getString("sd_grade")));
		item.setSd_semester(Integer.parseInt(rs.getString("sd_semester")));
		item.setSd_start_date(rs.getDate("sd_start_date"));
		item.setSd_end_date(rs.getDate("sd_end_date"));
		item.setSd_address(rs.getString("sd_address"));
		item.setSub_type(rs.getString("sub_type"));
		item.setSub_name(rs.getString("sub_name"));

		return item;
	}

	// 교수 databean resultset 생성
	private ProfessorDataBean makeItemProfessorResultSet(ResultSet rs) throws SQLException {
		ProfessorDataBean item = new ProfessorDataBean();
		// no;//
		// pf_num;//교번
		// pf_name;//교수이름
		// pf_passwd;//교수 pw
		// d_num;//학과번호
		// pf_jumin;//교수 생일월일
		// pf_hpone;//교수 핸드폰 번호
		// pf_address;//교수 주소
		// pf_email;//교수 이메일
		// pf_ac_no;//교수 계좌번호
		// pf_ac_name;//계좌은행이름
		item.setNo(rs.getInt("no"));
		item.setPf_num(rs.getString("pf_num"));
		item.setPf_name(rs.getString("pf_name"));
		item.setPf_passwd(rs.getString("pf_passwd"));
		item.setD_num(rs.getString("d_num"));
		item.setPf_jumin(rs.getDate("pf_jumin"));
		item.setPf_hpone(rs.getString("pf_hpone"));
		item.setPf_address(rs.getString("pf_address"));
		item.setPf_email(rs.getString("pf_email"));
		item.setPf_ac_no(rs.getString("pf_ac_no"));
		item.setPf_ac_name(rs.getString("pf_ac_name"));

		return item;
	}

	// 교수 학과 resultset 생성
	private ProfessorSubDataBean makeItemProfessorSubResultSet(ResultSet rs) throws SQLException {
		ProfessorSubDataBean item = new ProfessorSubDataBean();

		// pf_name;//교수이름
		// d_name;//학과이름

		item.setPf_name(rs.getString("pf_name"));
		item.setD_name(rs.getString("d_name"));
		item.setD_num(rs.getString("d_num"));
		item.setPf_num(rs.getString("pf_num"));
		item.setPf_email(rs.getString("pf_email"));

		return item;
	}

	// 과목 resultset 생성
	private SubjectDataBean makeItemSubjectResultSet(ResultSet rs) throws SQLException {
		SubjectDataBean item = new SubjectDataBean();
		// no;//
		// s_num;//--과목번호(학수번호)
		// s_name;//--교과목명
		// s_cp_division;//--이수구분
		// s_cp_credits;//--이수학점
		// d_num;//학과번호

		item.setNo(rs.getInt("no"));
		item.setS_num(rs.getString("s_num"));
		item.setS_name(rs.getString("s_name"));
		item.setS_cp_division(rs.getString("S_cp_division"));
		item.setS_cp_credits(rs.getInt("s_cp_credits"));
		item.setD_num(rs.getString("d_num"));

		return item;
	}

	// 강의 계획서 resultSet
	private ClassplanDataBean makeItemClassplanResultSet(ResultSet rs) throws SQLException {
		ClassplanDataBean item = new ClassplanDataBean();
		// int cp_num;//강의계획
		// String cp_year;//개설년도
		// String cp_semester;//개설학기
		// String s_cp_division;//이수구분
		// int s_cp_credits;//이수학점
		// String s_num;//과목번호
		// String s_name;//과목이름
		// String pf_name;//교수이름
		// String cp_time;//강의시간/요일
		// int cp_max_no;//강의 최대인원
		// int cp_current_no;//강의 현재인원
		// String cr_num;//강의실 번호
		// String registration;//승인여부 / 등록여부

		item.setCp_num(rs.getInt("cp_num"));
		item.setCp_year(rs.getString("cp_year"));
		item.setCp_semester(rs.getString("cp_semester"));
		item.setS_cp_division(rs.getString("S_cp_division"));
		item.setS_cp_credits(rs.getInt("s_cp_credits"));
		item.setS_num(rs.getString("s_num"));
		item.setS_name(rs.getString("s_name"));
		item.setPf_name(rs.getString("pf_name"));
		item.setCp_time(rs.getString("cp_time"));
		item.setCp_max_no(rs.getInt("cp_max_no"));
		item.setCp_current_no(rs.getInt("cp_current_no"));
		item.setCr_num(rs.getString("cr_num"));
		item.setRegistration(rs.getString("registration"));

		return item;
	}

	// 강의계획서 수정 폼 select
	private ClassplanModifyDataBean makeItemClassplan_Md_ResultSet(ResultSet rs) throws SQLException {
		ClassplanModifyDataBean item = new ClassplanModifyDataBean();
		// private int cp_num ;// 강의계획번호
		// private Date cp_date; //작성일자
		// private String cp_year; //개설년도
		// private String cp_semester; //개설학기
		// String s_name; //과목이름
		// String s_num; //과목번호
		// int s_cp_credits;//이수학점
		// String cp_time;// 강의시간/요일
		// String d_num;// 과번호
		// String d_name;// 과이름
		// String cr_num;//강의실 번호
		// String pf_num;//교수 번호
		// String pf_name;//교수이름
		// String pf_email;//교수 이메일
		// String s_cp_division;//과목 이수구분
		// int cp_max_no;// 강의 최대인원
		// String cp_outline;//강의개요
		// String cp_textbook;//교재
		// String cp_sub_textbook;//부교재
		// String cp_valuation;// 평가방법

		item.setCp_num(rs.getInt("cp_num"));
		item.setCp_date(rs.getDate("cp_date"));
		item.setCp_year(rs.getString("cp_year"));
		item.setCp_semester(rs.getString("cp_semester"));
		item.setS_name(rs.getString("s_name"));
		item.setS_num(rs.getString("s_num"));
		item.setS_cp_credits(rs.getInt("s_cp_credits"));
		item.setCp_time(rs.getString("cp_time"));
		item.setD_num(rs.getString("d_num"));
		item.setD_name(rs.getString("d_name"));
		item.setCr_num(rs.getString("cr_num"));
		item.setPf_num(rs.getString("pf_num"));
		item.setPf_name(rs.getString("pf_name"));
		item.setPf_email(rs.getString("pf_email"));
		item.setS_cp_division(rs.getString("s_cp_division"));
		item.setCp_max_no(rs.getInt("cp_max_no"));
		item.setCp_outline(rs.getString("cp_outline"));
		item.setCp_textbook(rs.getString("cp_textbook"));
		item.setCp_sub_textbook(rs.getString("cp_sub_textbook"));
		item.setCp_valuation(rs.getString("cp_valuation"));

		return item;
	}

	// DepartmentDataBean ResultSet
	private DepartmentDataBean makeItemDepartmentResultSet(ResultSet rs) throws SQLException {
		DepartmentDataBean item = new DepartmentDataBean();

		item.setNo(rs.getInt("no"));
		item.setD_name(rs.getString("d_name"));
		item.setD_num(rs.getString("d_num"));

		return item;
	}

	/************** 로그인 ***********/

	public int studentCheck(Connection conn, String sd_num, String sd_passwd) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1

		try {
			pstmt = conn.prepareStatement("select sd_passwd from student where sd_num = ?"); // 입력한
																								// 전달받은
																								// id와
																								// 일치하는
																								// passwd를
																								// 꺼내온다.
			pstmt.setString(1, sd_num);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("sd_passwd"); // rs객체의 getString()메소드로
														// 해당하는 컬럼명("passwd")의
														// 쿼리의 결과값을 String타입으로
														// dbpasswd변수에 저장한다.

				if (dbpasswd.equals(sd_passwd)) { // db에 저장된 암호(dbpasswd)와 사용자가
													// 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				} else {
					x = 0;
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서
					// 레코드가 변하지 않음. 경우의 수 x=0 저장.
			} else { // 테이블에 레코드값이 존재하지 않을 경우,
				x = -1;
			} // 해당 아이디 없음 // 경우의 수 x=-1 저장.

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x; // x에 저장된 값 리턴.
	}

	// loginPro.jsp
	public int professorCheck(Connection conn, String pf_num, String pf_passwd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1

		try {
			pstmt = conn.prepareStatement("select pf_passwd from professor where pf_num = ?"); // 입력한
																								// 전달받은
																								// id와
																								// 일치하는
																								// passwd를
																								// 꺼내온다.
			pstmt.setString(1, pf_num);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("pf_passwd"); // rs객체의 getString()메소드로
														// 해당하는 컬럼명("passwd")의
														// 쿼리의 결과값을 String타입으로
														// dbpasswd변수에 저장한다.
				if (dbpasswd.equals(pf_passwd)) { // db에 저장된 암호(dbpasswd)와 사용자가
													// 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				} else {
					x = 0;
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서
					// 레코드가 변하지 않음. 경우의 수 x=0 저장.
			} else { // 테이블에 레코드값이 존재하지 않을 경우,
				x = -1;
			} // 해당 아이디 없음 // 경우의 수 x=-1 저장.

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x; // x에 저장된 값 리턴.
	}

	/********* 로그인 끝 *********/

	// select 재학,휴학 상태인 학생 데이터
	public StudentDataBean selectLOA(Connection conn, int id, String loa) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDataBean item = null;
		try {
			pstmt = conn.prepareStatement("select * from student where sd_num = ? and SD_RE_LOA = ?");
			pstmt.setInt(1, id);
			pstmt.setString(2, loa);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = makeItemStudentResultSet(rs);
				return item;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 휴학 신청 insert 문
	public int insertReinstatementLOA(Connection conn, int id, String LOA_END_YEAR, String LOA_END_SEMESTER) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int count = -1;
			String d_num;
			pstmt = conn.prepareStatement("select d_num from student where sd_num = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				d_num = rs.getString("d_num");
			} else {
				return count;
			}

			pstmt = conn.prepareStatement(
					"insert into REINSTATEMENT (sd_num,d_num,LOA_END_YEAR,LOA_END_SEMESTER) values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, d_num);
			pstmt.setString(3, LOA_END_YEAR);
			pstmt.setString(4, LOA_END_SEMESTER);
			count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 복학 신청 update 문
	public int updateReinstatementLOA(Connection conn, int id, Date LOA_A_DATE) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update REINSTATEMENT set RE_START_DATE = TO_CHAR(SYSDATE,'YYYY-MM-DD') where sd_num = ? and LOA_A_DATE = ?");
			pstmt.setInt(1, id);
			pstmt.setDate(2, LOA_A_DATE);
			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 휴학신청 update 문
	public int updateReinstatementLoaExtension(Connection conn, int id, Date LOA_A_DATE, String LOA_END_YEAR,
			String LOA_END_SEMESTER) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update REINSTATEMENT set LOA_A_DATE = null, LOA_END_YEAR = ?, LOA_END_SEMESTER = ? where sd_num = ? and LOA_A_DATE = ?");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setString(1, LOA_END_YEAR);
			pstmt.setString(2, LOA_END_SEMESTER);
			pstmt.setInt(3, id);
			pstmt.setDate(4, LOA_A_DATE);
			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	//////////// ********휴복학 select 문 써야됨
	public ReinstatementDataBean selectReinstatement(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReinstatementDataBean item = null;
		try {
			pstmt = conn.prepareStatement(
					"select SD_NUM,RE_LOA_DATE,LOA_END_YEAR,LOA_END_SEMESTER,LOA_A_DATE,RE_START_DATE,RE_END_DATE from (select * from REINSTATEMENT where sd_num = ? order by RE_LOA_DATE desc) where ROWNUM <= 1");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = makeItemReinstatementResultSet(rs);
				return item;
			}

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// REGISTER
	public List<RegisterDataBean> selectRegister(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RegisterDataBean> itemlist = new ArrayList<RegisterDataBean>();
		try {
			pstmt = conn.prepareStatement("select * from REGISTER where SD_NUM = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<RegisterDataBean> itemList = new ArrayList<RegisterDataBean>();
			do {
				itemlist.add(makeItemRegisterResultSet(rs));
			} while (rs.next());
			return itemlist;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 학적 조회
	public StudentRegisterDataBean selectStudentRegister(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentRegisterDataBean item = null;
		try {
			pstmt = conn.prepareStatement("select SD_NUM, DEPARTMENT.D_NAME as D_NAME,  SD_NAME, "
					+ "CASE SD_RE_LOA WHEN '0' THEN '재학'  WHEN '1' THEN '휴학' "
					+ "END as SD_RE_LOA, SD_JUMIN, SD_GRADE,SD_SEMESTER, SD_START_DATE, SD_END_DATE, SD_ADDRESS,"
					+ " CASE SD_SPECIALTY WHEN '0' THEN '전공'  WHEN '1' THEN '부전공' WHEN '2' THEN '복수전공'"
					+ " END as sub_type, CASE SD_SPECIALTY WHEN '0' THEN ''"
					+ "  WHEN '1' THEN (select d.D_NAME from student s,DEPARTMENT d where s.D_SUB_NUM = d.D_NUM)"
					+ " WHEN '2' THEN (select d.D_NAME from student s,DEPARTMENT d where s.D_SUB_NUM = d.D_NUM)"
					+ " END as sub_name from student,DEPARTMENT where sd_num = ? and student.D_NUM = DEPARTMENT.D_NUM");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return item;
			} else {
				item = makeItemStudentRegisterResultSet(rs);
			}
			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 강의 계획서 조회 -> 교수, 학과명,학과번호,교수번호 출력.
	public ProfessorSubDataBean selectProfessorName(Connection conn, String p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfessorSubDataBean item = null;
		try {
			pstmt = conn.prepareStatement(
					"select d_name, pf_name,d_num,pf_num,lower(pf_email) as pf_email from professor ,(select d_name from DEPARTMENT,professor where DEPARTMENT.D_NUM = professor.D_NUM and professor.pf_num = ?) p where pf_num = ?");
			pstmt.setString(1, p_id);
			pstmt.setString(2, p_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return item;
			} else {
				item = makeItemProfessorSubResultSet(rs);
			}
			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}// select s_num,s_name,s_cp_division,s_cp_credits,d_num from subject where
		// d_num = '00';

	public List<SubjectDataBean> selectSubjectName(Connection conn, String p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubjectDataBean> itemList = new ArrayList<SubjectDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select * from subject where d_num IN(select d_num from professor where pf_num = ?)");
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemSubjectResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	public List<SubjectDataBean> selectSubjectRefinementName(Connection conn, String p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubjectDataBean> itemList = new ArrayList<SubjectDataBean>();
		try {
			pstmt = conn.prepareStatement("select * from subject where d_num = ?");
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemSubjectResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	/// select * from subject where s_num = 'CC001'; 과목번호로 검색(학수번호)
	public SubjectDataBean selectSubjectNum(Connection conn, String s_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectDataBean item = null;
		try {
			pstmt = conn.prepareStatement("select * from subject where s_num = ?");
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return item;
			} else {
				item = makeItemSubjectResultSet(rs);
			}
			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	/// 강의계획서 select 문
	public List<ClassplanDataBean> selectClassplan(Connection conn, String p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassplanDataBean> itemList = new ArrayList<ClassplanDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select CP_NUM, CP_YEAR,CP_SEMESTER,S_CP_DIVISION,S_CP_CREDITS, SUBJECT.S_NUM,S_NAME, PROFESSOR.PF_NAME ,CP_TIME,CP_MAX_NO,CP_CURRENT_NO,CR_NUM,REGISTRATION from CLASSPLAN , SUBJECT , PROFESSOR where PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num  and CLASSPLAN.PF_NUM = ?");
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemClassplanResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 강의계획번호를 참조하여 데이터를 select
	public ClassplanModifyDataBean selectClassplanModify(Connection conn, String c_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassplanModifyDataBean item = null;
		try {
			pstmt = conn.prepareStatement(
					"select CLASSPLAN.CP_NUM,CLASSPLAN.CP_DATE,CLASSPLAN.CP_YEAR,CLASSPLAN.CP_SEMESTER,SUBJECT.S_NAME,"
							+ "SUBJECT.S_NUM,SUBJECT.S_CP_CREDITS,CLASSPLAN.CP_TIME,PROFESSOR.D_NUM,DEPARTMENT.D_NAME,CLASSPLAN.CR_NUM,PROFESSOR.PF_NUM,"
							+ "PROFESSOR.PF_NAME,PROFESSOR.PF_EMAIL,SUBJECT.S_CP_DIVISION,CLASSPLAN.CP_MAX_NO,CLASSPLAN.CP_OUTLINE,CLASSPLAN.CP_TEXTBOOK,"
							+ "CLASSPLAN.CP_SUB_TEXTBOOK,CLASSPLAN.CP_VALUATION from CLASSPLAN , SUBJECT , PROFESSOR,DEPARTMENT "
							+ "where PROFESSOR.d_num = DEPARTMENT.d_num and  PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and "
							+ "CLASSPLAN.d_num = SUBJECT.d_num  and cp_num = ?");
			pstmt.setString(1, c_id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return item;
			} else {
				item = makeItemClassplan_Md_ResultSet(rs);
			}

			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 강의계획서 INSERT문
	public int insertClassplan(Connection conn, int CP_MAX_NO, String CP_YEAR, String CP_SEMESTER, String S_NUM,
			String CP_TIME, String D_NUM, String CR_NUM, String PF_NUM, String PF_EMAIL, String CP_OUTLINE,
			String CP_TEXTBOOK, String CP_SUB_TEXTBOOK, String CP_VALUATION) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = conn.prepareStatement(
					"INSERT INTO CLASSPLAN(NO,CP_NUM,S_NUM,CR_NUM,PF_NUM,CP_TIME,CP_MAX_NO,CP_CURRENT_NO,CP_OUTLINE,CP_TEXTBOOK,CP_SUB_TEXTBOOK,CP_VALUATION,CP_YEAR,CP_SEMESTER,D_NUM) VALUES(SEQ_NO_CLASSPLAN.NEXTVAL, SEQ_CLASSPLAN.NEXTVAL,?,?,?,?,?,0,?,?,?,?,?,?,?)");
			pstmt.setString(1, S_NUM);
			pstmt.setString(2, CR_NUM);
			pstmt.setString(3, PF_NUM);
			pstmt.setString(4, CP_TIME);
			pstmt.setInt(5, CP_MAX_NO);
			pstmt.setString(6, CP_OUTLINE);
			pstmt.setString(7, CP_TEXTBOOK);
			pstmt.setString(8, CP_SUB_TEXTBOOK);
			pstmt.setString(9, CP_VALUATION);
			pstmt.setString(10, CP_YEAR);
			pstmt.setString(11, CP_SEMESTER);
			pstmt.setString(12, D_NUM);

			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 강의계획서 업데이트문
	public int updateClassplan(Connection conn, int CP_NUM, int CP_MAX_NO, String CP_YEAR, String CP_SEMESTER,
			String S_NUM, String CP_TIME, String D_NUM, String CR_NUM, String PF_NUM, String CP_OUTLINE,
			String CP_TEXTBOOK, String CP_SUB_TEXTBOOK, String CP_VALUATION, Date CP_DATE) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = conn.prepareStatement("update CLASSPLAN set CP_MAX_NO = ?, CP_YEAR = ?, CP_SEMESTER = ?,"
					+ " S_NUM = ?, CP_TIME = ?, D_NUM = ?, CR_NUM = ?,"
					+ " PF_NUM = ?, CP_OUTLINE = ?, CP_TEXTBOOK = ?,"
					+ " CP_SUB_TEXTBOOK = ?, CP_VALUATION = ? ,CP_DATE = ? where cp_num = ?");
			pstmt.setInt(1, CP_MAX_NO);
			pstmt.setString(2, CP_YEAR);
			pstmt.setString(3, CP_SEMESTER);
			pstmt.setString(4, S_NUM);
			pstmt.setString(5, CP_TIME);
			pstmt.setString(6, D_NUM);
			pstmt.setString(7, CR_NUM);
			pstmt.setString(8, PF_NUM);
			pstmt.setString(9, CP_OUTLINE);
			pstmt.setString(10, CP_TEXTBOOK);
			pstmt.setString(11, CP_SUB_TEXTBOOK);
			pstmt.setString(12, CP_VALUATION);
			pstmt.setDate(13, CP_DATE);
			pstmt.setInt(14, CP_NUM);

			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 시간표 출력. ---> 과목 검색을 위한 과목 select
	public List<DepartmentDataBean> selectDepartment(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DepartmentDataBean> itemlist = new ArrayList<DepartmentDataBean>();
		try {
			pstmt = conn.prepareStatement("select * from DEPARTMENT");
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<DepartmentDataBean> itemList = new ArrayList<DepartmentDataBean>();
			do {
				itemlist.add(makeItemDepartmentResultSet(rs));
			} while (rs.next());
			return itemlist;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 과목으로 검색해서 강의계획서 select
	public List<ClassplanDataBean> selectD_Classplan(Connection conn, String d_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassplanDataBean> itemList = new ArrayList<ClassplanDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select CP_NUM, CP_YEAR,CP_SEMESTER,S_CP_DIVISION,S_CP_CREDITS, SUBJECT.S_NUM,S_NAME, PROFESSOR.PF_NAME  ,CP_TIME,CP_MAX_NO,CP_CURRENT_NO,CR_NUM,REGISTRATION from CLASSPLAN , SUBJECT , PROFESSOR where PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num and REGISTRATION = '1' and CLASSPLAN.d_num IN (select d_num from DEPARTMENT where d_num = ?)");
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemClassplanResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	// insert into CLASSREQUEST(NO,CR_NUM,CP_NUM,SD_NUM)
	// values(SEQ_NO_CLASSREQUEST.NEXTVAL,SEQ_CLASSREQUEST.NEXTVAL,?,?)

	// 수강신청 insert문
	public int insertClassrequest(Connection conn, int CP_NUM, int SD_NUM) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int check = 0;
			int count = 0;

			pstmt = conn.prepareStatement("select * from CLASSREQUEST where SD_NUM = ? and CP_NUM = ?");
			pstmt.setInt(1, SD_NUM);
			pstmt.setInt(2, CP_NUM);
			rs = pstmt.executeQuery();
			// 현재 수강신청한 과목인지.
			if (rs.next()) {
				return check = -2;
			} else {// 현재 수강신청한 과목이 아니면, 수강신청 현재인원이 최대인원보다 작은지
				pstmt = conn.prepareStatement("select * from classplan where CP_CURRENT_NO = CP_MAX_NO and cp_num = ?");
				pstmt.setInt(1, CP_NUM);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return check = -1;
				} else {
					check = 1;
				}
			}
			if (check == 1) {

				String d_num = "";
				pstmt = conn.prepareStatement("select d_num from student where sd_num = ?");
				pstmt.setInt(1, SD_NUM);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					d_num = rs.getString("d_num");
				}
				pstmt = conn.prepareStatement(
						"insert into CLASSREQUEST(NO,CR_NUM,d_num,CP_NUM,SD_NUM) values(SEQ_NO_CLASSREQUEST.NEXTVAL,SEQ_CLASSREQUEST.NEXTVAL,?,?,?)");
				pstmt.setString(1, d_num);
				pstmt.setInt(2, CP_NUM);
				pstmt.setInt(3, SD_NUM);
				count = pstmt.executeUpdate();

				pstmt = conn.prepareStatement(
						"insert into evaluation values(SEQ_EVALUATION.NEXTVAL,SEQ_CLASSREQUEST.CURRVAL,'강의자료가 적절히 활용되어 학습에 도움이 되었다.','교수님은 학생들의 참여와 소통을 독려하였다.','성적평가의 기준이 적절하며 공정하였다.','이 수업은 전반적으로 출결관리가 잘 되었다.','본 강의는 전반적으로 유익하였다.','')");
				count = pstmt.executeUpdate();

				pstmt = conn.prepareStatement("update classplan set CP_CURRENT_NO = CP_CURRENT_NO+1 where cp_num = ?");
				pstmt.setInt(1, CP_NUM);
				pstmt.executeUpdate();
			}
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 해당 학번이 수강신청한 강의계획서 select
	public List<ClassplanDataBean> selectClassRequestClassplan(Connection conn, String SD_NUM) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassplanDataBean> itemList = new ArrayList<ClassplanDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select CP_NUM, CP_YEAR,CP_SEMESTER,S_CP_DIVISION,S_CP_CREDITS, SUBJECT.S_NUM,S_NAME, PROFESSOR.PF_NAME  ,CP_TIME,CP_MAX_NO,CP_CURRENT_NO,CR_NUM,REGISTRATION from CLASSPLAN , SUBJECT , PROFESSOR where PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num and REGISTRATION = '1' and CLASSPLAN.cp_num IN (select cp_num from CLASSREQUEST where SD_NUM = ?)");
			pstmt.setString(1, SD_NUM);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemClassplanResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 수강신청 삭제
	public int deleteClassrequest(Connection conn, int cp_num, int sd_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"delete from EVALUATION where cr_num = (select cr_num from CLASSREQUEST where cp_num = ? and sd_num = ?)");
			pstmt.setInt(1, cp_num);
			pstmt.setInt(2, sd_num);

			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("delete from CLASSREQUEST where cp_num = ? and sd_num = ?");
			pstmt.setInt(1, cp_num);
			pstmt.setInt(2, sd_num);

			int count = pstmt.executeUpdate();

			pstmt = conn.prepareStatement("update classplan set CP_CURRENT_NO = CP_CURRENT_NO-1 where cp_num = ?");
			pstmt.setInt(1, cp_num);
			pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 담은과목 insert
	public int insertClassbasket(Connection conn, int cp_num, int sd_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int check = 0;

			pstmt = conn.prepareStatement("select * from CLASSBASKET where SD_NUM = ? and CP_NUM = ?");
			pstmt.setInt(1, sd_num);
			pstmt.setInt(2, cp_num);
			rs = pstmt.executeQuery();
			// 현재 담아 있는 과목인지.
			if (rs.next()) {
				check = -1;
				return check;
			} else {
				pstmt = conn.prepareStatement(
						"insert into CLASSBASKET(NO,CB_NUM,CP_NUM,SD_NUM) values(SEQ_NO_CLASSBASKET.NEXTVAL ,SEQ_CLASSBASKET.NEXTVAL, ?, ?)");
				pstmt.setInt(1, cp_num);
				pstmt.setInt(2, sd_num);
				check = pstmt.executeUpdate();
				return check;
			}

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 담은과목의 강의계획들을 select
	public List<ClassplanDataBean> selectClassbasketClassplan(Connection conn, String SD_NUM) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassplanDataBean> itemList = new ArrayList<ClassplanDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select CP_NUM, CP_YEAR,CP_SEMESTER,S_CP_DIVISION,S_CP_CREDITS, SUBJECT.S_NUM,S_NAME, PROFESSOR.PF_NAME  ,CP_TIME,CP_MAX_NO,CP_CURRENT_NO,CR_NUM,REGISTRATION from CLASSPLAN , SUBJECT , PROFESSOR where PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num and REGISTRATION = '1' and CLASSPLAN.cp_num IN (select cp_num from classbasket where SD_NUM = ?)");
			pstmt.setString(1, SD_NUM);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				itemList.add(makeItemClassplanResultSet(rs));
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 수강신청 삭제
	public int deleteClassbasket(Connection conn, int cp_num, int sd_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = conn.prepareStatement("delete from CLASSBASKET where cp_num = ? and sd_num = ?");
			pstmt.setInt(1, cp_num);
			pstmt.setInt(2, sd_num);

			int count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	/////////////////////////////////////////////////////////////////////

	// 학생이 복수/부전공 신청 ::: 복수/부전공 테이블에 신청값 삽입
	public int insertSpecialty(Connection conn, int sd_num, String d_sub_num, Date dm_date, Date m_date)
			throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = conn.prepareStatement("select sd_num,d_num from student where SD_SPECIALTY = '0' and sd_num = ?");
			pstmt.setInt(1, sd_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 전공 상태값이 0 -> 복수전공/부전공을 가지고 있지 않으므로,
				String d_num = rs.getString("d_num"); // 그 학생의 과번호를 가져옴.
				pstmt = conn.prepareStatement("select * from student where sd_num = ? and d_num = ?");
				pstmt.setInt(1, sd_num);
				pstmt.setString(2, d_sub_num);
				rs = pstmt.executeQuery();
				if (rs.next()) {// 신청한 학생이 신청한 전공이 이미 자기가 가지고 있는 전공이면
					return -2;
				} else {
					pstmt = conn.prepareStatement("select MAX(SP_NO) sp_no,sd_num from SUBSPECIALTY group by sd_num");
					rs = pstmt.executeQuery();
					if (rs.next()) { // 신청한 sp_no가 존재하면
						pstmt = conn.prepareStatement(
								"select * from SUBSPECIALTY,(select MAX(SP_NO) sp_no,sd_num from SUBSPECIALTY group by sd_num) s_sub where ((DM_DATE is not null and A_DATE is null) or (M_DATE is  not null and MA_DATE is null)) and s_sub.sp_no = SUBSPECIALTY.SP_NO and s_sub.sd_num = SUBSPECIALTY.SD_NUM");
						rs = pstmt.executeQuery();
						if (rs.next()) {// 부전공, 복수전공 둘 중에 하나가 신청만 된 상태면, 중복
										// 신청이므로 -1
										// return;
							return -1;
						}
					} else {// sp_no가 없으면 신청 가능.
						pstmt = conn.prepareStatement(
								"insert into subspecialty(SP_NO,sd_num,D_SUB_NUM,DM_DATE,M_DATE,d_num) values(SEQ_SUBSPECIALTY.NEXTVAL,?,?,?,?,?)");

						pstmt.setInt(1, sd_num);
						pstmt.setString(2, d_sub_num); // 신청한 전공 학과 번호
						pstmt.setDate(3, dm_date); // 복수전공 신청날짜
						pstmt.setDate(4, m_date); // 부전공 신청날짜
						pstmt.setString(5, d_num);
						return pstmt.executeUpdate(); // count 반환
					}
				}

				// pstmt = conn.prepareStatement(
				// "insert into
				// subspecialty(SP_NO,sd_num,D_SUB_NUM,DM_DATE,M_DATE)
				// values(SEQ_SUBSPECIALTY.NEXTVAL,?,?,?,?)");
				//
				// pstmt.setInt(1, sd_num);
				// pstmt.setString(2, d_sub_num); // 신청한 전공 학과 번호
				// pstmt.setDate(3, dm_date); // 복수전공 신청날짜
				// pstmt.setDate(4, m_date); // 부전공 신청날짜
				// return pstmt.executeUpdate(); // count 반환
			} else { // 전공이나 부전공 상태 이므로
				return 0; // 0을 반환
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(conn);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
		}
		return 0;
	}

	// 로그인한 학생이 당해 학기에 수강한 강의목록 리스트 셀렉트
	public List<EvaluationDataBean> selectClass_All(Connection conn, int sd_num, String cp_year, String cp_semester,
			String registration) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select S_NAME, PROFESSOR.PF_NAME , SUBJECT.S_NUM , CP_TIME ,"
					+ "classrequest.cr_num from CLASSPLAN , SUBJECT , PROFESSOR ,classrequest "
					+ "where PROFESSOR.pf_num = CLASSPLAN.pf_num  and classplan.cp_num = classrequest.cp_num  and classrequest.sd_num = ?"
					+ "and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num "
					+ "and CLASSPLAN.cp_year = ? and CLASSPLAN.CP_SEMESTER = ? " + "and REGISTRATION = ? "
					+ "and CLASSPLAN.cp_num IN (select cp_num from CLASSREQUEST where SD_NUM =  ?)");

			pstmt.setInt(1, sd_num);
			pstmt.setString(2, cp_year);
			pstmt.setString(3, cp_semester);
			pstmt.setString(4, registration);
			pstmt.setInt(5, sd_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<EvaluationDataBean> itemList = new ArrayList<EvaluationDataBean>();
			do {
				EvaluationDataBean item = makeItemEvaluationResultSet(rs);
				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
			jdbcUtil.close(conn);
		}
	}

	public EvaluationItemDataBean selectEvalItem1(Connection conn, int sd_num, int cr_num) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EvaluationItemDataBean item = null;
		try {
			pstmt = conn.prepareStatement("select * from evaluation where cr_num = ?");
			pstmt.setInt(1, cr_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = makeItemEvaluationItemResultSet1(rs);
			}

			return item;
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
			jdbcUtil.close(conn);
		}
	}

	public List<EvaluationItemDataBean> selectEvalItem2(Connection conn, int sd_num, int cr_num, int e_sum)
			throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from evaluation where cr_num = ?");
			pstmt.setInt(1, cr_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			} else {
				pstmt = conn.prepareStatement("update evaluation set e_sum = ? where cr_num = ? ");
				pstmt.setInt(1, e_sum);
				pstmt.setInt(2, cr_num);
				pstmt.executeUpdate();
			}

			List<EvaluationItemDataBean> itemList = new ArrayList<EvaluationItemDataBean>();
			do {
				EvaluationItemDataBean item = makeItemEvaluationItemResultSet2(rs);
				itemList.add(item);
				System.out.println("item:::" + item);
			} while (rs.next());

			return itemList;
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
			jdbcUtil.close(conn);
		}
	}

	private EvaluationItemDataBean makeItemEvaluationItemResultSet1(ResultSet rs) throws SQLException {
		EvaluationItemDataBean item = new EvaluationItemDataBean();
		item.setList_1(rs.getString("LIST_1"));
		item.setList_2(rs.getString("LIST_2"));
		item.setList_3(rs.getString("LIST_3"));
		item.setList_4(rs.getString("LIST_4"));
		item.setList_5(rs.getString("LIST_5"));
		item.setCr_num(rs.getInt("CR_NUM"));
		// item.setE_sum(rs.getInt("E_SUM"));
		return item;
	}

	private EvaluationItemDataBean makeItemEvaluationItemResultSet2(ResultSet rs) throws SQLException {
		EvaluationItemDataBean item = new EvaluationItemDataBean();
		item.setList_1(rs.getString("LIST_1"));
		item.setList_2(rs.getString("LIST_2"));
		item.setList_3(rs.getString("LIST_3"));
		item.setList_4(rs.getString("LIST_4"));
		item.setList_5(rs.getString("LIST_5"));
		item.setCr_num(rs.getInt("CR_NUM"));
		item.setE_sum(rs.getInt("E_SUM"));
		return item;
	}

	private EvaluationDataBean makeItemEvaluationResultSet(ResultSet rs) throws SQLException {
		EvaluationDataBean item = new EvaluationDataBean();
		// item.setNo(rs.getInt("NO"));
		item.setS_name(rs.getString("S_NAME"));
		item.setPf_name(rs.getString("PF_NAME"));
		item.setS_num(rs.getString("S_NUM"));
		item.setCp_time(rs.getString("CP_TIME"));
		item.setCr_num(rs.getInt("CR_NUM"));
		return item;
	}

	// 학생관리 - 학과 불러오기
	public List<DepartmentDataBean> selectDepartment_All(Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from department order by d_num");

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<DepartmentDataBean> itemList = new ArrayList<DepartmentDataBean>();
			do {
				DepartmentDataBean item = makeItemDepartmentResultSet(rs);
				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	//////////// 개인정보조회
	public int Pre_modifyCheck(Connection conn, int sd_num, String sd_passwd) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1

		try {
			pstmt = conn.prepareStatement("select sd_passwd from student where sd_num = ?"); // 입력한
																								// 전달받은
																								// id와
																								// 일치하는
																								// passwd를
																								// 꺼내온다.
			pstmt.setInt(1, sd_num);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("sd_passwd"); // rs객체의 getString()메소드로
														// 해당하는 컬럼명("passwd")의
														// 쿼리의 결과값을 String타입으로
														// dbpasswd변수에 저장한다.

				if (dbpasswd.equals(sd_passwd)) { // db에 저장된 암호(dbpasswd)와 사용자가
													// 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				} else {
					x = 0;
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서
					// 레코드가 변하지 않음. 경우의 수 x=0 저장.
			} else { // 테이블에 레코드값이 존재하지 않을 경우,
				x = -1;
			} // 해당 아이디 없음 // 경우의 수 x=-1 저장.

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x; // x에 저장된 값 리턴.
	}

	// 학생 개인정보 수정

	public void UpdateRegister_modify(Connection conn, int id, String sd_passwd, String sd_hpone, String sd_address,
			String sd_email) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update student set sd_passwd = ?, sd_hpone = ?, sd_address = ? ,sd_email = ? where sd_num = ?");
			pstmt.setString(1, sd_passwd);
			pstmt.setString(2, sd_hpone);
			pstmt.setString(3, sd_address);
			pstmt.setString(4, sd_email);
			pstmt.setInt(5, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	/******************** 학생 개인정보 부분 ***********************/

	public StudentDataBean selectRegister_modify(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDataBean item = null;
		/* List<StudentDataBean> itemlist = new ArrayList<StudentDataBean>(); */
		try {
			pstmt = conn.prepareStatement(
					"select sd_num,sd_name,sd_passwd,sd_jumin,sd_hpone,sd_address,sd_email from student where sd_num = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = new StudentDataBean();
				item.setSd_passwd(rs.getString("sd_passwd"));
				item.setSd_num(Integer.parseInt(rs.getString("sd_num")));
				item.setSd_name(rs.getString("sd_name"));
				item.setSd_jumin(rs.getDate("sd_jumin"));
				item.setSd_hpone(rs.getString("sd_hpone"));
				item.setSd_address(rs.getString("sd_address"));
				item.setSd_email(rs.getString("sd_email"));
			}
			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 성적조회 / 년도,학기 검색
	public List<ResultDataBean> yearlist(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT DISTINCT CP_YEAR,CP_SEMESTER " + "FROM CLASSPLAN,CLASSREQUEST "
					+ "WHERE CLASSPLAN.CP_NUM = CLASSREQUEST.CP_NUM "
					+ "AND SD_NUM = ? ORDER BY CP_YEAR DESC,CP_SEMESTER DESC");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ResultDataBean> itemList = new ArrayList<ResultDataBean>();
			do {
				ResultDataBean item = new ResultDataBean();
				item.setCp_year(rs.getString("cp_year"));
				item.setCp_semester(rs.getString("cp_semester"));
				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 학생 전체 성적조회
	public List<ResultDataBean> studentResultAll(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn
					.prepareStatement("SELECT CLASSPLAN.cp_year,CLASSPLAN.cp_semester,SUBJECT.S_CP_DIVISION, CLASSPLAN.CP_NUM,  SUBJECT.S_num,SUBJECT.S_NAME, "
							+ "PROFESSOR.PF_NAME,SUBJECT.S_CP_CREDITS,CLASSREQUEST.G_SUM"
							+ " FROM CLASSREQUEST, SUBJECT, PROFESSOR, CLASSPLAN"
							+ " WHERE CLASSREQUEST.CP_NUM = CLASSPLAN.CP_NUM AND CLASSPLAN.PF_NUM = PROFESSOR.PF_NUM "
							+ "AND CLASSPLAN.S_NUM = SUBJECT.S_NUM AND SD_NUM = ? order by cp_year desc,cp_semester desc");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ResultDataBean> itemList = new ArrayList<ResultDataBean>();
			do {
				ResultDataBean item = new ResultDataBean();
				item.setCp_year(rs.getString("cp_year"));
				item.setCp_semester(rs.getString("cp_semester"));
				item.setS_cp_division(rs.getString("S_CP_DIVISION"));
				item.setS_num(rs.getString("S_num"));
				item.setCp_num(rs.getInt("CP_NUM"));
				item.setS_name(rs.getString("s_name"));
				item.setPf_name(rs.getString("pf_name"));
				item.setS_cp_credits(rs.getInt("s_cp_credits"));
				item.setG_sum(rs.getString("g_sum"));

				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 학생 학기별 성적 조회
	public List<ResultDataBean> studentResult(Connection conn, int id, String cp_year, String cp_semester)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn
					.prepareStatement("SELECT CLASSPLAN.cp_year,CLASSPLAN.cp_semester,SUBJECT.S_CP_DIVISION, CLASSPLAN.CP_NUM, SUBJECT.S_num,SUBJECT.S_NAME,"
							+ " PROFESSOR.PF_NAME,SUBJECT.S_CP_CREDITS,CLASSREQUEST.G_SUM "
							+ "FROM CLASSREQUEST, SUBJECT, PROFESSOR, CLASSPLAN "
							+ "WHERE CLASSREQUEST.CP_NUM = CLASSPLAN.CP_NUM AND CLASSPLAN.PF_NUM = PROFESSOR.PF_NUM "
							+ "AND CLASSPLAN.S_NUM = SUBJECT.S_NUM AND SD_NUM = ? AND CP_YEAR = ? AND CP_SEMESTER = ?");
			pstmt.setInt(1, id);
			pstmt.setString(2, cp_year);
			pstmt.setString(3, cp_semester);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ResultDataBean> itemList = new ArrayList<ResultDataBean>();
			do {
				ResultDataBean item = new ResultDataBean();
				item.setCp_year(rs.getString("cp_year"));
				item.setCp_semester(rs.getString("cp_semester"));
				item.setS_cp_division(rs.getString("S_cp_division"));
				item.setS_num(rs.getString("S_num"));
				item.setCp_num(rs.getInt("cp_num"));
				item.setS_name(rs.getString("s_name"));
				item.setPf_name(rs.getString("pf_name"));
				item.setS_cp_credits(rs.getInt("S_cp_credits"));
				item.setG_sum(rs.getString("g_sum"));
				itemList.add(item);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
}
