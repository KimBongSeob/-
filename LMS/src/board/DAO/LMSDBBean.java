package board.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.DTO.Mvc_BoardDataBean;


public class LMSDBBean{	
	private static LMSDBBean instance = new LMSDBBean();
	public static LMSDBBean getInstance() {
		return instance;
	}
	private LMSDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	// writePro.jsp
		public void insertArticle(Mvc_BoardDataBean article) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// 답변글인지 일반글인지를 구분해서 입력시켜주는 로직!!!
			int num = article.getNum();
			int ref = article.getRef();
			int re_step = article.getRe_step();
			int re_level = article.getRe_level();
			int number = 0;
			String sql = "";

			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select max(num) from MVC_BOARD");
				rs = pstmt.executeQuery();

				if (rs.next())
					number = rs.getInt(1) + 1;
				else
					number = 1;

				if (num != 0) {
					sql = "update MVC_BOARD set re_step=re_step+1 where ref= ? and re_step> ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, ref);
					pstmt.setInt(2, re_step);
					pstmt.executeUpdate();
					re_step = re_step + 1;
					re_level = re_level + 1;
				} else {
					ref = number;
					re_step = 0;
					re_level = 0;
				}
				// 쿼리를 작성
				if(!article.getFilename().equals("")){
				sql = "insert into MVC_BOARD(num,writer,subject,passwd,reg_date,";
				sql += "ref,re_step,re_level,content,FILENAME,REALPATH,FILESIZE) values(SEQ_BOARD.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getWriter());
				pstmt.setString(2, article.getSubject());
				pstmt.setString(3, article.getPasswd());
				pstmt.setTimestamp(4, article.getReg_date());
				pstmt.setInt(5, ref);
				pstmt.setInt(6, re_step);
				pstmt.setInt(7, re_level);
				pstmt.setString(8, article.getContent());
				pstmt.setString(9, article.getFilename());
				pstmt.setString(10, article.getRealpath());
				pstmt.setLong(11, article.getFilesize());
				}else{
					sql = "insert into MVC_BOARD(num,writer,subject,passwd,reg_date,";
					sql += "ref,re_step,re_level,content)  values(SEQ_BOARD.NEXTVAL,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getSubject());
					pstmt.setString(3, article.getPasswd());
					pstmt.setTimestamp(4, article.getReg_date());
					pstmt.setInt(5, ref);
					pstmt.setInt(6, re_step);
					pstmt.setInt(7, re_level);
					pstmt.setString(8, article.getContent());
				}

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

		// list.jsp : 페이징을 위해서 전체 DB에 입력된 행의수가 필요하다...!!!
		public int getArticleCount() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int x = 0;

			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select count(*) from MVC_BOARD");
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

		// list.jsp ==> Paging!!! DB로부터 여러행을 결과로 받는다.
		public List getArticles(int start, int end) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList = null;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement(
						"select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,FILENAME,REALPATH,FILESIZE,readcount,r  "
								+ "from (select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,FILENAME,REALPATH,FILESIZE,readcount,rownum r "
								+ "from (select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,FILENAME,REALPATH,FILESIZE,readcount "
								+ "from MVC_BOARD order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					articleList = new ArrayList(end);
					do {
						Mvc_BoardDataBean article = new Mvc_BoardDataBean();
						article.setNum(rs.getInt("num"));
						article.setWriter(rs.getString("writer"));
						article.setSubject(rs.getString("subject"));
						article.setPasswd(rs.getString("passwd"));
						article.setReg_date(rs.getTimestamp("reg_date"));
						article.setReadcount(rs.getInt("readcount"));
						article.setRef(rs.getInt("ref"));
						article.setRe_step(rs.getInt("re_step"));
						article.setRe_level(rs.getInt("re_level"));
						article.setContent(rs.getString("content"));
						article.setFilename(rs.getString("filename"));
						article.setRealpath(rs.getString("realpath"));
						article.setFilesize(rs.getInt("filesize"));



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

		// read.jsp : DB로부터 한줄의 데이터를 가져온다.
		public Mvc_BoardDataBean getArticle(int num) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Mvc_BoardDataBean article = null;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("update MVC_BOARD set readcount=readcount+1 where num = ?");
				pstmt.setInt(1, num);
				pstmt.executeUpdate();

				pstmt = conn.prepareStatement("select * from MVC_BOARD where num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					article = new Mvc_BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("Writer"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setFilename(rs.getString("filename"));
					article.setRealpath(rs.getString("realpath"));
					article.setFilesize(rs.getInt("filesize"));
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

		// updateForm.jsp : 수정폼에 한줄의 데이터를 가져올때.
		public Mvc_BoardDataBean updateGetArticle(int num) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Mvc_BoardDataBean article = null;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select * from MVC_BOARD where num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					article = new Mvc_BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("Writer"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setFilename(rs.getString("filename"));
					article.setRealpath(rs.getString("realpath"));
					article.setFilesize(rs.getInt("filesize"));
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

		// updatePro.jsp : 실제 데이터를 수정하는 메소드.
		public int updateArticle(Mvc_BoardDataBean article) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String dbpasswd = "";
			String sql = "";
			int x = -1;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select passwd from MVC_BOARD where num = ?");
				pstmt.setInt(1, article.getNum());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					dbpasswd = rs.getString("passwd");
					if (dbpasswd.equals(article.getPasswd())) {
						sql = "update MVC_BOARD set Writer=?,subject=?,passwd=?";
						sql += ",content=? where num=?";
						pstmt = conn.prepareStatement(sql);

						pstmt.setString(1, article.getWriter());
						pstmt.setString(2, article.getSubject());
						pstmt.setString(3, article.getPasswd());
						pstmt.setString(4, article.getContent());
						pstmt.setInt(5, article.getNum());
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

		// deletePro.jsp : 실제 데이터를 삭제하는 메소드...
		public int deleteArticle(int num, String passwd) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbpasswd = "";
			int x = -1;
			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select passwd from MVC_BOARD where num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					dbpasswd = rs.getString("passwd");
					if (dbpasswd.equals(passwd)) {
						pstmt = conn.prepareStatement("delete from MVC_BOARD where num=?");
						pstmt.setInt(1, num);
						pstmt.executeUpdate();
						x = 1; // 글삭제 성공
					} else
						x = 0; // 비밀번호 틀림
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
		
		public int getArticleCount(int n, String searchKeyword) throws Exception {
			// option value 값 0,1,2 중 하나를 매개변수로 넘겨받음. 검색한 문자열을 넘겨받음.

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String[] column_name = { "Writer", "subject", "content" };
			// option value 값과 배열의 인덱스를 동일하게 저장한다. 0, 1, 2

			int x = 0;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
						"select count (*) from MVC_BOARD where " + column_name[n] + " like '%" + searchKeyword + "%'");
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

			String[] column_name = { "Writer", "subject", "content" };

			try {
				conn = getConnection();

				String sql = "select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,readcount,r "
						+ "from (select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,readcount,rownum r "
						+ "from (select num,Writer,subject,passwd,reg_date,ref,re_step,re_level,content,readcount "
						+ "from MVC_BOARD order by ref desc, re_step asc) where " + column_name[n] + " like '%" + searchKeyword
						+ "%' order by ref desc, re_step asc ) where r >= ? and r <= ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					articleList = new ArrayList(end);

					do {
						Mvc_BoardDataBean article = new Mvc_BoardDataBean(); // next()로 검색된
																		// 레코드별로 각각의
																		// BoardDataBean객체를
																		// 만들게 된다.

						article.setNum(rs.getInt("num"));
						article.setWriter(rs.getString("Writer"));
						article.setSubject(rs.getString("subject"));
						article.setPasswd(rs.getString("passwd"));
						article.setReg_date(rs.getTimestamp("reg_date"));
						article.setReadcount(rs.getInt("readcount"));
						article.setRef(rs.getInt("ref"));
						article.setRe_step(rs.getInt("re_step"));
						article.setRe_level(rs.getInt("re_level"));
						article.setContent(rs.getString("content"));

						articleList.add(article);
					} while (rs.next()); // next()로 검색된 레코드별로 각각의 BoardDataBean객체를
											// 만들게 된다.

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
		
		
		//login
		public int studentCheck(String Writer, String sd_passwd) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbpasswd="";
			int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1
			
			try{
				conn = getConnection();
				
				pstmt = conn.prepareStatement("select sd_passwd from student where Writer = ?"); // 입력한 전달받은 id와 일치하는 passwd를 꺼내온다.
				pstmt.setString(1, Writer);
				rs = pstmt.executeQuery();
				
				if(rs.next()){ // 테이블에 다음 레코드값이 존재할 경우,
					dbpasswd = rs.getString("sd_passwd"); // rs객체의 getString()메소드로 해당하는 컬럼명("passwd")의 쿼리의 결과값을 String타입으로 dbpasswd변수에 저장한다. 
					
					if(dbpasswd.equals(sd_passwd)){ // db에 저장된 암호(dbpasswd)와 사용자가 입력한 암호(passwd)가 같다면,
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
		

		//loginPro.jsp
			public int professorCheck(String pf_num, String pf_passwd) throws Exception{
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String dbpasswd="";
				int x = -1; // 경우의 수를 저장할 변수 x. 초기값은 -1
				
				try{
					conn = getConnection();
					
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
			
			
			//첨부자료
/*			 public int insert(Connection conn, PdsItem item) throws SQLException {
			        PreparedStatement pstmt = null;
			        Statement stmt = null;
			        ResultSet rs = null;
			        
			        try {
			        	conn = getConnection();
			        	
			            pstmt = conn.prepareStatement("insert into MVC_BOARD (NUM,Writer, filesize )values (?, ?, ?)");
			            pstmt.setString(1, item.getFileName());
			            pstmt.setString(2, item.getRealPath());
			            pstmt.setLong(3, item.getFileSize());
			            int insertedCount = pstmt.executeUpdate();

			           
			            return -1;
			    	}finally{
						if(rs!=null) try{rs.close();} catch(SQLException ex){}
						if(pstmt!=null) try{pstmt.close();} catch(SQLException ex){}
						if(conn!=null) try{conn.close();} catch(SQLException ex){}
					}
			    }*/
			
			
			
			
		
	}


