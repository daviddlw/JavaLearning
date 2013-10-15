package david.deepInCollection;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/*
 * 
 */
public class SortedDirList {
    private File path;
    private List<String> dirList;
    private int count;

    public SortedDirList(String filepath) {
	// TODO Auto-generated constructor stub
	path = new File(filepath);
	dirList = new ArrayList<String>();
    }

    public List<String> list() {
	String[] items = path.list();
	for (String item : items) {
	    dirList.add(item);
	}
	Collections.sort(dirList);
	count = dirList.size();
	return dirList;
    }

    public List<String> list(final String regex) {
	String[] items = path.list(new FilenameFilter() {

	    @Override
	    public boolean accept(File dir, String name) {
		return Pattern.matches(regex, name);
	    }
	});
	List<String> fileLs = Arrays.asList(items);
	Collections.sort(fileLs);
	count = fileLs.size();
	return fileLs;
    }
    
    public int getCount() {
	return count;
    }
}
