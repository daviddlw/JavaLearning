package david.thinkinginJava;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDemo {
    
    /*
     * 有一个100个台阶的阶梯，一次可以选择上一个台阶，或者两个台阶，最后上到楼梯顶有几种走法
     */
    public static void calculateSteps() {
	
	List<String> ls = new ArrayList<String>();
	for (int stepOne = 0; stepOne <= 100; stepOne++) {
	    for (int stepTwo = 0; stepTwo <= 100; stepTwo++) {
		    if (stepOne + 2 * stepTwo == 100) {
			ls.add(String.format("一步=>%d 两步=>%d", stepOne, stepTwo));
		}
	    }
	}
	System.out.println("一共" + ls.size() + "种走法");
	for (String item : ls) {
	    System.out.println(item);
	}
    }

}
