package david.myibatis;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import david.model.Student;
import david.model.Course;

public class MainFunction {

	private static final String QUERY_STUDENT_BY_ID_STR = "david.mybatis.StudentMapper.queryStudentById";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// wayOfSqlSessionQuery();
		// wayOfInterfaceQuery();
		// wayOfInterfaceQueryStudentLs();
		// wayOfInterfaceQueryCourse();
		// wayOfInterfaceQueryCourseLs();
		// wayOfInterfaceAddStudent();
		// wayOfInterfaceUpdateStudent();
		wayOfInterfaceDeleteStudent();
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
		SqlSession sqlSession = getSqlSessionByStream();
		ICourseOperation cOperation = sqlSession
				.getMapper(ICourseOperation.class);
		List<Course> courses = cOperation.queryListByStudentId(1);
		for (Course item : courses) {
			System.out.println(item);
		}
		sqlSession.close();
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
	
	public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
		  if (str != null) {
		   //��Ĭ���ַ���������ַ�����
		   byte[] bs = str.getBytes();
		   //���µ��ַ����������ַ���
		   return new String(bs, newCharset);
		  }
		  return null;
	}
}
