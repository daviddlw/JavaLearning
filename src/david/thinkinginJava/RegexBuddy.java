package david.thinkinginJava;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class RegexBuddy {

    public RegexBuddy() {
	// TODO Auto-generated constructor stub
    }

    public static void regexDemo() {
	String number = "23123";
	int[] numberArray = new int[] { 1, 2, 3 };
	List ls = Arrays.asList(numberArray);

	for (int i = 0; i < ls.size(); i++) {
	    System.out.println(ls.get(i).toString());
	}

	boolean isMacth = number.matches("-?\\d+");
	System.out.println(isMacth);
    }

    public static void regexReplace() {
	String testStr = "It is david's home";
	testStr = testStr.replaceFirst("h\\w+", "page");
	System.out.println(testStr);
    }

    /*
     * Thinking in java String 练习7 - 检查句子是否以大写字母开头.结尾
     */
    public static void checkSentenceStartWithChar(String sentence) {
	String patternStr = "[A-Z].*\\.";
	System.out.println(Pattern.matches(patternStr, sentence));
    }

    /*
     * 正则匹配检查ABC
     */
    public static void checkAbc() {
	String valueString = "abcabc";
	boolean flag = valueString.matches("(abc)+");
	System.out.println(flag);
    }

    /*
     * 检查按指定分割符分割
     */
    public static void splitWord() {
	String constString = "Then, when you have found the shrubbery, you must cut down the mightiest tree "
		+ "in the forest..." + "with a herring!";
	System.out.println("SouceString => " + constString);
	System.out.println("------------------分割线----------------");
	String[] splitArray = constString.split("the|you");
	for (String item : splitArray) {
	    System.out.println(item);
	}
    }

    /*
     * pattern and matcher
     */
    public static void pattenAndMatcher() {
	String sourceStr = "david is 25 years old and his salary is 12000 dollars. He has 178 feet.";
	Pattern regexPattern = Pattern.compile("(\\s\\d+\\s)");
	Matcher matcher = regexPattern.matcher(sourceStr);
	System.out.println(matcher.groupCount());
	int index = 0;
	System.out.println(matcher.find());
	while (matcher.find()) {
	    System.out.println(matcher.group(index));
	    index++;
	}
    }

    public static void regexAppendReplacement() {
	String sourceStr = "Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company";
	Pattern regex = Pattern.compile("Kelvin");
	Matcher m = regex.matcher(sourceStr);
	StringBuffer sb = new StringBuffer();
	int index = 0;
	while (m.find()) {
	    index++;
	    m.appendReplacement(sb, "David");
	    System.out.format("这是第%d次匹配，字符串为：%s\n", index, sb.toString());

	}
	m.appendTail(sb);
	System.out.println(sb.toString());
    }

    public static String replaceDemo(ReplaceEnum type, String sourceStr) {
	if (type == ReplaceEnum.All) {
	    sourceStr = sourceStr.replaceAll("d", "你好");
	} else {
	    sourceStr = sourceStr.replaceFirst("d", "你好");
	}

	return sourceStr;
    }

    /*
     * 简单命令行输入
     */
    public static void simpleCmdRead(String inputSource) {
	BufferedReader input = new BufferedReader(new StringReader(inputSource)); // \n就表示一个readline读取一行
	try {
	    System.out.println("What's your name?");
	    String name = input.readLine();
	    System.out.println(String.format("My name is %s", name));
	    System.out
		    .println("Please enter your age and salary? Split them with comma.");
	    String ageAndSalary = input.readLine();
	    String[] args = david.util.StringUtil.toSpilitArray(ageAndSalary,
		    ",");
	    int age = args.length > 0 ? Integer.parseInt(args[0]) : 0;
	    double salary = args.length > 1 ? Double.parseDouble(args[1]) : 0;
	    System.out.println(String.format(
		    "Your age is %d and your salary is %f", age, salary));

	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    public static void betterCmdRead(String inputSource) {
	Scanner scanner = new Scanner(inputSource).useDelimiter(",");
	try {
	    System.out.println("What's your name?");
	    String name = scanner.nextLine();
	    System.out.format("My name is %s", name);
	    System.out.println();
	    System.out
		    .println("Please enter your age and salary? Split them with comma.");
	    int age = scanner.nextInt();
	    double salary = scanner.nextDouble();

	    System.out.println(String.format(
		    "Your age is %d and your salary is %f", age, salary));

	} catch (Exception e) {
	    e.printStackTrace();
	    // System.out.println(e.getMessage());
	    // TODO: handle exception
	}
    }
}
