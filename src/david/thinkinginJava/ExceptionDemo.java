package david.thinkinginJava;

import java.util.logging.Logger;

public class ExceptionDemo {
    private static Logger logger = Logger.getLogger("ExceptionDemoLogger");
    
    /*
     * �����Զ����쳣��
     */
    public static void printException() {
	try {
	    throw new Exception("���ǲ���Exception");
	} catch (Exception e) {
	    e.printStackTrace(System.out);
	    logger.severe(e.getMessage());
	}
    }

    /*
     * �������쳣
     */
    public static void printNullException() {
	try {
	    Object testObj = null;
	    System.out.println(testObj.toString());
	} catch (NullPointerException e) {	    
	    e.printStackTrace(System.out);
	    logger.severe(e.getMessage());
	}
    }

    /*
     * ����Խ���쳣
     */
    public static void printArrayIndexOutOfBoundsException() {
	try {
	    int[] testArray = new int[] { 1, 2, 3 };
	    System.out.println(testArray[3]);
	} catch (ArrayIndexOutOfBoundsException e) {
	    // TODO: handle exception
	    e.printStackTrace(System.out);
	    logger.severe(e.getMessage());
	}
    }

    /*
     * ���쳣��
     */
    public static void printSimpleException() {
	try {
	    throw new SimpleException("This is a simple exception!");
	} catch (SimpleException e) {
	    // TODO: handle exception
	    e.printStackTrace(System.out);
	    logger.severe(e.getMessage());
	}
    }

    /*
     * �Զ��ָ�����
     */
    public static void printRecoverException() {
	int index = 0;
	int a = 5, b = 0;
	while (true) {
	    try {
		if (index == 5) {
		    b = 5;		    
		}
		double result = a / b;	
		System.out.println(result);
		break;
	    } catch (ArithmeticException e) {
		System.out.println("��ǰ�ǵ�" + index + "��");
		e.printStackTrace(System.out);
		logger.severe(e.getMessage());
	    } finally {
		index++;
	    }
	}
    }
    
    public static void printLoggingException() {
	try {
	    throw new LoggingException();
	} catch (LoggingException e) {
	    // TODO: handle exception
	    System.err.println("Caught" + e);
	}
    }
    
    /*
     * �޲��쳣����
     */
    private static void nonParameterFunc() throws CustomException {
	System.out.println("Throwing custom exception by non-parameters from nonParameterFunc();");
	throw new CustomException();
    }
    
    /*
     * ��һ�������Ĺ��췽��
     */
    private static void oneParameterFunc() throws CustomException {
	System.out.print("Throwing custom exception by non-parameters from oneParameterFunc();");
	throw new CustomException("Input Message");
    }
    
    /*
     * �����������Ĺ��췽��
     */
    private static void twoParameterFunc() throws CustomException {
	System.out.println("Throwing custom exception by non-parameters from oneParameterFunc();");
	throw new CustomException("Two Input Message", 88);
    }
    
    /*
     * ��ӡ�Զ�����쳣����Demo
     */
    public static void printCustomExceptions() {
	try {
	    nonParameterFunc();
	} catch (CustomException e) {
	    // TODO: handle exception
	    System.out.println("-------------------");
	    e.printStackTrace(System.out);
	}
	
	try {
	    oneParameterFunc();
	} catch (CustomException e) {
	    // TODO: handle exception
	    System.out.println("-------------------");
	    e.printStackTrace(System.out);
	}
	
	try {
	    twoParameterFunc();
	} catch (CustomException e) {
	    // TODO: handle exception
	    System.out.println("-------------------");
	    e.printStackTrace(System.out);
//	    System.out.println(e.getMessage());
//	    System.out.println(e.getLocalizedMessage());
//	    System.out.println(e.getCause());
//	    System.out.println(e.getClass());
//	    System.out.println(e.getStackTrace());
	}
    }
}
