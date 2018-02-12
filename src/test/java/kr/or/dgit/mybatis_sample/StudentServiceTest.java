package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
	public void test1FindStudentByNoWithAPI() {
		Student student = service.findStudentByNoWithAPI(new Student(1));
		Assert.assertNotNull(student);
	}

	@Test
	public void test2FindStudentByAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}

	@Test
	public void test3CreateStudentWithAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);

        Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
        int res = service.createStudentWithAPI(student);
        Assert.assertEquals(1, res);
	}
	@Test
	public void test4UpdateStudentWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988,04,25).getTime());		
		int res = service.updateStudentWithAPI(student);
        Assert.assertSame(1, res);
	}
	@Test
	public void test5DeleteStudentWithAPI() {
		int deleteStudent = service.deleteStudent(3);
        Assert.assertSame(1, deleteStudent);
	}
	@Test
	public void test6SelectStudentByAllWithAPIForResultMap() {
		List<Student> lists = service.selectStudentByAllWithAPIForResultMap();
		List<Student> lists2 = service.findStudentByAllWithAPI();
		Assert.assertSame(lists.size(), lists2.size());
	}
	@Test
	public void test7selectStudentByAllWithAPIForMap() {
		List<Map<String,Object>> listMaps = service.selectStudentByAllWithAPIForMap();
		List<Student> lists2 = service.findStudentByAllWithAPI();
		Assert.assertSame(listMaps.size(), lists2.size());
		
		for(Map<String,Object> map: listMaps) {
			for(Entry<String,Object> e : map.entrySet()) {
				System.out.printf("key %s => value %s %n",e.getKey(),e.getValue());
			}
		}
	}
	@Test
	public void test8SelectStudentByNoForResultMapExtendsWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		Student extStd = service.selectStudentByNoForResultMapExtendsWithAPI(student);
		Student extStd1 = service.findStudentByNoWithAPI(new Student(1));
        Assert.assertEquals(extStd.getStudId(), extStd1.getStudId());
	}
}
