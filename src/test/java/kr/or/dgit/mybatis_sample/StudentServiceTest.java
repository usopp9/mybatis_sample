package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;
import kr.or.dgit.mybatis_sample.type.Gender;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
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
		for(Student std : listStd) {
			System.out.println(std);
		}
	}

	@Test
	public void test3CreateStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);

        Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
        int res = service.createStudent(student);
        Assert.assertEquals(1, res);
	}
	@Test
	public void test4UpdateStudent() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());		
		int res = service.updateStudent(student);
        Assert.assertEquals(1, res);
	}
	@Test
	public void test5deleteStudent() {
		
		int deleteStudent = service.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	@Test
	public void test6FindStudentByAllForHashMap() {
		List<Map<String,Object>> listMap = service.findStudentByAllForHashMap();
		List<Student> list2 = service.findStudentByAll();
		Assert.assertSame(listMap.size(), list2.size());
		
		for(Map<String,Object> map: listMap) {
			for(Entry<String,Object> e : map.entrySet()) {
				System.out.printf("key %s => value %s %n",e.getKey(),e.getValue());
			}
		}
	}
	@Test
	public void test7SelectStudentByNoForResultMapExtends() {
		Student student = new Student();
		student.setStudId(1);
		
		Student extStd = service.selectStudentByNoForResultMapExtends(student);
		Student extStd1 = service.findStudentByNo(new Student(1));
		
		 Assert.assertEquals(extStd.getStudId(), extStd1.getStudId());
	}
	@Test
	public void test8SelectStudentByNoAssociation() {
		Student searchStd = new Student(1);
		Student student = service.selectStudentByNoAssociation(searchStd);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	@Test
	public void test9CreateEnumStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);

        Student student = new Student(4, "홍길동4", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
        student.setGender(Gender.MALE);
        int res = service.createEnumStudent(student);
        Assert.assertEquals(1, res);
        System.out.println(student);
	}
	@Test
	public void testAFindAllStudentByParam() {
		Student student = service.findAllStudentByParam("Timothy", "test@test.co.kr");
		Assert.assertNotNull(student);
	}
	@Test
	public void testBFindAllStudentByStudent() {
		Student std = new Student();
		std.setName("Timothy");
		std.setEmail("test@test.co.kr");
		Student student = service.findAllStudentByStudent(std);
		Assert.assertNotNull(student);
	}
	@Test
	public void testCFindAllStudentByMap() {
		Map<String,String> map = new HashMap<>();
		map.put("name", "Timothy");
		map.put("email", "test@test.co.kr");
		Student student = service.findAllStudentByMap(map);
		Assert.assertNotNull(student);
	}
}
