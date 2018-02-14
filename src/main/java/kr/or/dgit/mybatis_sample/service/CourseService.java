package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.CourseDao;
import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;


public class CourseService {
	private static final Log log = LogFactory.getLog(CourseService.class);
	
	public List<Course> selectCoursesByCondition(Map<String, Object> map) {
		log.debug("selectCoursesByCondition()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectCoursesByCondition(map);
		}
	}
	public List<Course> selectCaseCourses(Map<String, Object> map) {
		log.debug("selectCaseCourses()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectCaseCourses(map);
		}
	}
	public List<Course> selectWhereCourses(Map<String, Object> map) {
		log.debug("selectWhereCourses()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectWhereCourses(map);
		}
	}
	public List<Course> selectTrimCourses(Map<String, Object> map) {
		log.debug("selectTrimCourses()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectTrimCourses(map);
		}
	}
	public List<Course> selectCoursesForeachByTutors(Map<String, Object> map) {
		log.debug("selectCoursesForeachByTutors()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectCoursesForeachByTutors(map);
		}
	}
}
