package david.thinkinginJava;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDemo {
    
    /*
     * ��һ��100��̨�׵Ľ��ݣ�һ�ο���ѡ����һ��̨�ף���������̨�ף�����ϵ�¥�ݶ��м����߷�
     */
    public static void calculateSteps() {
	
	List<String> ls = new ArrayList<String>();
	for (int stepOne = 0; stepOne <= 100; stepOne++) {
	    for (int stepTwo = 0; stepTwo <= 100; stepTwo++) {
		    if (stepOne + 2 * stepTwo == 100) {
			ls.add(String.format("һ��=>%d ����=>%d", stepOne, stepTwo));
		}
	    }
	}
	System.out.println("һ��" + ls.size() + "���߷�");
	for (String item : ls) {
	    System.out.println(item);
	}
    }

}
