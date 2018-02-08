package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import java.security.Provider.Service;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

public class StudentServiceTest {
	private static StudentService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@After
	public void tearDown() throws Exception {
		service=null;
	}

	@Test
	public void test() {
		Student student = service.findStudentByNo(new Student(1));
		Assert.assertNotNull(student);
	}

}
