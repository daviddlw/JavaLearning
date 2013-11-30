package david.myibatis;

import java.util.List;

import david.model.Course;

public interface ICourseOperation {
    /*
     * 根据ID查看相应课程
     */
    public Course queryCourseById(int id);

    /*
     * 添加相应课程
     */
    public int addCourse(Course course);

    /*
     * 查看所有当前学生的所有课程
     */
    public List<Course> queryListByStudentId(int studentId);
    
    /*
     * 带学生信息的课程详情
     */
    public List<Course> getCourseListWithStudentInfo(int studentId);
}
