package admin.Service;



	import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.ProfessorDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

	public class SelectProfessorListService {
	private static SelectProfessorListService instance = new SelectProfessorListService();
		
		public static SelectProfessorListService getInstance(){
			return instance;
		}
		private SelectProfessorListService(){}
		
		public List<ProfessorDataBean> getItemList(String d_name){
//(String pf_num)
			AdminDao adminDao = AdminDao.getInstance();
			Connection conn = null;
			try{
				conn = ConnectionProvider.getConnection();
				List<ProfessorDataBean> ItemList = adminDao.selectProfessor_All(conn, d_name);
				return ItemList;
			}catch(SQLException e){
				throw new RuntimeException("DB 에러:"+e.getMessage(), e);
			}finally{
				jdbcUtil.close(conn);
			}
		}
		
	}
