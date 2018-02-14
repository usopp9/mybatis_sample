package kr.or.dgit.mybatis_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.service.CourseService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceTest {
	private static CourseService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CourseService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1SelectCoursesByCondition() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseName", "%java%");
        List<Course> courses = service.selectCoursesByCondition(map);
        Assert.assertNotNull(courses);
	}

	@Test
	public void test2SelectCoursesByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", cal.getTime());
        cal.set(2013, 06, 01);
        map.put("endDate", cal.getTime());
        
        List<Course> courses = service.selectCoursesByCondition(map);
        Assert.assertNotNull(courses);
	}
	
	@Test
	public void test3SelectCoursesByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013, 7, 1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("endDate", cal.getTime());
       
        List<Course> courses = service.selectCoursesByCondition(map);
        Assert.assertNotNull(courses);
	}
	@Test
	public void test4FindCaseCourses() {
		Map<String,Object> map = new HashMap<>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		List<Course> course = service.selectCaseCourses(map);
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%java%");
		course = service.selectCaseCourses(map);
        Assert.assertNotNull(course);
	}
	@Test
	public void test5FindWhereCourses() {
		 Map<String, Object> map = new HashMap<String, Object>();

	        List<Course> courses = service.selectWhereCourses(map);
	        Assert.assertNotNull(courses);

	        map.put("tutorId", 1);
	        courses = service.selectWhereCourses(map);
	        Assert.assertNotNull(courses);

	        map.put("courseName", "%java%");
	        courses = service.selectWhereCourses(map);

	        map.clear();
	        map.put("endDate", new Date());
	        courses = service.selectWhereCourses(map);    
	}
	  @Test
	    public void test6SelectTrimCourses() {
	        Map<String, Object> map = new HashMap<String, Object>();
	        List<Course> courses = service.selectTrimCourses(map);
	        Assert.assertNotNull(courses);
	        
	        map.put("tutorId", 1);
	        courses = service.selectTrimCourses(map);
	        Assert.assertNotNull(courses);
	        
	        map.put("tutorId", 1);
	        map.put("courseName", "%java%");
	        courses = service.selectTrimCourses(map);
	        Assert.assertNotNull(courses);
	    }
	  @Test
	    public void test7indCoursesForeachByTutors(){
	        List<Integer> tutorIds = new ArrayList<Integer>();
	        tutorIds.add(1);
	        tutorIds.add(2);
	        
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("tutorIds", tutorIds);
	        
	        List<Course> courses = service.selectCoursesForeachByTutors(map);
	        Assert.assertNotNull(courses);
	    }
}
