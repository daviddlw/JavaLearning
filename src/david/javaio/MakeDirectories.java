package david.javaio;

import java.io.File;
import org.apache.commons.lang3.text.StrBuilder;

public class MakeDirectories {
    
    private static void usage() {
	StrBuilder sb = new StrBuilder();
	sb.appendln("Usage: MakeDirectories path1...");
	sb.appendln("Creates each path");
	sb.appendln("Usage: MakeDirectories -d path1");
	sb.appendln("Delete each path");
	sb.appendln("Usage: MakeDirectories -r path1 path2");
	sb.appendln("Rename from path1 to path2");
	System.err.println(sb.toString());
	System.exit(0);
    }

    private static void fileData(File file) {
	StrBuilder sb = new StrBuilder();
	sb.appendln("Absolute path£º" + file.getAbsolutePath());
	sb.appendln("Can read£º" + file.canRead());
	sb.appendln("Can write£º" + file.canWrite());
	sb.appendln("GetName£º" + file.getName());
	sb.appendln("GetParent£º" + file.getParent());
	sb.appendln("GetPath£º" + file.getPath());
	sb.appendln("Length£º" + file.length());
	sb.appendln("LastModified£º" + file.lastModified());
	sb.appendln("Is File£º" + file.isFile());
	sb.appendln("Is Directory£º" + file.isDirectory());
	System.out.println(sb.toString());
    }

    public static void runMainFun(String[] args) {
	if (args.length < 1) {
	    usage();
	}
	if (args[0].equals("-r")) {
	    if (args.length != 3)
		usage();

	    File oldOne = new File(args[1]);
	    File newOne = new File(args[2]);

	    oldOne.renameTo(newOne);
	    fileData(oldOne);
	    fileData(newOne);
	    return;
	}

	int count = 0;
	boolean del = false;
	if (args[0].equals("-d")) {
	    count++;
	    del = true;
	}
	count--;
	while (++count < args.length) {
	    File f = new File(args[count]);
	    if (f.exists()) {
		System.out.println(f + " exists");
		if (del) {
		    System.out.println("deleting..." + f);
		    f.delete();
		}
	    } else {
		if (!del) {
		    f.mkdir();
		    System.out.println("created..." + f);
		}
	    }
	    fileData(f);
	}
    }
}
