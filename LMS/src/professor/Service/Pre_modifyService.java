package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;


public class Pre_modifyService {
private static Pre_modifyService instance = new Pre_modifyService();
	
	public static Pre_modifyService getInstance(){
		return instance;
	}
	private Pre_modifyService(){}
	public int professorCheck(String pf_num,String pf_passwd){

		ProfessorDao professorDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = professorDao.Pre_modifyCheck(conn, pf_num, pf_passwd);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}

	}

