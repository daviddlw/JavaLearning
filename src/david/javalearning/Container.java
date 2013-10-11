package david.javalearning;

import java.util.List;

import david.thinkinginJava.Student;

public class Container {

    public Container() {
	// TODO Auto-generated constructor stub
    }
    
    public static String showStudentInfo(Student info) {
	return String.format("序号： %s 姓名：%s 是否成年： %s", info.getId(), info.getName());
    }
    
    public static void showAllStudent(List<Student> studentLs) {
	for (Student student : studentLs) {
	    System.out.println(Container.showStudentInfo(student));
	}
    }
    
}
