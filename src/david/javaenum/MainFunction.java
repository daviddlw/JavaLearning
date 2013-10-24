package david.javaenum;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.channels.FileChannel.MapMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

import david.javaenum.ProjectOnline.ProjectProcessEnum;
import david.javaio.OSExecute;
import david.util.StringUtil;

enum TestEnum {
    aa, bb
}

interface ICommand {
    public void action();
}

public class MainFunction {
    public static void main(String[] args) {
	// enumDesc();
	// viewEnumClass(TestEnum.class);
	// System.out.println(RandomEnum.random(Metrics.class));
	// enumSetDemo();
	// enumMapDemo();
	// projectOnlineEnum();
	RockSiccorsPaper.gameStart(10);
    }

    private static void projectOnlineEnum() {
	ProjectOnline po = new ProjectOnline();
	po.showProjectProcessEnum();
	StringUtil.printSplitLines();
	po.add(ProjectProcessEnum.策划提案);
	po.add(ProjectProcessEnum.项目开发);
	po.showActions();
    }

    private static void enumMapDemo() {
	EnumMap<Metrics, ICommand> em = new EnumMap<Metrics, ICommand>(
		Metrics.class);
	em.put(Metrics.PV, new ICommand() {
	    @Override
	    public void action() {
		// TODO Auto-generated method stub
		System.out.println("you get PV.");
	    }
	});

	em.put(Metrics.Clicks, new ICommand() {

	    @Override
	    public void action() {
		// TODO Auto-generated method stub
		System.out.println("you get Clicks.");
	    }
	});

	for (Map.Entry<Metrics, ICommand> item : em.entrySet()) {
	    item.getValue().action();
	}

	try {
	    em.get(Metrics.eCPC).action();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    private static void enumSetDemo() {
	EnumSet<Metrics> metrics = EnumSet.allOf(Metrics.class);
	System.out.println(metrics);
    }

    private static void viewEnumClass(Class<? extends TestEnum> item) {
	System.out.println("------接口------");
	for (Type t : item.getGenericInterfaces()) {
	    System.out.println(t);
	}
	System.out.println("------基类方法---------");
	System.out.println(item.getSuperclass());
	System.out.println("---------方法--------");
	Method[] methods = item.getMethods();
	for (Method method : methods) {
	    System.out.println(method.getName());
	}
	// OSExecute.command("javap TestEnum");
    }

    /*
     * 枚举描述
     */
    private static void enumDesc() {
	for (Metrics item : Metrics.values()) {
	    System.out.println("-------------------------");
	    System.out
		    .println("compareTo => " + item.compareTo(Metrics.Clicks));
	    System.out.println("equals => " + item.equals(Metrics.Clicks));
	    System.out.println("ordinal => " + item.ordinal());
	    System.out.println("toString => " + item.toString());
	    System.out.println("getClass => " + item.getClass());
	    System.out.println("getDeclaringClass => "
		    + item.getDeclaringClass());
	    System.out.println("name => " + item.name());
	    System.out.println("valueOf => "
		    + Enum.valueOf(Metrics.class, "PV"));
	}

	Enum<?> upperEnum = Metrics.PV;
	System.out.println(Arrays.toString(upperEnum.getClass()
		.getEnumConstants()));
    }
}
