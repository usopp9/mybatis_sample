package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;



public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.UserPicDao.";

	public int createUserPic(UserPic userPic) {
		log.debug("insertUserPicWithAPI()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertUserPicWithAPI", userPic);
			sqlSession.commit();
			return res;
		}
	}
	
	public UserPic selectgetUserPic(UserPic userPic) {
		log.debug("selectgetUserPic()");
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "getUserPicWithAPI", userPic);
		}
	}


}
