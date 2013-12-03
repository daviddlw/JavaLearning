package david.myibatis;

import java.util.List;

import david.model.BasicQueryArgs;
import david.model.CourseDetail;
import david.model.ListQueryArgs;

public interface ICourseDetailOperation {
    
    public List<CourseDetail> getList(BasicQueryArgs args);
    
    public int getTotalCount();
    
    public List<CourseDetail> getListByIds(ListQueryArgs args);
    
    public List<CourseDetail> getListByIds(List<Integer> ids);
}
