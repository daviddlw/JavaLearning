package david.javanio;

import java.io.Serializable;

public class SimpleType implements Serializable{
    /**
     * �Զ���򵥶�������Ϊ�����л���ʾ��
     */
    private static final long serialVersionUID = 1L;
    private String type;
    
    public SimpleType(String type) {
	// TODO Auto-generated constructor stub
	this.type = type;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return type;
    }
}
