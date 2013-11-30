package david.myibatis;

import java.util.List;
import david.model.CourseDetail;

public interface ICourseDetailOperation {
    
    public List<CourseDetail> getList(int studentId);
}
