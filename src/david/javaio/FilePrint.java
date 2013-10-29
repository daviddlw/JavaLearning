package david.javaio;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.text.StrBuilder;

public class FilePrint {
    /*
     * 列表格式化
     */
    public static String pformat(Collection<?> c) {
	if (c.size() == 0)
	    return "[]";

	StrBuilder sb = new StrBuilder("【");
	int index = 0;
	for (Object elem : c) {
	    if (c.size() != 1) {
		if (index == c.size() - 1)
		    sb.append(elem);
		else
		    sb.appendln(elem);
	    } else {
		sb.append(elem);
	    }
	    index++;
	}
	sb.append("】");

	return sb.toString();
    }

    public static void pprint(Collection<?> c) {
	System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
	System.out.println(pformat(Arrays.asList(c)));
    }
}
