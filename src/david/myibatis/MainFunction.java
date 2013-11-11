package david.myibatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import david.model.Student;

public class MainFunction {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	InputStream inputStream = null;
	try {
	    String resource = "config/mybatis-config.xml";

	    inputStream = Resources.getResourceAsStream(resource);
	    // @off
	    SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
		    .build(inputStream);
	    // @on
	    SqlSession sqlSession = ssf.openSession();

	    Student queryObj = sqlSession.selectOne(
		    "david.mybatis.StudentMapper.queryStudentById", 3);
	    queryObj = queryObj == null ? new Student() : (Student) queryObj;

	    System.out.println(queryObj.toString());

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
