package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

//수강신청 delete service
public class DeleteClassbasketService {
	private static DeleteClassbasketService instance = new DeleteClassbasketService();
	
	public static DeleteClassbasketService getInstance(){
		return instance;
	}
	private DeleteClassbasketService(){}
	public int delItem(int cp_num,int sd_num){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.deleteClassbasket(conn, cp_num, sd_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
