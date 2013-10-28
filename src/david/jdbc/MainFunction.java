package david.jdbc;

import java.util.Scanner;

import david.model.Student;
import david.util.StringUtil;

public class MainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCTest.queryList();
		// insertStudent();
		// updateStudent();
		// deleteStudent();
		queryStudent();
	}

	/*
	 * 插入指定学生信息
	 */
	private static void insertStudent() {
		Scanner scanner = new Scanner(System.in);
		String s;
		int count = 0;
		// Student student = new Student(6, "redis");
		Student student = new Student();
		while (count < 1) {
			System.out.println("请输入您的名字：");
			s = scanner.next();
			student.setName(s);
			count++;
		}
		JDBCTest.insert(student);
		StringUtil.printSplitLines();
		JDBCTest.queryList();
	}

	/*
	 * 插入指定学生信息
	 */
	private static void deleteStudent() {
		Scanner scanner = new Scanner(System.in);
		int id = 0;
		int count = 0;
		while (count < 1) {
			System.out.println("请输入要删除的ID：");
			id = Integer.valueOf(scanner.next());
			count++;
		}
		JDBCTest.delete(id);
		StringUtil.printSplitLines();
		JDBCTest.queryList();
	}

	/*
	 * 插入指定学生信息
	 */
	private static void queryStudent() {
		Scanner scanner = new Scanner(System.in);
		int id = 0;
		int count = 0;
		while (count < 1) {
			System.out.println("请输入要查询的ID：");
			id = Integer.valueOf(scanner.next());
			count++;
		}
		System.out.println(JDBCTest.getStudentById(id));
	}

	/*
	 * 更新指定学生信息
	 */
	private static void updateStudent() {
		Scanner scanner = new Scanner(System.in);
		String s;
		int count = 0;
		Student student = new Student();
		while (count < 2) {
			if (count == 0) {
				System.out.println("请输入要更新的Id：");
				int id = Integer.valueOf(scanner.next());
				student.setId(id);
			} else {
				System.out.println("请输入更新后的名字：");
				s = scanner.next();
				student.setName(s);
			}
			count++;
		}
		JDBCTest.update(student);
		StringUtil.printSplitLines();
		JDBCTest.queryList();
	}
}
