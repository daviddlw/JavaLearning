package david.javanio;

import java.io.Serializable;

public class SimpleType implements Serializable{
    /**
     * 自定义简单对象类型为了序列化演示用
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
