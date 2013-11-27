package david.myibatis;

import java.util.List;

import david.model.Course;

public interface ICourseOperation {
    /*
     * 根据ID查看相应课程
     */
    public Course queryCourseById(int id);
    
    /*
     * 查看所有当前学生的所有课程
     */
    public List<Course> queryListByStudentId(int studentId);
}
