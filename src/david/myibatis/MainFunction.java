package david.myibatis;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import david.model.CourseDetail;
import david.model.Student;
import david.model.Course;

public class MainFunction {

    private static final String QUERY_STUDENT_BY_ID_STR = "david.mybatis.StudentMapper.queryStudentById";

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// wayOfSqlSessionQuery();
	// wayOfInterfaceQuery();
	// wayOfInterfaceQueryStudentLs();
	// wayOfInterfaceAddStudent();
	// wayOfInterfaceUpdateStudent();
	// wayOfInterfaceDeleteStudent();

	// wayOfInterfaceQueryCourse();
	// wayOfInterfaceQueryCourseLs();
	// wayOfInterfaceAddCourse();
	queryComplexObj();
    }
    
    /*
     * ������ϲ�ѯ���Ӷ���
     */
    public static void queryComplexObj() {
	SqlSession session = getSqlSessionByStream();
	ICourseDetailOperation idOp = session.getMapper(ICourseDetailOperation.class);
	List<CourseDetail> ls = idOp.getList();
	for (CourseDetail item : ls) {
	    System.out.println(item);
	}	
    }

    public static void wayOfInterfaceAddCourse() {
	List<Course> ls = Arrays.asList(new Course[] { new Course(1, "����"),
		new Course(1, "��ѧ"), new Course(1, "Ӣ��") });
	SqlSession session = getSqlSessionByStream();
	ICourseOperation courseOp = session.getMapper(ICourseOperation.class);
	System.out.print("�������ǰ��");
	List<Course> courses = courseOp.queryListByStudentId(1);
	if (courses.size() > 0) {
	    System.out.print("��" + courses.size() + "����");
	} else {
	    System.out.println("û��ƥ������");
	}
	int totalCount = 0;
	// for (Course course : ls) {
	// totalCount += courseOp.addCourse(course);
	// }
	totalCount = courseOp.addCourse(new Course(1, "����"));
	session.commit();
	System.out.println();
	for (Course course : courseOp.queryListByStudentId(1)) {
	    System.out.println(course);
	}
	System.out.println("�ܹ�������" + totalCount + "�����ݡ�");
    }

    public static void wayOfInterfaceDeleteStudent() {
	SqlSession session = getSqlSessionByStream();
	IStudentOperation iOperation = session
		.getMapper(IStudentOperation.class);
	System.out.println("ɾ������ǰ��");
	for (Student item : iOperation.queryStudentList()) {
	    System.out.println(item);
	}
	int i = iOperation.deleteStudent(1);
	session.commit();
	System.out.println("-----------------");
	for (Student item : iOperation.queryStudentList()) {
	    System.out.println(item);
	}
	System.out.println("��Ӱ������" + i + "��");
    }

    public static void wayOfInterfaceUpdateStudent() {
	try {
	    SqlSession sqlSession = getSqlSessionByStream();
	    IStudentOperation iOperation = sqlSession
		    .getMapper(IStudentOperation.class);
	    Student sourceStu = iOperation.queryStudentById(1);
	    System.out.println("����ǰ=>" + sourceStu);
	    sourceStu.setName(sourceStu.getName() + "���º�");
	    iOperation.updateStudent(sourceStu);
	    sqlSession.commit();
	    System.out.println("���º�=>" + iOperation.queryStudentById(1));
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public static void wayOfInterfaceAddStudent() {
	try {
	    Student student = new Student("��������");
	    SqlSession sqlSession = getSqlSessionByStream();
	    IStudentOperation iOperation = sqlSession
		    .getMapper(IStudentOperation.class);
	    iOperation.addStudent(student);
	    sqlSession.commit();
	    sqlSession.close();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	wayOfInterfaceQueryStudentLs();
    }

    public static void wayOfInterfaceQueryCourseLs() {
	try {
	    SqlSession sqlSession = getSqlSessionByStream();
	    ICourseOperation courseOp = sqlSession
		    .getMapper(ICourseOperation.class);
	    List<Course> courses = courseOp.getCourseListWithStudentInfo(3);
	    for (Course course : courses) {
		String infomations = String.format(
			"CourseId��%d, CourseName��%s, StudentId��%d, "
				+ "StudentName��%s", course.getId(),
			course.getCourseName(), course.getStudent().getId(),
			course.getStudent().getName());
		System.out.println(infomations);
	    }
	    sqlSession.close();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

    public static void wayOfInterfaceQueryCourse() {
	SqlSession sqlSession = getSqlSessionByStream();
	ICourseOperation cOperation = sqlSession
		.getMapper(ICourseOperation.class);
	Course course = cOperation.queryCourseById(1);
	System.out.println(course);
	sqlSession.close();
    }

    public static void wayOfInterfaceQueryCourseList() {
	SqlSession sqlSession = getSqlSessionByStream();
	ICourseOperation cOperation = sqlSession
		.getMapper(ICourseOperation.class);
	Course course = cOperation.queryCourseById(1);
	System.out.println(course);
	sqlSession.close();
    }

    public static void wayOfInterfaceQueryStudentLs() {
	SqlSession sqlSession = getSqlSessionByStream();
	IStudentOperation sOperation = sqlSession
		.getMapper(IStudentOperation.class);
	List<Student> students = sOperation.queryStudentList();
	for (Student student : students) {
	    System.out.println(student);
	}
	sqlSession.close();
    }

    public static void wayOfInterfaceQuery() {
	SqlSession sqlSession = getSqlSessionByStream();
	IStudentOperation studentOperation = sqlSession
		.getMapper(IStudentOperation.class);
	Student student = studentOperation.queryStudentById(3);
	System.out.println(student.toString());
	sqlSession.close();
    }

    /*
     * Sql Session��ѯʵ����ʽ
     */
    public static void wayOfSqlSessionQuery() {
	SqlSession sqlSession = getSqlSessionByStream();
	Student queryObj = sqlSession.selectOne(QUERY_STUDENT_BY_ID_STR, 3);

	queryObj = queryObj == null ? new Student() : (Student) queryObj;
	System.out.println(queryObj.toString());
	sqlSession.close();
    }

    /*
     * ��ȡ��ӦSqlSession
     */
    private static SqlSession getSqlSessionByStream() {
	SqlSession sqlSession = null;
	try {
	    InputStream inputStream = null;
	    String resource = "config/mybatis-config.xml";

	    inputStream = Resources.getResourceAsStream(resource);
	    // @off
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
		    .build(inputStream);
	    sqlSession = sqlSessionFactory.openSession();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return sqlSession;
    }

    public static String changeCharset(String str, String newCharset)
	    throws UnsupportedEncodingException {
	if (str != null) {
	    // ��Ĭ���ַ���������ַ�����
	    byte[] bs = str.getBytes();
	    // ���µ��ַ����������ַ���
	    return new String(bs, newCharset);
	}
	return null;
    }
}
