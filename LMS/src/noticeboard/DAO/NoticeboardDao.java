package noticeboard.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import noticeboard.DTO.NoticeboardDataBean;

public class NoticeboardDao {

	private static NoticeboardDao instance = new NoticeboardDao();

	public static NoticeboardDao getInstance() {
		return instance;
	}

	private NoticeboardDao() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// loginPro.jsp
	public int studentCheck(String sd_num, String sd_passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select sd_passwd from student where sd_num = ?"); // 입력한 전달받은 id와 일치하는
																								// passwd를 꺼내온다.
			pstmt.setString(1, sd_num);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("sd_passwd"); // rs객체의 getString()메소드로 해당하는 컬럼명("passwd")의 쿼리의 결과값을 String타입으로
														// dbpasswd변수에 저장한다.

				if (dbpasswd.equals(sd_passwd)) { // db에 저장된 암호(dbpasswd)와 사용자가 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				} else {
					x = 0;
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서 레코드가 변하지 않음. 경우의 수
					// x=0 저장.
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
	public int professorCheck(String pf_num, String pf_passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select pf_passwd from professor where pf_num = ?"); // 입력한 전달받은 id와 일치하는
																								// passwd를 꺼내온다.
			pstmt.setString(1, pf_num);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 테이블에 다음 레코드값이 존재할 경우,
				dbpasswd = rs.getString("pf_passwd"); // rs객체의 getString()메소드로 해당하는 컬럼명("passwd")의 쿼리의 결과값을 String타입으로
														// dbpasswd변수에 저장한다.
				if (dbpasswd.equals(pf_passwd)) { // db에 저장된 암호(dbpasswd)와 사용자가 입력한 암호(passwd)가 같다면,
					x = 1; // 인증 성공 // 레코드 1줄 변경됨 // 경우의 수 x=1 저장.
				} else {
					x = 0;
				} // 비밀번호 틀림 // 레코드의 변동이 없다. 즉, 0 // 입력한 암호와 db에 저장된 암호가 달라서 레코드가 변하지 않음. 경우의 수
					// x=0 저장.
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

	// writePro.jsp
	public void insertArticle(NoticeboardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// �떟蹂�湲��씤吏� �씪諛섍��씤吏�瑜� 援щ텇�빐�꽌 �엯�젰�떆耳쒖＜�뒗 濡쒖쭅!!!
		int num = article.getNum();
		int number = 0;
		String sql = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select max(num) from NOTICEBOARD");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;
			sql = "insert into NOTICEBOARD(num,writer,subject,reg_date,";
			sql += "content) values(SEQ_BOARD.NEXTVAL,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setTimestamp(3, article.getReg_date());
			pstmt.setString(4, article.getContent());

			pstmt.executeUpdate();
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
	}

	// list.jsp : �럹�씠吏뺤쓣 �쐞�빐�꽌 �쟾泥� DB�뿉 �엯�젰�맂 �뻾�쓽�닔媛� �븘�슂�븯�떎...!!!
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from NOTICEBOARD");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
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
		return x;
	}

	// list.jsp ==> Paging!!! DB濡쒕��꽣 �뿬�윭�뻾�쓣 寃곌낵濡� 諛쏅뒗�떎.
	public List getArticles(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select * from (select num,writer,subject,reg_date,content,readcount,rownum r "
					+ "from (select num,writer,subject,reg_date,content,readcount from noticeboard order by num desc)) where r>=? and r<=? order by num desc");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					NoticeboardDataBean article = new NoticeboardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setSubject(rs.getString("subject"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setContent(rs.getString("content"));
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

	// read.jsp : DB濡쒕��꽣 �븳以꾩쓽 �뜲�씠�꽣瑜� 媛��졇�삩�떎.
	public NoticeboardDataBean getArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeboardDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update NOTICEBOARD set readcount=readcount+1 where num = ?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from NOTICEBOARD where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new NoticeboardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setContent(rs.getString("content"));
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
		return article;
	}

	// updateForm.jsp : �닔�젙�뤌�뿉 �븳以꾩쓽 �뜲�씠�꽣瑜� 媛��졇�삱�븣.
	public NoticeboardDataBean updateGetArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeboardDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from NOTICEBOARD where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new NoticeboardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				// article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				// article.setPasswd(rs.getInt("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				// article.setRef(rs.getInt("ref"));
				// article.setRe_step(rs.getInt("re_step"));
				// article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				// article.setIp(rs.getString("ip"));
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
		return article;
	}

	// updatePro.jsp : �떎�젣 �뜲�씠�꽣瑜� �닔�젙�븯�뒗 硫붿냼�뱶.
	public int updateArticle(NoticeboardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = "";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select writer from NOTICEBOARD where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("writer");
				if (dbpasswd.equals(article.getWriter())) {
					sql = "update NOTICEBOARD set writer=?,subject=?";
					sql += ",content=? where num=?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, article.getWriter());
					// pstmt.setString(2, article.getEmail());
					pstmt.setString(2, article.getSubject());
					// pstmt.setInt(3, article.getPasswd());
					pstmt.setString(3, article.getContent());
					pstmt.setInt(4, article.getNum());
					pstmt.executeUpdate();
					x = 1;
				} else {
					x = 0;
				}
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
		return x;
	}

	// deletePro.jsp : �떎�젣 �뜲�씠�꽣瑜� �궘�젣�븯�뒗 硫붿냼�뱶...
	public int deleteArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 1;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("delete from NOTICEBOARD where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			x = 1; // 湲��궘�젣 �꽦怨�

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
		return x;
	}

	// 게시판 검색기능
	
		 public int getArticleCount(int n, String searchKeyword) throws Exception {
			  // option value 값 0,1,2 중 하나를 매개변수로 넘겨받음. 검색한 문자열을 넘겨받음.
			  Connection conn = null;
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			  String[] column_name = { "writer", "subject", "content" };
			  // option value 값과 배열의 인덱스를 동일하게 저장한다. 0, 1, 2
			  int x = 0;
			  try {
			   conn = getConnection();
			   pstmt = conn.prepareStatement(
			     "select count (*) from NOTICEBOARD where " + column_name[n] + " like '%" + searchKeyword + "%'");
			   // 여기 쿼리문에서는 배열과 문자열을 넣어 주기 때문에 물음표를 넣으면 안된다.
			   rs = pstmt.executeQuery();
			   if (rs.next())
			    x = rs.getInt(1); // 첫 번째 레코드값을 꺼내와서 x에 저장한다. = count값
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
			  return x;
			 }

	public List getArticles(int start, int end, int n, String searchKeyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;

		String[] column_name = { "writer", "subject", "content" };

		try {
			conn = getConnection();

			String sql = "select num,writer,subject,reg_date,content,readcount,r "
					+ "from (select num,writer,subject,reg_date,content,readcount,rownum r "
					+ "from (select num,writer,subject,reg_date,content,readcount "
					+ "from noticeboard order by num desc) where " + column_name[n] + " like '%" + searchKeyword
					+ "%') where r >= ? and r <= ? order by num desc";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);

				do {
					NoticeboardDataBean article = new NoticeboardDataBean(); // next()濡� 寃��깋�맂
																	// �젅肄붾뱶蹂꾨줈 媛곴컖�쓽
																	// BoardDataBean媛앹껜瑜�
																	// 留뚮뱾寃� �맂�떎.

					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					//article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
				//	article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					//article.setRef(rs.getInt("ref"));
					//article.setRe_step(rs.getInt("re_step"));
					//article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					//article.setIp(rs.getString("ip"));

					articleList.add(article);
				} while (rs.next()); // next()濡� 寃��깋�맂 �젅肄붾뱶蹂꾨줈 媛곴컖�쓽 BoardDataBean媛앹껜瑜�
										// 留뚮뱾寃� �맂�떎.

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

	}