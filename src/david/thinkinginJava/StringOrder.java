package david.thinkinginJava;

import java.util.Arrays;
import java.util.Collections;

public class StringOrder
{
	private static final String[] SOURCE_STR_ARRAY = new String[] { "Aa", "Bb",
			"Cc", "aa", "bb", "cc", "DD" };

	public StringOrder()
	{
		// TODO Auto-generated constructor stub
	}

	/*
	 * �ַ�������
	 */
	public static void stringOrderDemo(SortType type)
	{
		System.out.println("����ǰ����:\n");
		System.out.println(Arrays.toString(SOURCE_STR_ARRAY));
		switch (type)
		{
		case Default:
			Arrays.sort(SOURCE_STR_ARRAY);
			break;
		case Reservse:
			Arrays.sort(SOURCE_STR_ARRAY, Collections.reverseOrder());
			break;
		case IgnoreCase:
			Arrays.sort(SOURCE_STR_ARRAY, String.CASE_INSENSITIVE_ORDER);
		default:
			Arrays.sort(SOURCE_STR_ARRAY);
			break;
		}
		System.out.println("���������:\n");
		System.out.println(Arrays.toString(SOURCE_STR_ARRAY));
	}

}
