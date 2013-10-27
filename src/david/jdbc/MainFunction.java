package david.jdbc;

import java.util.Scanner;

import david.model.Student;
import david.util.StringUtil;

public class MainFunction {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	JDBCTest.query();
	insertStudent();
    }

    private static void insertStudent() {
	Scanner scanner = new Scanner(System.in);
	String s;
	int count = 0;
	// Student student = new Student(6, "redis");
	Student student = new Student();
	while (count < 1) {
	    System.out.println("ÇëÊäÈëÄúµÄÃû×Ö£º");
	    s = scanner.next();
	    student.setName(s);
	    count++;
	}
	JDBCTest.insert(student);
	StringUtil.printSplitLines();
	JDBCTest.query();
    }
}
