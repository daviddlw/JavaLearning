package david.jdbc;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;

import com.mysql.jdbc.Statement;

import david.model.Student;

public class JDBCTest {
    private static Connection conn;
    private static Statement st;
    private static final String CONNECTION_DRIVER_STR = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/test"; // url����=>
										     // Э��+IP��ַ��������+�˿�+���ݿ���

    public static void insert(Student item) {
	conn = getConnection();
	String sql = String
		.format("insert into student (name, createtime) values ('%s', sysdate())",
			item.getName());
	try {
	    st = (Statement) conn.createStatement();
	    int count = st.executeUpdate(sql);
	    if (count > 0)
		System.out.println("��ӳɹ�!");

	    conn.close();
	} catch (Exception e) {
	    // TODO: handle exception
	    System.out.println(e.getMessage());
	}
    }

    public static void query() {
	List<Student> students = new ArrayList<Student>();
	conn = getConnection();
	String sql = "select * from student";
	try {
	    st = (Statement) conn.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		students.add(new Student(id, name));
	    }
	    conn.close();
	} catch (Exception ex) {
	    // TODO: handle exception
	    System.out.println(ex.getMessage());
	}

	for (Student student : students) {
	    System.out.println(student);
	}
    }

    /*
     * ��ȡ���ݿ��������
     */
    private static Connection getConnection() {
	Connection conn = null;
	try {
	    Class.forName(CONNECTION_DRIVER_STR);
	    conn = DriverManager.getConnection(CONNECTION_STR, "root",
		    "david0110");
	} catch (Exception ex) {
	    // TODO: handle exception
	    StrBuilder sb = new StrBuilder("���ݿ�����ʧ����");
	    sb.appendln(ex.getMessage());
	    System.out.println(sb.toString());
	}
	return conn;
    }
}
