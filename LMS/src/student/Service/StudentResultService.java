package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.ResultDataBean;

public class StudentResultService {
	private static StudentResultService instance = new StudentResultService();

	public static StudentResultService getInstance(){
		return instance;
	}
	
	private StudentResultService(){}
	
	//?꾨룄,?숆린 議고쉶
	public List<ResultDataBean> yearlist(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ResultDataBean> ItemList = studentDao.yearlist(conn, id);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB ?먮윭:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	//?꾩껜 ?깆쟻議고쉶
	public List<ResultDataBean> studentResultAll(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ResultDataBean> ItemList = studentDao.studentResultAll(conn, id);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB ?먮윭:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	//?꾩껜 ?깆쟻議고쉶
	public List<ResultDataBean> studentResult(int id, String cp_year, String cp_semester){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ResultDataBean> ItemList = studentDao.studentResult(conn, id, cp_year, cp_semester);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB ?먮윭:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
