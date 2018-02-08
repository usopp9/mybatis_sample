package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dao.StudentDaoImpl;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MybatisSqlSessionFactory;

public class StudentService {
	public Student findStudentByNo(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByNo(student);
			
		}
				
	}
}
