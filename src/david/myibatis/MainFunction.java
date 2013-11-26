package david.myibatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import david.model.Student;

public class MainFunction {

    private static final String QUERY_STUDENT_BY_ID_STR = "david.mybatis.StudentMapper.queryStudentById";

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// wayOfSqlSessionQuery();
	wayOfInterfaceQuery();

    }

    public static void wayOfInterfaceQuery() {
	IStudentOperation studentOperation = getSqlSession().getMapper(
		IStudentOperation.class);
	Student student = studentOperation.queryStudentById(3);
	System.out.println(student.toString());
    }

    /*
     * Sql Session查询实例方式
     */
    public static void wayOfSqlSessionQuery() {
	SqlSession sqlSession = getSqlSession();
	Student queryObj = sqlSession.selectOne(QUERY_STUDENT_BY_ID_STR, 3);

	queryObj = queryObj == null ? new Student() : (Student) queryObj;
	System.out.println(queryObj.toString());
    }

    /*
     * 获取相应SqlSession
     */
    private static SqlSession getSqlSession() {
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
}
