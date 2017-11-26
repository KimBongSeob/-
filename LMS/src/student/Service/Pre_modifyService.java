package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class Pre_modifyService {
private static Pre_modifyService instance = new Pre_modifyService();
	
	public static Pre_modifyService getInstance(){
		return instance;
	}
	private Pre_modifyService(){}
	public int studentCheck(int sd_num,String sd_passwd){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.Pre_modifyCheck(conn, sd_num, sd_passwd);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}

	}

