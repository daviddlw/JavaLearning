package david.model;

public class BasicQueryArgs {
    private int pageIndex;
    private int pageSize;
    private int queryId;

    public BasicQueryArgs() {
	// TODO Auto-generated constructor stub
	pageIndex = 0;
	pageSize = 0;
	queryId = 0;
    }

    public BasicQueryArgs(int pageIndex, int pageSize) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
	queryId = 0;
    }

    public BasicQueryArgs(int pageIndex, int pageSize, int queryId) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
	this.queryId = queryId;
    }

    public void updatePageIndexAndPageSize(int pageIndex, int pageSize) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
    }

    public void updatePageIndexAndPageSize(int pageIndex, int pageSize,
	    int queryId) {
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
	this.queryId = queryId;
    }
}
