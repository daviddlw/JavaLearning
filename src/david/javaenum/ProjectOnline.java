package david.javaenum;

import java.util.EnumSet;

public class ProjectOnline {
    /*
     * 软件项目周期枚举
     */
    public enum ProjectProcessEnum {
	需求收集 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	销售签单 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	策划提案 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	Demo制作 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	项目原型 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	项目开发 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	项目测试 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	项目发布 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	项目验收 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	},
	尾款回收 {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("项目进入" + this.name());
	    }
	};

	abstract void action();
    }
    
    private EnumSet<ProjectProcessEnum> actions = EnumSet.of(ProjectProcessEnum.需求收集);
    
    public void add(ProjectProcessEnum type) {
	actions.add(type);
    }
    
    /*
     * 展示自定义添加的枚举行为
     */
    public void showActions() {
	for (ProjectProcessEnum item : actions) {
	    item.action();
	}
    }
    
    /*
     * 展现软件过程整个流程
     */
    public void showProjectProcessEnum() {
	for (ProjectProcessEnum item : ProjectProcessEnum.values()) {
	    item.action();
	}
    }
}
