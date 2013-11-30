package david.myibatis;

import java.util.List;

import david.model.Course;

public interface ICourseOperation {
    /*
     * ����ID�鿴��Ӧ�γ�
     */
    public Course queryCourseById(int id);

    /*
     * �����Ӧ�γ�
     */
    public int addCourse(Course course);

    /*
     * �鿴���е�ǰѧ�������пγ�
     */
    public List<Course> queryListByStudentId(int studentId);
    
    /*
     * ��ѧ����Ϣ�Ŀγ�����
     */
    public List<Course> getCourseListWithStudentInfo(int studentId);
}
