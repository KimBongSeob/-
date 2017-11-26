package student.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class UpdateReinstatementService {
	private static UpdateReinstatementService instance = new UpdateReinstatementService();
	
	public static UpdateReinstatementService getInstance(){
		return instance;
	}
	// 복학 신청 update service
	private UpdateReinstatementService(){}
	public int setLoa(int id,Date LOA_A_DATE){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.updateReinstatementLOA(conn, id, LOA_A_DATE);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	// 휴학신청 update service
	public int setLoaExtension(int id,Date LOA_A_DATE,String LOA_END_YEAR,String LOA_END_SEMESTER){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.updateReinstatementLoaExtension(conn, id, LOA_A_DATE,LOA_END_YEAR,LOA_END_SEMESTER);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
