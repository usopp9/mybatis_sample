package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
}
