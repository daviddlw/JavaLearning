package david.model;

/*
 * 测试Myibatis的复合实体
 */
public class CourseDetail {
    private int id;
    private String name;
    private Student student;
    private Teacher teacher;

    public CourseDetail() {
	// TODO Auto-generated constructor stub
    }

    public CourseDetail(String name) {
	this.name = name;
	student = new Student();
	teacher = new Teacher();
    }

    public int getId() {
	return id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public Student getStudent() {
	return student;
    }

    public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
    }

    public Teacher getTeacher() {
	return teacher;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format(
		"[CourseId: %d, CourseName: %s, Teacher: %s, Student: %s]", id,
		name, teacher.toString(), student.toString());
    }
}
