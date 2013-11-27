package david.myibatis;

import java.util.List;

import david.model.Student;

public interface IStudentOperation {

    /*
     * ����ID�鿴ѧ����Ϣ
     */
    public Student queryStudentById(int id);
    
    /*
     * �鿴����ѧ����Ϣ
     */
    public List<Student> queryStudentList();
    
    /*
     * ����µ�ѧ��
     */
    public void addStudent(Student student);
    
    /*
     * ����ѧ����Ϣ
     */
    public void updateStudent(Student student);
    
    /*
     * ɾ��ѧ��
     */
    public int deleteStudent(int id);
}
