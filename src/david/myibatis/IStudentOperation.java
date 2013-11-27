package david.myibatis;

import java.util.List;

import david.model.Student;

public interface IStudentOperation {

    /*
     * 根据ID查看学生信息
     */
    public Student queryStudentById(int id);
    
    /*
     * 查看所有学生信息
     */
    public List<Student> queryStudentList();
    
    /*
     * 添加新的学生
     */
    public void addStudent(Student student);
    
    /*
     * 更新学生信息
     */
    public void updateStudent(Student student);
    
    /*
     * 删除学生
     */
    public int deleteStudent(int id);
}
