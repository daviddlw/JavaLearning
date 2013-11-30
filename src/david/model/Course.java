package david.model;

public class Course {
    private int id;
    private int studentId;
    private String courseName;
    private Student student;

    public Course() {
	// TODO Auto-generated constructor stub
	this.id = 0;
	this.studentId = 0;
	this.courseName = "";
    }

    public Course(int studentId, String courseName) {
	this.studentId = studentId;
	this.courseName = courseName;
	this.student = new Student();
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public void setCourseName(String courseName) {
	this.courseName = courseName;
    }

    public String getCourseName() {
	return courseName;
    }

    public void setStudentId(int studentId) {
	this.studentId = studentId;
    }

    public int getStudentId() {
	return studentId;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public Student getStudent() {
	return student;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format("Id: %d, StudentId£º%d, CourseName£º%s", id,
		studentId, courseName);
    }
}
