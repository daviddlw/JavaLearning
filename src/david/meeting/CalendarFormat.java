package david.meeting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import david.util.CollectionUtils;
import david.util.StringUtil;

/*
 * Java�е����ڸ�ʽ������
 */
public class CalendarFormat {
    public static void testCalendarFormat() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
	System.out.println(sdf.format(new Date()));
	Calendar testDate = Calendar.getInstance();
	testDate.set(2013, 0, 10, 23, 58, 8);
	System.out.println(sdf.format(testDate.getTime()));

	Object[] objLs = new Object[] { 1, 2, 3 };
	Integer[] intLs = new Integer[objLs.length];
	List<Integer> ls = CollectionUtils.transformList(objLs);
	System.out.println("ls=>" + ls);
	intLs = CollectionUtils.transformList(objLs).toArray(intLs);
	System.out.println("intLs=>" + Arrays.toString(intLs));

	StringUtil.printSplitLines();

	System.out.println("��ǰʱ��Ϊ��"
		+ StringUtil.ToDateStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
