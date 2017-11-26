package professor.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.jdbcUtil;
import professor.DTO.ProfessorDataBean;

public class ProfessorDao {
	private static ProfessorDao instance = new ProfessorDao();

	public static ProfessorDao getInstance() {
		return instance;
	}

	private ProfessorDao() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
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
	
	// ecaluationForm.jsp 개설년도/학기 검색
		public List<Professor_All_DataBean> getYearSemester(String id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Professor_All_DataBean> articleList = null;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement(
						"select DISTINCT cp_year,cp_semester from classplan where pf_num = ? ORDER BY cp_year desc,cp_semester desc");

				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					articleList = new ArrayList();
					do {
						Professor_All_DataBean article = new Professor_All_DataBean();

						article.setCp_year(rs.getString("CP_YEAR"));
						article.setCp_semester(rs.getString("cp_semester"));
						articleList.add(article);
					} while (rs.next());
				}
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
			return articleList;
		}

	// ecaluationForm.jsp
	public List<Professor_All_DataBean> getEcaluationlist(String id, String cp_year, String cp_semester) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Professor_All_DataBean> articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select CP_YEAR,CP_SEMESTER,D_NAME,CP_NUM,S.S_NUM,S_NAME,S_CP_CREDITS from CLASSPLAN C,SUBJECT S, DEPARTMENT D where C.S_NUM = S.S_NUM and S.D_NUM = D.D_NUM and REGISTRATION = '1' and C.PF_NUM = ? and C.CP_YEAR = ? and C.CP_SEMESTER = ?");

			pstmt.setString(1, id);
			pstmt.setString(2, cp_year);
			pstmt.setString(3, cp_semester);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList();
				do {
					Professor_All_DataBean article = new Professor_All_DataBean();

					article.setCp_year(rs.getString("CP_YEAR"));
					article.setCp_semester(rs.getString("cp_semester"));
					article.setD_name(rs.getString("d_name"));
					article.setCp_num(rs.getInt("cp_num"));
					article.setS_name(rs.getString("s_name"));
					article.setS_num(rs.getString("s_num"));
					article.setS_cp_credits(rs.getInt("s_cp_credits"));
					articleList.add(article);
				} while (rs.next());
			}
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
		return articleList;
	}
	
	//강의평가 점수
	public int getGnum(Connection conn , int cp_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int gnum = 0;
		try{
			pstmt = conn.prepareStatement("select sum(E.e_sum)/count(e_sum) as s_sum from EVALUATION E,CLASSREQUEST CR,CLASSPLAN CP where E.CR_NUM = CR.CR_NUM and CR.CP_NUM = CP.CP_NUM and CP.CP_NUM = ?");			
			pstmt.setInt(1, cp_num);
			rs = pstmt.executeQuery();			 
			if (rs.next()) {
				gnum = rs.getInt("s_sum");
			}	
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
		return gnum;
	}
	
	

	// timetableForm.jsp
	public List<Professor_All_DataBean> getTimelist(String id, String cp_year, String cp_semester) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"SELECT C.CP_SEMESTER,S.S_CP_DIVISION,S.S_NAME,C.CP_TIME,C.CR_NUM, C.CP_YEAR FROM CLASSPLAN C,SUBJECT S WHERE C.S_NUM = S.S_NUM and REGISTRATION = '1' and C.PF_NUM = ? and CP_YEAR = ? and CP_SEMESTER = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, cp_year);
			pstmt.setString(3, cp_semester);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList();
				do {
					Professor_All_DataBean article = new Professor_All_DataBean();
					article.setCp_semester(rs.getString("cp_semester"));
					article.setS_cp_division(rs.getString("s_cp_division"));
					article.setS_name(rs.getString("s_name"));
					article.setCp_time(rs.getString("cp_time"));
					article.setCr_num(rs.getString("cr_num"));
					article.setCp_year(rs.getString("cp_year"));
					articleList.add(article);
				} while (rs.next());
			}
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
		return articleList;
	}

	// graadeForm.jsp 성적관리

	public List<Professor_All_DataBean> getGradelist(String id, String cp_year, String cp_semester) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT C.PF_NUM,C.CP_NUM,C.CP_YEAR,C.CP_SEMESTER,S.S_CP_DIVISION,S.S_NAME,C.CP_TIME,C.CR_NUM"
					+ " FROM CLASSPLAN C,SUBJECT S WHERE C.S_NUM = S.S_NUM and REGISTRATION = '1' and C.PF_NUM = ? and C.CP_YEAR = ? and C.CP_SEMESTER = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, cp_year);
			pstmt.setString(3, cp_semester);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList();
				do {
					Professor_All_DataBean article = new Professor_All_DataBean();
					article.setPf_num(rs.getString("PF_NUM"));
					article.setCp_num(rs.getInt("CP_NUM"));
					article.setCp_year(rs.getString("CP_YEAR"));
					article.setCp_semester(rs.getString("CP_SEMESTER"));
					article.setS_cp_division(rs.getString("S_CP_DIVISION"));
					article.setS_name(rs.getString("S_NAME"));
					article.setCp_time(rs.getString("CP_TIME"));
					article.setCr_num(rs.getString("CR_NUM"));
					articleList.add(article);
				} while (rs.next());
			}
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
		return articleList;
	}
	
	
	public List<Professor_All_DataBean> getGradeProlist(String id,int cp_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT C.PF_NUM,C.CP_NUM,C.CP_SEMESTER,S.S_CP_DIVISION,S.S_NAME,C.CP_TIME,C.CR_NUM FROM CLASSPLAN C,SUBJECT S WHERE C.S_NUM = S.S_NUM and C.PF_NUM = ? and C.cp_num = ?");
			pstmt.setString(1, id);
			pstmt.setInt(2, cp_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList();
				do {
					Professor_All_DataBean article = new Professor_All_DataBean();
					article.setPf_num(rs.getString("PF_NUM"));
					article.setCp_num(rs.getInt("CP_NUM"));
					article.setCp_semester(rs.getString("CP_SEMESTER"));
					article.setS_cp_division(rs.getString("S_CP_DIVISION"));
					article.setS_name(rs.getString("S_NAME"));
					article.setCp_time(rs.getString("CP_TIME"));
					article.setCr_num(rs.getString("CR_NUM"));
					articleList.add(article);
				} while (rs.next());
			}
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
		return articleList;
	}
	
	public List<Professor_All_DataBean> StudentGradelist(int cp_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select S.sd_num, S.sd_name, C.g_sum, C.CR_NUM from STUDENT S,CLASSREQUEST C where S.sd_num = C.sd_num and C.CP_NUM = ?");
			pstmt.setInt(1, cp_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList();
				do {
					Professor_All_DataBean article = new Professor_All_DataBean();
					article.setSd_num(rs.getInt("sd_num"));
					article.setSd_name(rs.getString("sd_name"));
					article.setG_sum(rs.getString("g_sum"));
					article.setCr_num(rs.getString("CR_NUM"));
					articleList.add(article);
				} while (rs.next());
				

			}
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
		return articleList;
	}


	//성적변경 배열
	public int GradeUpdate(String g_sum,int cr_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("Update CLASSREQUEST set g_sum = ? where CR_NUM = ?");
			pstmt.setString(1, g_sum);
			pstmt.setInt(2, cr_num);
			
			count = pstmt.executeUpdate();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
		return count;
	}
	
	
	/****************개인정보 부분***************/
	public int Pre_modifyCheck(Connection conn , String pf_num, String pf_passwd) throws SQLException{

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd="";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1
		
		try{
			pstmt = conn.prepareStatement("select pf_passwd from professor where pf_num = ?"); // 입력한 전달받은 id와 일치하는 passwd를 꺼내온다.
			pstmt.setString(1, pf_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("pf_passwd"); // rs객체의 getString()메소드로 해당하는 컬럼명("passwd")의 쿼리의 결과값을 String타입으로 dbpasswd변수에 저장한다. 
				
				if(dbpasswd.equals(pf_passwd)){ // db에 저장된 암호(dbpasswd)와 사용자가 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				}
				else{ 
					x = 0; 
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서 레코드가 변하지 않음. 경우의 수 x=0 저장.
			}
			else{ // 테이블에 레코드값이 존재하지 않을 경우,
				x = -1; 
				} // 해당 아이디 없음 // 경우의 수 x=-1 저장.
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();} catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();} catch(SQLException ex){}
			if(conn!=null) try{conn.close();} catch(SQLException ex){}
		}
		return x; // x에 저장된 값 리턴.
	}
	
	//교수 개인정보 수정
	
	public void UpdateRegister_modify(Connection conn, String id, String pf_passwd,String pf_hpone,String pf_address,String pf_email ) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update professor set pf_passwd =?, pf_hpone =?, pf_address =? ,pf_email =? where pf_num =?");
			pstmt.setString(1,pf_passwd);
			pstmt.setString(2,pf_hpone);
			pstmt.setString(3,pf_address);
			pstmt.setString(4,pf_email);
			pstmt.setString(5,id);
			
			pstmt.executeUpdate();
			

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}

	
	//교수 개인정보 조회

	public ProfessorDataBean selectRegister_modify(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfessorDataBean item = null;
		/*List<StudentDataBean> itemlist = new ArrayList<StudentDataBean>();*/
		try {
			pstmt = conn.prepareStatement("select pf_num,pf_name,pf_passwd,pf_jumin,pf_hpone,pf_address,pf_email from professor where pf_num = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return item;
			} else {
				item = new ProfessorDataBean(); 
				item.setPf_passwd(rs.getString("pf_passwd"));
				item.setPf_num(rs.getString("pf_num"));
				item.setPf_name(rs.getString("pf_name"));
				item.setPf_jumin(rs.getDate("pf_jumin"));
				item.setPf_hpone(rs.getString("pf_hpone"));
				item.setPf_address(rs.getString("pf_address"));
				item.setPf_email(rs.getString("pf_email"));
			}
			return item;

		} catch (SQLException e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(pstmt);
		}
	}
}