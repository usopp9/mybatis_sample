package kr.or.dgit.mybatis_sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;


public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";

	public Student findStudentByNoWithAPI(Student student) {
		log.debug("findStudentByNoWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoWithAPI", student);
		}
	}

	public List<Student> findStudentByAllWithAPI() {
		log.debug("findStudentByAllWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPI");
		}
	}

	public int createStudentWithAPI(Student student) {
		log.debug("createStudentWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	public int createEnumStudentWithAPI(Student student) {
		log.debug("createEnumStudentWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertEnumStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	public int updateStudentWithAPI(Student student) {
		log.debug("updateStudentWithAPI()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			int res = sqlSession.update(namespace + "updateStudentWithAPI", student);
			sqlSession.commit();
			return res;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	public int deleteStudent(int id) {
		log.debug("deleteStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			int res = sqlSession.delete(namespace + "deleteStudent", id);
			sqlSession.commit();
			return res;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	public List<Student> selectStudentByAllWithAPIForResultMap() {
		log.debug("selectStudentByAllForResultMap()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllWithAPIForResultMap();
		}
	}
	public List<Map<String,Object>> selectStudentByAllWithAPIForMap(){
		log.debug("selectStudentByAllWithAPIForMap()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPIForMap");
		}
	}
	public Student selectStudentByNoForResultMapExtendsWithAPI(Student student) {
		log.debug("selectStudentByNoForResultMapExtendsWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectOne(namespace + "selectStudentByNoForResultMapExtendsWithAPI", student);
		}
	}
	public Student selectStudentByNoAssociationWithAPI(Student student) {
		log.debug("selectStudentByNoAssociationWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectOne(namespace + "selectStudentByNoAssociationWithAPI", student);
		}
	}
	public Student findAllStudentByStudentWithAPI(Student student) {
		log.debug("findAllStudentByStudentWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectOne(namespace + "selectAllStudentByStudentWithAPI", student);
		}
	}
	public Student findAllStudentByMapWithAPI(Map<String,String> map) {
		log.debug("findAllStudentByMapWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectOne(namespace + "selectAllStudentByMapWithAPI", map);
		}
	}
	public Map<Integer, String> selectStudentForMapWithAPI() {
		log.debug("selectStudentForMapWithAPI()");
		Map<Integer, String> map = new HashMap<>();
        ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
            @Override
            public void handleResult(ResultContext<? extends Student> resultContext) {
                Student student = resultContext.getResultObject();
                map.put(student.getStudId(), student.getName());                
            }
        };

		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			sqlSession.select(namespace + "selectStudentForMapWithAPI", resultHandler);
			return map;
		}
	}
}
