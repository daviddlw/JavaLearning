package david.model;

import java.util.ArrayList;
import java.util.List;

public class ListQueryArgs {
    private List<Integer> ids;

    public ListQueryArgs() {
	// TODO Auto-generated constructor stub
	ids = new ArrayList<Integer>();
    }

    public ListQueryArgs(List<Integer> ids) {
	this.ids = ids;
    }

    public void setIds(List<Integer> ids) {
	this.ids = ids;
    }

    public List<Integer> getIds() {
	return ids;
    }
}
