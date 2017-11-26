package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.ReinstatementDataBean;

// 휴복학 테이블에서 제일 최근에 휴학 신청한 날짜 select service
public class SelectReinstatementService {
	private static SelectReinstatementService instance = new SelectReinstatementService();
	
	public static SelectReinstatementService getInstance(){
		return instance;
	}
	private SelectReinstatementService(){}
	public ReinstatementDataBean getItem(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ReinstatementDataBean item = studentDao.selectReinstatement(conn, id);
			return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
