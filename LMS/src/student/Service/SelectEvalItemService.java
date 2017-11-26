package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.EvaluationItemDataBean;

public class SelectEvalItemService {
private static SelectEvalItemService instance = new SelectEvalItemService();
	
	public static SelectEvalItemService getInstance(){
		return instance;
	}
	private SelectEvalItemService(){}
	
	
	public EvaluationItemDataBean getEvalItem1(int sd_num, int cr_num){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			EvaluationItemDataBean Item = studentDao.selectEvalItem1(conn, sd_num, cr_num);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	public List<EvaluationItemDataBean> getEvalItem2(int sd_num, int cr_num, int e_sum){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<EvaluationItemDataBean> ItemList = studentDao.selectEvalItem2(conn, sd_num, cr_num, e_sum);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
