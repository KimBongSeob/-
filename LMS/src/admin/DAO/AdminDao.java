package admin.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import admin.DTO.ClassplanDataBean2;
import admin.DTO.DepartmentDataBean;
import admin.DTO.ProfessorDataBean;
import admin.DTO.RegisterDataBean;
import admin.DTO.ReinstatementDataBean;
import admin.DTO.StudentRegisterDataBean;
import admin.DTO.SubjectDataBean;
import admin.DTO.SubspecialtyDataBean;
import classplan.DTO.ClassplanDataBean;
import classplan.DTO.ClassplanModifyDataBean;
import jdbc.jdbcUtil;
import student.DTO.StudentDataBean;

public class AdminDao {
	private static AdminDao instance = new AdminDao();

	public static AdminDao getInstance() {
		return instance;
	}

	private AdminDao() {
	}

	// 필요한 메소드 추가하세요~.~

	// 교수관리 - 교수리스트 불러오기
	public List<ProfessorDataBean> selectProfessor_All(Connection conn, String d_name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select pf_num,pf_name,pf_jumin from PROFESSOR where pf_status = 0 and d_num=(select d_num from department where d_name= ?) order by pf_num");

			pstmt.setString(1, d_name);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ProfessorDataBean> itemList = new ArrayList<ProfessorDataBean>();
			do {
				ProfessorDataBean article = makeItemProfessorResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 교수관리 - 교수 상세정보조회
	public List<ProfessorDataBean> selectProfessor_Register(Connection conn, String pf_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from professor where pf_NUM = ?");
			pstmt.setString(1, pf_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ProfessorDataBean> itemList = new ArrayList<ProfessorDataBean>();
			do {
				ProfessorDataBean article = makeItemProfessorRegisterResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 교수관리 - 교수목록에서 교수정보 조회
	public List<ProfessorDataBean> selectProfessor_Check(Connection conn, String pf_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select pf_NUM, DEPARTMENT.D_NAME as D_NAME,pf_NAME,pf_JUMIN,pf_ADDRESS from professor,DEPARTMENT where pf_num = ? and professor.D_NUM = DEPARTMENT.D_NUM");
			pstmt.setString(1, pf_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ProfessorDataBean> itemList = new ArrayList<ProfessorDataBean>();
			do {
				ProfessorDataBean article = makeItemProfessorCheckResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
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

	public int updateReinstatementLOA(Connection conn, int sd_num, Date lOA_A_DATE) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update REINSTATEMENT set RE_START_DATE = TO_DATE(SYSDATE,'YYYY-MM-DD') where sd_num = ? and LOA_A_DATE = ?");
			pstmt.setInt(1, sd_num);
			pstmt.setDate(2, lOA_A_DATE);
			int count = pstmt.executeUpdate();
			return count;

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

	// 학생관리 - 학생 상세정보조회
	public List<RegisterDataBean> selectStudent_Register(Connection conn, int sd_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from REGISTER where SD_NUM = ?");
			pstmt.setInt(1, sd_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<RegisterDataBean> itemList = new ArrayList<RegisterDataBean>();
			do {
				RegisterDataBean article = makeItemStudentRegisterResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 학생관리 - 학생목록에서 학생정보 조회
	public List<StudentRegisterDataBean> selectStudent_Check(Connection conn, int sd_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select SD_NUM, DEPARTMENT.D_NAME as D_NAME,  SD_NAME, "
					+ "CASE SD_RE_LOA WHEN '0' THEN '재학'  WHEN '1' THEN '휴학' "
					+ "END as SD_RE_LOA, SD_JUMIN, SD_GRADE,SD_SEMESTER, SD_START_DATE, SD_END_DATE, SD_ADDRESS,"
					+ " CASE SD_SPECIALTY WHEN '0' THEN '전공'  WHEN '1' THEN '부전공' WHEN '2' THEN '복수전공'"
					+ " END as sub_type, CASE SD_SPECIALTY WHEN '0' THEN ''"
					+ "  WHEN '1' THEN (select d.D_NAME from student s,DEPARTMENT d where s.D_SUB_NUM = d.D_NUM)"
					+ " WHEN '2' THEN (select d.D_NAME from student s,DEPARTMENT d where s.D_SUB_NUM = d.D_NUM)"
					+ " END as sub_name from student,DEPARTMENT where sd_num = ? and student.D_NUM = DEPARTMENT.D_NUM");
			pstmt.setInt(1, sd_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<StudentRegisterDataBean> itemList = new ArrayList<StudentRegisterDataBean>();
			do {
				StudentRegisterDataBean article = makeItemStudentCheckResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 교수관리 - 교수등록
	public int insertProfessor(Connection conn, String pf_num, String pf_passwd, String pf_name, Date pf_jumin_date,
			String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			
				pstmt = conn.prepareStatement(
						"insert into professor(no,pf_num,pf_name,pf_passwd,pf_jumin,d_num) values(SEQ_STUDENT.NEXTVAL,?,?,?,?,?)");
				pstmt.setString(1, pf_num);
				pstmt.setString(2, pf_name);
				pstmt.setString(3, pf_passwd);
				pstmt.setDate(4, pf_jumin_date);
				pstmt.setString(5, d_num);
				x = pstmt.executeUpdate();

		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		return x;
	}

	// 학생관리 - 학생등록
	public int insertStudent(Connection conn, int sd_num, String sd_passwd, String sd_name, Date sd_jumin_date,
			String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {

				pstmt = conn.prepareStatement(
						"insert into student(no,sd_num,sd_name,sd_passwd,sd_jumin,d_num,d_sub_num,SD_GRADE,Sd_semester) values(SEQ_STUDENT.NEXTVAL,?,?,?,?,?,'',1,1)");
				pstmt.setInt(1, sd_num);
				pstmt.setString(2, sd_name);
				pstmt.setString(3, sd_passwd);
				pstmt.setDate(4, sd_jumin_date);
				pstmt.setString(5, d_num);

				x = pstmt.executeUpdate();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		return x;
	}

	// 학생관리 - 학생삭제
	public int deleteStudent(Connection conn, int sd_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			pstmt = conn.prepareStatement("delete from student where sd_num = ?"); // delete
																								// from
																								// student
																								// where
																								// sd_num=?
			pstmt.setInt(1, sd_num);
			x = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return x;
	}

	// 교수관리 - 교수삭제
	public int deleteProfessor(Connection conn, String pf_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			pstmt = conn.prepareStatement("delete from professor where pf_num=?"); // delete
																								// from
																								// student
																								// where
																								// sd_num=?
			pstmt.setString(1, pf_num);
			x = pstmt.executeUpdate();
			/*
			 * if(rs.next()) { x = 1; // 삭제 성공 }else { x = 0; // 삭제 실패 }
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return x;
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

	// 학생관리 - 학생리스트 불러오기
	public List<StudentDataBean> selectStudent_All(Connection conn, String d_name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select sd_num,sd_name,sd_jumin,d_num from student where sd_status = 0 and d_num=(select d_num from department where d_name= ?) order by sd_num");

			pstmt.setString(1, d_name);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<StudentDataBean> itemList = new ArrayList<StudentDataBean>();
			do {
				StudentDataBean article = makeItemStudentResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	public List<ClassplanDataBean2> SelectSubjectList_All(Connection conn, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select CP_NUM, S_CP_DIVISION, S_NAME, PROFESSOR.PF_NAME from CLASSPLAN , SUBJECT , PROFESSOR where PROFESSOR.pf_num = CLASSPLAN.pf_num and SUBJECT.S_NUM = CLASSPLAN.S_NUM and CLASSPLAN.d_num = SUBJECT.d_num  and CLASSPLAN.REGISTRATION = '0' and CLASSPLAN.d_num IN (select d_num from DEPARTMENT where d_num = ?)");

			pstmt.setString(1, d_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ClassplanDataBean2> itemList = new ArrayList<ClassplanDataBean2>();
			do {
				ClassplanDataBean2 article = makeItemSubjectResultSet(rs);
				itemList.add(article);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 강의시간 중복확인
	public int Submit_checkModify(Connection conn, String CP_TIME, String CR_NUM) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;// 경우의 수

		try {
			pstmt = conn.prepareStatement("select * from CLASSPLAN where cp_time like substr(?,1,3) or cp_time like '"
					+ CP_TIME + "%' and cr_num = ?");
			pstmt.setString(1, CP_TIME);
			pstmt.setString(2, CR_NUM);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = -1; // 등록 실패
			} else {
				count = 1; // 등록 성공
			}
			return count;
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
		}

	}

	public int getCountProfessor(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from PROFESSOR");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
		return count;
	}

	public int getCountStudent(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from STUDENT");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
		return count;
	}

	public int getCountSubject(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from SUBJECT");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
		return count;
	}

	public int getCountDepartment(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from DEPARTMENT");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
		return count;
	}

	// update classplan set REGISTRATION = '1', CP_TIME = ? , CR_NUM = ? where
	// cp_num = ?
	public int updateRegistrationClassplan(Connection conn, String CP_TIME, String CR_NUM, int cp_num) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update classplan set REGISTRATION = '1', CP_TIME = ? , CR_NUM = ? where cp_num = ?");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setString(1, CP_TIME);
			pstmt.setString(2, CR_NUM);
			pstmt.setInt(3, cp_num);
			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// -------------------------------------------------------------------------------------------
	private ClassplanDataBean2 makeItemSubjectResultSet(ResultSet rs) throws SQLException {
		ClassplanDataBean2 item = new ClassplanDataBean2();

		item.setS_cp_division(rs.getString("S_CP_DIVISION"));
		item.setCp_num(rs.getInt("CP_NUM"));
		item.setS_name(rs.getString("S_NAME"));
		item.setPf_name(rs.getString("PF_NAME"));
		return item;
	}

	private ProfessorDataBean makeItemProfessorResultSet(ResultSet rs) throws SQLException {
		ProfessorDataBean item = new ProfessorDataBean();

		item.setPf_num(rs.getString("pf_num"));
		item.setPf_name(rs.getString("pf_name"));
		item.setPf_jumin(rs.getDate("pf_jumin"));
		return item;
	}

	private ProfessorDataBean makeItemProfessorRegisterResultSet(ResultSet rs) throws SQLException {
		ProfessorDataBean item = new ProfessorDataBean();

		item.setPf_num(rs.getString("pf_num"));

		return item;

	}

	private RegisterDataBean makeItemStudentRegisterResultSet(ResultSet rs) throws SQLException {
		RegisterDataBean item = new RegisterDataBean();

		item.setSd_num(rs.getInt("sd_num"));
		item.setSrc_request_date(rs.getDate("SRC_REQUEST_DATE"));
		item.setSrc_date(rs.getDate("SRC_DATE"));
		item.setSrc_value(rs.getString("SRC_VALUE"));

		return item;

	}

	private StudentRegisterDataBean makeItemStudentCheckResultSet(ResultSet rs) throws SQLException {
		StudentRegisterDataBean item = new StudentRegisterDataBean();

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

	private ProfessorDataBean makeItemProfessorCheckResultSet(ResultSet rs) throws SQLException {
		ProfessorDataBean item = new ProfessorDataBean();

		item.setPf_num(rs.getString("pf_NUM"));
		item.setPf_name(rs.getString("d_name"));
		item.setPf_name(rs.getString("pf_NAME"));
		item.setPf_jumin(rs.getDate("pf_JUMIN"));
		item.setPf_address(rs.getString("pf_ADDRESS"));

		return item;
	}

	private DepartmentDataBean makeItemDepartmentResultSet(ResultSet rs) throws SQLException {
		DepartmentDataBean item = new DepartmentDataBean();
		item.setNo(rs.getInt("NO"));
		item.setD_name(rs.getString("D_NAME"));
		item.setD_num(rs.getString("D_NUM"));
		return item;
	}

	private StudentDataBean makeItemStudentResultSet(ResultSet rs) throws SQLException {
		StudentDataBean item = new StudentDataBean();

		item.setSd_num(rs.getInt("sd_num"));
		item.setSd_name(rs.getString("sd_name"));
		item.setSd_jumin(rs.getDate("sd_jumin"));
		item.setD_num(rs.getString("d_num"));

		return item;
	}

	// 강의계획서 수정 폼 select
	private ClassplanModifyDataBean makeItemClassplan_Md_ResultSet(ResultSet rs) throws SQLException {
		ClassplanModifyDataBean item = new ClassplanModifyDataBean();

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

	// 강의 계획서 resultSet
	private ClassplanDataBean makeItemClassplanResultSet(ResultSet rs) throws SQLException {
		ClassplanDataBean item = new ClassplanDataBean();

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

	// 장학금 관리 select
	public List<StudentDataBean> selectAvgGradeMax(Connection conn, String year, String semester, String d_num,
			int grade) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDataBean> itemList = new ArrayList<StudentDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select DEPARTMENT.d_num, DEPARTMENT.d_name, student.sd_num, sd_name, p.s_sum,SD_GRADE, rownum r "
							+ "from DEPARTMENT, student , (select sum(g_sum)/count(*) as s_sum,sd_num from CLASSREQUEST "
							+ "where sd_num not in(select sd_num from classrequest where g_sum is null) "
							+ "and cp_num IN(select cp_num from CLASSPLAN where CLASSPLAN.cp_year = ? and CLASSPLAN.CP_SEMESTER = ? "
							+ "and REGISTRATION = '1' and CLASSPLAN.cp_num IN (select cp_num from CLASSREQUEST where d_num = ?)) group by sd_num) p "
							+ "where DEPARTMENT.d_num = student.d_num and student.SD_NUM = p.sd_num and sd_grade = ? ORDER by p.s_sum desc");
			pstmt.setString(1, year);
			pstmt.setString(2, semester);
			pstmt.setString(3, d_num);
			pstmt.setInt(4, grade);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				StudentDataBean item = new StudentDataBean();
				item.setD_num(rs.getString("d_num"));
				item.setSd_num(rs.getInt("sd_num"));
				item.setSd_name(rs.getString("sd_name"));
				item.setS_sum(rs.getDouble("s_sum"));
				item.setD_name(rs.getString("d_name"));
				item.setSd_grade(rs.getInt("sd_grade"));

				itemList.add(item);
			} while (rs.next());

			return itemList;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// insert into SCHOLARSHIP(NO,SD_NUM,YEAR,GRADE,SEMESTER,NAME,SUM)
	// values(SEQ_SCHOLARSHIP.NEXTVAL,?,?,?,?,?,?)
	public int insertScholarship(Connection conn, int sd_num, String year, int grade, String semester, String name,
			int sum) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement(
					"insert into SCHOLARSHIP(NO,SD_NUM,YEAR,GRADE,SEMESTER,NAME,SUM) values(SEQ_SCHOLARSHIP.NEXTVAL,?,?,?,?,?,?)");
			pstmt.setInt(1, sd_num);
			pstmt.setString(2, year);
			pstmt.setInt(3, grade);
			pstmt.setString(4, semester);
			pstmt.setString(5, name);
			pstmt.setInt(6, sum);
			count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 과등록
	public int insertDepartment(Connection conn, String d_num, String d_name) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn
					.prepareStatement("insert into DEPARTMENT(NO,D_NUM,D_NAME) values(SEQ_DEPARTMENT.NEXTVAL, ?, ?)");

			pstmt.setString(1, d_num);
			pstmt.setString(2, d_name);

			count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	public int deleteDepartment(Connection conn, String d_num) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement("delete from DEPARTMENT where d_num = ?");
			pstmt.setString(1, d_num);
			count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	// 휴학 리스트 select
	// select
	// DEPARTMENT.d_name,student.SD_NUM,student.SD_name,RE_LOA_DATE,LOA_END_YEAR,LOA_END_SEMESTER,LOA_A_DATE,RE_START_DATE,RE_END_DATE
	// from student,DEPARTMENT,(select * from REINSTATEMENT where
	// REINSTATEMENT.RE_LOA_DATE is not null and LOA_A_DATE is null and d_num =
	// '01' order by RE_LOA_DATE desc) p where DEPARTMENT.d_num = p.d_num and
	// student.sd_num = p.sd_num
	public List<ReinstatementDataBean> selectReinstatement(Connection conn, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select DEPARTMENT.d_name,student.SD_NUM,student.SD_name,RE_LOA_DATE,LOA_END_YEAR,LOA_END_SEMESTER,LOA_A_DATE,RE_START_DATE,RE_END_DATE from student,DEPARTMENT,(select * from REINSTATEMENT where REINSTATEMENT.RE_LOA_DATE is not null and LOA_A_DATE is null and d_num = ? order by RE_LOA_DATE desc) p where DEPARTMENT.d_num = p.d_num and student.sd_num = p.sd_num");

			pstmt.setString(1, d_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ReinstatementDataBean> itemList = new ArrayList<ReinstatementDataBean>();
			do {
				ReinstatementDataBean data = new ReinstatementDataBean();
				data.setD_name(rs.getString("d_name"));
				data.setSd_num(rs.getInt("sd_num"));
				data.setSd_name(rs.getString("sd_name"));
				data.setLoa_end_year(rs.getString("loa_end_year"));
				data.setLoa_end_semester(rs.getString("loa_end_semester"));
				data.setRe_loa_date(rs.getDate("re_loa_date"));
				data.setLoa_a_date(rs.getDate("loa_a_date"));
				data.setRe_start_date(rs.getDate("re_start_date"));
				data.setRe_end_date(rs.getDate("re_end_date"));
				itemList.add(data);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 휴학 승인
	public int updateLoaApproval(Connection conn, int SD_NUM, Date RE_LOA_DATE, Date SRC_REQUEST_DATE,
			String SRC_VALUE) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement(
					"update reinstatement set LOA_A_DATE = TO_CHAR(SYSDATE,'YYYY-mm-dd') where sd_num = ? and TO_DATE(RE_LOA_DATE) = TO_DATE(?)");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setInt(1, SD_NUM);
			pstmt.setDate(2, RE_LOA_DATE);
			count = pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into REGISTER(sd_num,SRC_REQUEST_DATE,SRC_VALUE) values(?,?,?)");

			pstmt.setInt(1, SD_NUM);
			pstmt.setDate(2, SRC_REQUEST_DATE);
			pstmt.setString(3, SRC_VALUE);
			count = pstmt.executeUpdate();

			pstmt = conn.prepareStatement("update student set SD_RE_LOA = '1' where sd_num = ?");
			pstmt.setInt(1, SD_NUM);
			count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	//
	// 복학 selete문
	// select
	// DEPARTMENT.d_name,student.SD_NUM,student.SD_name,RE_LOA_DATE,LOA_END_YEAR,LOA_END_SEMESTER,LOA_A_DATE,RE_START_DATE,RE_END_DATE
	// from student,DEPARTMENT,(select * from REINSTATEMENT where
	// REINSTATEMENT.RE_START_DATE is not null and REINSTATEMENT.RE_END_DATE is
	// null and d_num = ? order by RE_LOA_DATE desc) p where DEPARTMENT.d_num =
	// p.d_num and student.sd_num = p.sd_num
	public List<ReinstatementDataBean> selectReinstatement_B(Connection conn, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select DEPARTMENT.d_name,student.SD_NUM,student.SD_name,RE_LOA_DATE,LOA_END_YEAR,LOA_END_SEMESTER,LOA_A_DATE,RE_START_DATE,RE_END_DATE from student,DEPARTMENT,(select * from REINSTATEMENT where REINSTATEMENT.RE_START_DATE is not null and REINSTATEMENT.RE_END_DATE is null and d_num = ? order by RE_LOA_DATE desc) p where DEPARTMENT.d_num = p.d_num and student.sd_num = p.sd_num");

			pstmt.setString(1, d_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			List<ReinstatementDataBean> itemList = new ArrayList<ReinstatementDataBean>();
			do {
				ReinstatementDataBean data = new ReinstatementDataBean();
				data.setD_name(rs.getString("d_name"));
				data.setSd_num(rs.getInt("sd_num"));
				data.setSd_name(rs.getString("sd_name"));
				data.setLoa_end_year(rs.getString("loa_end_year"));
				data.setLoa_end_semester(rs.getString("loa_end_semester"));
				data.setRe_loa_date(rs.getDate("re_loa_date"));
				data.setLoa_a_date(rs.getDate("loa_a_date"));
				data.setRe_start_date(rs.getDate("re_start_date"));
				data.setRe_end_date(rs.getDate("re_end_date"));
				itemList.add(data);
			} while (rs.next());
			return itemList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}

	// 복학 승인
	public int updateLoaApproval_B(Connection conn, int SD_NUM, Date RE_START_DATE, Date SRC_REQUEST_DATE,
			String SRC_VALUE) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement(
					"update reinstatement set RE_END_DATE = TO_CHAR(SYSDATE,'yyyy-mm-dd') where sd_num = ? and TO_DATE(RE_START_DATE) = TO_DATE(?)");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setInt(1, SD_NUM);
			pstmt.setDate(2, RE_START_DATE);
			count = pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into REGISTER(sd_num,SRC_REQUEST_DATE,SRC_VALUE) values(?,?,?)");

			pstmt.setInt(1, SD_NUM);
			pstmt.setDate(2, SRC_REQUEST_DATE);
			pstmt.setString(3, SRC_VALUE);
			count = pstmt.executeUpdate();

			pstmt = conn.prepareStatement("update student set SD_RE_LOA = '0' where sd_num = ?");
			pstmt.setInt(1, SD_NUM);
			count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	//select MAX(sd_num)+1 sd_num from student where substr(sd_num,0,6) = '201101';
	//연도, 학번으로 현재 최대 학번+1 데이터 가져오기
	public StudentDataBean selectStudentSdnum(Connection conn, String sd_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDataBean data = new StudentDataBean();
		try {
			pstmt = conn.prepareStatement(
					"select MAX(sd_num)+1 sd_num from student where substr(sd_num,0,6) = ?");

			pstmt.setString(1, sd_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}else{
				data.setSd_num(rs.getInt("sd_num"));
				return data;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	// 교수 등록 -> 교수번호 select문
	public ProfessorDataBean selectProfessorPfnum(Connection conn, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfessorDataBean data = new ProfessorDataBean();
		try {
			pstmt = conn.prepareStatement(
					"select MAX(pf_num) pf_num from professor where d_num = ?");

			pstmt.setString(1, d_num);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}else{
				data.setPf_num(rs.getString("pf_num"));
				return data;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	//select MAX(d_num) d_num from DEPARTMENT;
	public DepartmentDataBean selectDepartmentMax(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DepartmentDataBean data = new DepartmentDataBean();
		try {
			pstmt = conn.prepareStatement(
					"select MAX(d_num) d_num from DEPARTMENT");

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}else{
				data.setD_num(rs.getString("d_num"));
				return data;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	//select * from SUBSPECIALTY where (M_DATE is not null and MA_DATE is null) and D_NUM = '01';
	public List<SubspecialtyDataBean> selectSubspecialtyBf(Connection conn,String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubspecialtyDataBean> dataList = new ArrayList<SubspecialtyDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select sp_no, student.d_num, d.d_name, student.sd_num, student.sd_name, SUBSPECIALTY.d_sub_num, d_sub.d_name d_sub_name, SUBSPECIALTY.m_date from SUBSPECIALTY,student,department d,department d_sub where  d.d_num = student.d_num and d_sub.d_num = SUBSPECIALTY.d_sub_num and SUBSPECIALTY.SD_NUM = student.sd_num and SUBSPECIALTY.d_num = student.d_num and (M_DATE is not null and MA_DATE is null) and SUBSPECIALTY.D_NUM = ?");
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				SubspecialtyDataBean data = new SubspecialtyDataBean();
				data.setSp_no(rs.getInt("sp_no"));
				data.setSd_num(rs.getInt("sd_num"));
				data.setD_num(rs.getString("d_num"));
				data.setD_sub_num(rs.getString("d_sub_num"));
				data.setM_date(rs.getDate("m_date"));
				data.setD_name(rs.getString("d_name"));
				data.setSd_name(rs.getString("sd_name"));
				data.setD_sub_name(rs.getString("d_sub_name"));
				dataList.add(data);
			}while(rs.next());
			
			return dataList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	public List<SubspecialtyDataBean> selectSubspecialtyBf_B(Connection conn,String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubspecialtyDataBean> dataList = new ArrayList<SubspecialtyDataBean>();
		try {
			pstmt = conn.prepareStatement(
					"select sp_no, student.d_num, d.d_name, student.sd_num, student.sd_name, SUBSPECIALTY.d_sub_num, d_sub.d_name d_sub_name, SUBSPECIALTY.dm_date from SUBSPECIALTY,student,department d,department d_sub where  d.d_num = student.d_num and d_sub.d_num = SUBSPECIALTY.d_sub_num and SUBSPECIALTY.SD_NUM = student.sd_num and SUBSPECIALTY.d_num = student.d_num and (DM_DATE is not null and A_DATE is null) and SUBSPECIALTY.D_NUM = ?");
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				SubspecialtyDataBean data = new SubspecialtyDataBean();
				data.setSp_no(rs.getInt("sp_no"));
				data.setSd_num(rs.getInt("sd_num"));
				data.setD_num(rs.getString("d_num"));
				data.setD_sub_num(rs.getString("d_sub_num"));
				data.setDm_date(rs.getDate("dm_date"));
				data.setD_name(rs.getString("d_name"));
				data.setSd_name(rs.getString("sd_name"));
				data.setD_sub_name(rs.getString("d_sub_name"));
				dataList.add(data);
			}while(rs.next());
			
			return dataList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	public int updateSubspecialty(Connection conn, int SD_NUM, int sp_no,String d_sub_num) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement(
					"update SUBSPECIALTY set MA_DATE = TO_CHAR(SYSDATE,'YYYY-mm-dd') where sd_num = ? and SP_NO = ?");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setInt(1, SD_NUM);
			pstmt.setInt(2, sp_no);
			count = pstmt.executeUpdate();


			pstmt = conn.prepareStatement("update student set SD_SPECIALTY = '1' , d_sub_num = ? where sd_num in(select sd_num from SUBSPECIALTY where SP_NO = ?)");
			pstmt.setString(1, d_sub_num);
			pstmt.setInt(2, sp_no);
			count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	public int updateSubspecialty_B(Connection conn, int SD_NUM, int sp_no,String d_sub_num) {
		PreparedStatement pstmt = null;
		try {
			int count = 0;
			pstmt = conn.prepareStatement(
					"update SUBSPECIALTY set A_DATE = TO_CHAR(SYSDATE,'YYYY-mm-dd') where sd_num = ? and SP_NO = ?");
			// LOA_END_YEAR = ?, LOA_END_SEMESTER = ?
			pstmt.setInt(1, SD_NUM);
			pstmt.setInt(2, sp_no);
			count = pstmt.executeUpdate();


			pstmt = conn.prepareStatement("update student set SD_SPECIALTY = '2' , d_sub_num = ? where sd_num in(select sd_num from SUBSPECIALTY where SP_NO = ?)");
			pstmt.setString(1, d_sub_num);
			pstmt.setInt(2, sp_no);
			count = pstmt.executeUpdate();

			return count;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	//과목관리 select 문
	public List<SubjectDataBean> selectSubject(Connection conn,String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubjectDataBean> dataList = new ArrayList<SubjectDataBean>();
		try {
			pstmt = conn.prepareStatement
					("select * from subject where d_num = ? order by s_num");
					
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return Collections.emptyList();
			}
			do {
				SubjectDataBean data = new SubjectDataBean();
				data.setS_num(rs.getString("s_num"));
				data.setS_name(rs.getString("s_name"));
				data.setD_num(rs.getString("d_num"));
				data.setS_cp_credits(rs.getInt("s_cp_credits"));
				data.setS_cp_division(rs.getString("s_cp_division"));
				dataList.add(data);
			}while(rs.next());
			
			return dataList;
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	//과에 해당하는 과이름 select
	public DepartmentDataBean selectDepartmentDnum(Connection conn,String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DepartmentDataBean data = new DepartmentDataBean();
		try {
			pstmt = conn.prepareStatement(
					"select d_num,d_name from DEPARTMENT where d_num = ?");
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}else{
				data.setD_num(rs.getString("d_num"));
				data.setD_name(rs.getString("d_name"));
				return data;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	//과번호 max값 select 
	//select MAX(s_num) s_num from subject where s_num like 'AA%';
	public SubjectDataBean selectSubjectMax(Connection conn, String s_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectDataBean data = new SubjectDataBean();
		try {
			pstmt = conn.prepareStatement(
					"select MAX(s_num) s_num from subject where s_num like '"+s_num+"%'");

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}else{
				data.setS_num(rs.getString("s_num"));
				return data;
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
	}
	//과목등록 insert문
	//INSERT INTO SUBJECT VALUES(SEQ_SUBJECT.NEXTVAL,'AA001','논리와비판적사고','교선',3,'00');
	public int insertSubject(Connection conn, String s_num, String s_name,String s_cp_division, int s_cp_credits, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO SUBJECT VALUES(SEQ_SUBJECT.NEXTVAL,?,?,?,?,?)");
			pstmt.setString(1,s_num);
			pstmt.setString(2,s_name);
			pstmt.setString(3,s_cp_division);
			pstmt.setInt(4,s_cp_credits);
			pstmt.setString(5,d_num);

			count = pstmt.executeUpdate();
			return count;
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	//과목 삭제
	public int deleteSubject(Connection conn, String s_num, String d_num) throws SQLException {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(
					"delete from SUBJECT where s_num = ? and d_num = ?");
			pstmt.setString(1,s_num);
			pstmt.setString(2,d_num);
			count = pstmt.executeUpdate();
			return count;
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
	
}
