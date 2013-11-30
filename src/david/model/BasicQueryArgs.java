package david.model;

public class BasicQueryArgs {
    private int pageIndex;
    private int pageSize;

    public BasicQueryArgs() {
	// TODO Auto-generated constructor stub
	pageIndex = 0;
	pageSize = 0;
    }

    public BasicQueryArgs(int pageIndex, int pageSize) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
    }

    public void updatePageIndexAndPageSize(int pageIndex, int pageSize) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
    }
}
