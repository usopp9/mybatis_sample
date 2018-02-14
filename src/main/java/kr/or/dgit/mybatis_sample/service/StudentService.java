package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;




public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);


	public Student findStudentByNo(Student student) {
		log.debug("findStudentByNo()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}

	public List<Student> findStudentByAll() {
		log.debug("findStudentByAll()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}


	public int createStudent(Student student) {
		log.debug("createStudent()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.insertStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	public int createEnumStudent(Student student) {
		log.debug("createEnumStudent()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.insertEnumStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateStudent(Student student) {
		log.debug("updateStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try  {	
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.updateStudent(student);
			sqlSession.commit();
			return res;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	public int deleteStudent(int id) {
		log.debug("deleteStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try  {	
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);	
			int res = studentDao.deleteStudent(id);
			sqlSession.commit();
			return res;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	public List<Student> selectStudentByAllForResultMap(){
		log.debug("selectStudentByAllForResultMap()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForResultMap();
		}
	}
	
	public List<Map<String, Object>> findStudentByAllForHashMap(){
		log.debug("findStudentByAllForHashMap()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.findStudentByAllForHashMap();
		}
	}
	public Student selectStudentByNoForResultMapExtends(Student student) {
		log.debug("selectStudentByNoForResultMapExtends()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoForResultMapExtends(student);
		}
	}
	
	public Student selectStudentByNoAssociation(Student student) {
		log.debug("selectStudentByNoAssociation()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAssociation(student);
		}
	}
	public Student findAllStudentByParam(String name,String email) {
		log.debug("findAllStudentByParam()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByParam(name, email);
		}
	}
	public Student findAllStudentByStudent(Student student) {
		log.debug("findAllStudentByStudent()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByStudent(student);
		}
	}
	public Student findAllStudentByMap(Map<String, String> map) {
		log.debug("findAllStudentByMap()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByMap(map);
		}
	}
}
