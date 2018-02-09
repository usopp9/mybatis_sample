package kr.or.dgit.mybatis_sample;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service=null;
	}

	@Test
	public void test1FindStudentByNo() {
		Student student = service.findStudentByNo(new Student(1));
		Assert.assertNotNull(student);
	}
	@Test
	public void test2FindStudentByAll() {
		List<Student> listStd = service.findStudentByAll();
		Assert.assertNotNull(listStd);
		for(Student std: listStd) {
			System.out.println(std);
		}
	}
	@Test
	public void test3FindStudentByNoWithAPI() {
		Student student = service.findStudentByNoWithAPI(new Student(1));
		Assert.assertNotNull(student);
	}
	@Test
	public void test4FindStudentByAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		Assert.assertNotNull(listStd);
		for(Student std: listStd) {
			System.out.println(std);
		}
	}
}
