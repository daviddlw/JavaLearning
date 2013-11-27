package david.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {

	private int id;
	private String name;
	private Date birth;

	public Student() {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.name = "";
		this.birth = new Date();
	}

	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.birth = new Date();

	}

	public Student(int id, String name, Calendar birth) {
		this(name);
		this.birth = birth.getTime();
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return String.format("{Id=>%d, Name=>%s, birth=>%s}", id, name,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birth
						.getTime()));
	}
}
