package david.thinkinginJava;

import java.util.Arrays;

public class ArrayOfPrimatives {
    private int[] _sourceArray = new int[] { 1, 2, 3, 4, 5 };
    private int[] _resultArray;

    public ArrayOfPrimatives() {
	// TODO Auto-generated constructor stub
	_resultArray = _sourceArray;
    }

    public void showOriginalArray() {
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0; i < _sourceArray.length; i++) {
	// sb.append(i == _sourceArray.length - 1 ? _sourceArray[i]
	// : _sourceArray[i] + ",");
	// }
	System.out.println(Arrays.toString(_sourceArray));
    }

    public void changeArray() {
	for (int i = 0; i < _sourceArray.length; i++) {
	    _sourceArray[i] = _sourceArray[i] + 1;
	}
    }

    public void showResultArray() {
	System.out.println(Arrays.toString(_resultArray));
    }
    
    
}
