package david.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student {

	private int id;
	private String name;
	private Calendar birth;

	public Student() {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.name = "";
		this.birth = Calendar.getInstance();
	}

	public Student(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.birth = Calendar.getInstance();

	}

	public Student(int id, String name, Calendar birth) {
		this(id, name);
		this.birth = birth;
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

	public Calendar getCalendar() {
		return birth;
	}

	public void setCalendar(Calendar birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return String.format("{Id=>%d, Name=>%s, birth=>%s}", id, name,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birth
						.getTime()));
	}
}
