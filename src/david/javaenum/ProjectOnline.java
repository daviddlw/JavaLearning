package david.javaenum;

import java.util.EnumSet;

public class ProjectOnline {
    /*
     * �����Ŀ����ö��
     */
    public enum ProjectProcessEnum {
	�����ռ� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	����ǩ�� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	�߻��᰸ {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	Demo���� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	��Ŀԭ�� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	��Ŀ���� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	��Ŀ���� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	��Ŀ���� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	��Ŀ���� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	},
	β����� {
	    @Override
	    void action() {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����" + this.name());
	    }
	};

	abstract void action();
    }
    
    private EnumSet<ProjectProcessEnum> actions = EnumSet.of(ProjectProcessEnum.�����ռ�);
    
    public void add(ProjectProcessEnum type) {
	actions.add(type);
    }
    
    /*
     * չʾ�Զ�����ӵ�ö����Ϊ
     */
    public void showActions() {
	for (ProjectProcessEnum item : actions) {
	    item.action();
	}
    }
    
    /*
     * չ�����������������
     */
    public void showProjectProcessEnum() {
	for (ProjectProcessEnum item : ProjectProcessEnum.values()) {
	    item.action();
	}
    }
}
