package david.model;

public class Course {
	private int id;
	private int studentId;
	private String courseName;

	public Course() {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.studentId = 0;
		this.courseName = "";
	}

	public Course(int id, int studentId, String courseName) {
		this.id = id;
		this.studentId = studentId;
		this.courseName = courseName;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Id: %d, StudentId£º%d, CourseName£º%s", id,
				studentId, courseName);
	}
}
