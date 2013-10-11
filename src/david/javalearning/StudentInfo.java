package david.javalearning;

public class StudentInfo {

    private String name;
    
    public StudentInfo() {
	this.name = "";	
    }
    
    public StudentInfo(String name){
	this.name = name;
    }
    
    public void changeName(String name)
    {
	this.name = name;
    }
    
    public class Grade
    {
	private int chinese = 0;
	private int english = 0;
	private int math = 0;
	
	public Grade(int chinese, int english, int math) {
	    this.chinese = chinese;
	    this.english = english;
	    this.math = math;
	}
	
	public String getGradeInfo() {
	    return String.format("%s => ÓïÎÄ£º%s ÊıÑ§£º%s Ó¢Óï£º%s", name, this.chinese, this.math, this.english);
	}
    }

}
