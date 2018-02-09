package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;

public class StudentDaoImpl implements StudentDao {	
	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);
	private StudentDao studentDao;
	private SqlSession sqlSession;
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
	public StudentDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		studentDao = sqlSession.getMapper(StudentDao.class);
	}
	@Override
	public Student selectStudentByNo(Student student) {
		log.debug("selectStudentByNo()");		
		return studentDao.selectStudentByNo(student);
	}
	@Override
	public List<Student> selectStudentByAll() {
		log.debug("selectStudentByAll()");		
		return studentDao.selectStudentByAll();
	}
	@Override
	public Student selectStudentByNoWithAPI(Student student) {
		log.debug("selectStudentByNoWithAPI()");		
		return sqlSession.selectOne(namespace + "selectStudentByNoWithAPI", student);
	}
	@Override
	public List<Student> selectStudentByAllWithAPI() {
		log.debug("selectStudentByAllWithAPI()");		
		return sqlSession.selectList(namespace +"selectStudentByAllWithAPI");
	}

}
