package david.javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir, final String regex) {
	return dir.listFiles(new FilenameFilter() {
	    Pattern pattern = Pattern.compile(regex);

	    @Override
	    public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(new File(name).getName()).matches();
	    }
	});
    }
    
    public static File[] local(File dir) {
	return local(dir, ".*");
    }

    public static File[] local(String path, final String regex) {
	return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {

	private List<File> dirs = new ArrayList<File>();
	private List<File> files = new ArrayList<File>();

	public void addAll(TreeInfo other) {
	    dirs.addAll(other.dirs);
	    files.addAll(other.files);
	}

	@Override
	public String toString() {
	    // TODO Auto-generated method stub
	    return "dirs£º" + FilePrint.pformat(dirs) + "\nfiles£º"
		    + FilePrint.pformat(files);
	}

	public static TreeInfo walk(String start, String regex) {
	    return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
	    return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) {
	    return recurseDirs(start, ".*");
	}

	public static TreeInfo recurseDirs(File starDir, String regex) {
	    TreeInfo treeInfo = new TreeInfo();
	    for (File item : starDir.listFiles()) {
		if (item.isDirectory()) {
		    treeInfo.dirs.add(item);
		    treeInfo.addAll(recurseDirs(item, regex));
		} else {
		    if (item.getName().matches(regex)) {
			treeInfo.files.add(item);
		    }
		}
	    }
	    return treeInfo;
	}

	@Override
	public Iterator<File> iterator() {
	    // TODO Auto-generated method stub
	    return null;
	}

    }
}
