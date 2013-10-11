package david.javalearning;
import david.util.StringUtil;

public class StringDemo {
    private final static String EMPTY_STRING = "";

    /**
     * 处理特殊字符串
     * 
     * @param sourceString
     * @return
     */
    public static String getDealedString(String sourceString) {
	if (sourceString.isEmpty())
	    return EMPTY_STRING;
	else {
	    return sourceString.substring(0, 1).toUpperCase()
		    .concat(sourceString.substring(1).toLowerCase());
	}
    }

    /**
     * java.lang.String类学习
     */
    public static void stringAPILearning() {
	String s1 = "david";
	String s2 = "david";
	boolean isEquals = s1.compareToIgnoreCase(s2) == 0;
	System.out.println(s1.toUpperCase());
	System.out.println(s1.substring(0, 1).toUpperCase()
		.concat(s1.substring(1).toLowerCase()));
	System.out.println(isEquals);
	System.out.println(s1.length());
	System.out.println(s1.charAt(2));
	System.out.println(s1.substring(0, s1.length() - 2));
	System.out.println(StringDemo.getDealedString(s1));
	System.out.println(s1.startsWith("d"));
	System.out.println(s1.startsWith("b", 2));
	System.out.println(s1.endsWith("b"));
	System.out.println(s1.compareTo(s2.toLowerCase()));
	String specialString = " hello world ";
	System.out.println(specialString.length());
	System.out.println(specialString.trim().length());
	String[] test = new String[] {};
	test = specialString.split(" ");
	for (String item : test) {
	    System.out.println(item);
	}
	String ssString = specialString.trim().replace(" ", "_");
	System.out.println(ssString);
	System.out.println(s1.replaceFirst("d", "z"));
	System.out.println(s1.replaceAll("d", "z"));
	System.out.println(s1.isEmpty());
    }

    public static void stringFormatter() {
	String sourceStr = String.format("%1$,05d", 123123);
	System.out.println(String.format("%1$d%%", 12));
	System.out.println(sourceStr);

	System.out.println(String.format("%1$tY-%1$tm-%1$te",
		new java.util.Date()));
	java.util.Calendar calendar = new java.util.GregorianCalendar();
	calendar.getTimeZone();
	String formatString = "%s_你好,_我是%s！你今年%s岁了";
	System.out.println(String.format(formatString, "david", "micheal", 25));
    }

    public static void stringSpiltDemo() {
	String testStr = "1,2,3,4,5,6";
	String[] arrStrings = StringUtil.toSpilitArray(testStr, ",");
	for (String item : arrStrings) {
	    System.out.println(item);
	}
    }
}
