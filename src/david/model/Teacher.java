package david.model;

/*
 * 教师实体类
 */
public class Teacher {
    private int id;
    private String name;

    public Teacher() {
	// TODO Auto-generated constructor stub
    }

    public Teacher(String name) {
	this.name = name;
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

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format("{id：%d, name：%s}", id, name);
    }
}
