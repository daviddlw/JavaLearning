package david.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;

import com.mysql.jdbc.Statement;

import david.model.Student;

public class JDBCTest {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst = null;
	private static final String CONNECTION_DRIVER_STR = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_STR = "jdbc:mysql://127.0.0.1:3306/mybatis_db?useUnicode=true&amp;characterEncoding=utf8";

	// 协议+IP地址（域名）+端口+数据库名

	/*
	 * 没有使用sql参数化的插入
	 */
	public static void insert(Student item) {
		conn = getConnection();
		String sql = String.format("insert into student (name, createtime) values ('%s', sysdate())", item.getName());
		try {
			st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			if (count > 0)
				System.out.println("添加成功!");

			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 删除某个查询对象
	 */
	public static void delete(int id) {
		conn = getConnection();
		String sql = "delete from student where id = ?";
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 更新某个查询对象
	 */
	public static void update(Student student) {
		conn = getConnection();
		String sql = "update student set name=? where id=?";
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setInt(2, student.getId());
			int count = pst.executeUpdate();
			conn.commit();
			if (count == 0)
				System.out.println("没有查询到相关Id的信息");

			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 根据Id获取Student对象
	 */
	public static Student getStudentById(int id) {
		conn = getConnection();
		String sql = "select id, name from student where id = ?";
		Student student = new Student();
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				student.setId(id);
				student.setName(rs.getString("name"));
			}

			if (student.getId() == 0)
				System.out.println("查无匹配");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return student;
	}

	/*
	 * 查询student列表
	 */
	public static void queryList() {
		List<Student> students = new ArrayList<Student>();
		conn = getConnection();
		String sql = "select * from student";
		try {
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				students.add(new Student(name));
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
	 * 获取数据库访问链接
	 */
	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(CONNECTION_DRIVER_STR);
			conn = DriverManager.getConnection(CONNECTION_STR, "root", "david0110");
		} catch (Exception ex) {
			// TODO: handle exception
			StrBuilder sb = new StrBuilder("数据库连接失败了");
			sb.appendln(ex.getMessage());
			System.out.println(sb.toString());
		}
		return conn;
	}
}
