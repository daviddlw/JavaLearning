package david.myibatis;

import java.util.List;

import david.model.BasicQueryArgs;
import david.model.CourseDetail;

public interface ICourseDetailOperation {
    
    public List<CourseDetail> getList(BasicQueryArgs args);
    
    public int getTotalCount();
}
