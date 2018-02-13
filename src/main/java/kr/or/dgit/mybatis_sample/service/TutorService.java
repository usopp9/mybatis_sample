package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;

public class TutorService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.TutorDao.";
	
	
	public Tutor findTutorByNoWithAPI(Tutor tutor) {
		log.debug("findTutorByNoWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectTutorByTutorId", tutor);
		}
	}
}
