package professor.Service;

import java.sql.Connection;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;
import professor.DAO.Professor_All_DataBean;

public class GraderProService {
	private static GraderProService instance = new GraderProService();

	public static GraderProService getInstance() {

		return instance;
	}

	private GraderProService() {
	}

	public List<Professor_All_DataBean> getItemList(String id, int cp_num) throws Exception {
		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			List<Professor_All_DataBean> ItemList = LmsDao.getGradeProlist(id, cp_num);
			return ItemList;
		} catch (Exception e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(conn);
		}
	}

	public List<Professor_All_DataBean> getItemList(int cp_num) throws Exception {
		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			List<Professor_All_DataBean> ItemList = LmsDao.StudentGradelist(cp_num);
			return ItemList;
		} catch (Exception e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(conn);
		}
	}

	public int getGradeList(String g_sum, int cr_num) throws Exception {
		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			int GradeUpdate = LmsDao.GradeUpdate(g_sum, cr_num);
			return GradeUpdate;
		} catch (Exception e) {
			throw new RuntimeException("DB 에러:" + e.getMessage(), e);
		} finally {
			jdbcUtil.close(conn);
		}
	}

}
