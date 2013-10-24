package david.javanio;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.prefs.Preferences;

import javax.swing.event.TreeExpansionEvent;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Serializer;
import david.deepInCollection.AssociateArray;
import david.deepInCollection.CollectionData;
import david.deepInCollection.RandomGen;
import david.javanio.MappedIO.Tester;
import david.util.StringUtil;

public class DemoRun {
	private static FileChannelClass fcc = new FileChannelClass();
	private static ViewBuffers vb = new ViewBuffers();
	private static String persistence_path = "simpleObj.data";
	private static String xml_path = "simpleobj.xml";
	private static String xml_cal_path = "simpleCharCals.xml";
	
	/*
	 * Preferences类使用API保存用户配置，无需关心底层细节, count会随着运行次数的增加而增加
	 */
	public static void preferencesDemo() {
		try {
			Preferences userPrefers= Preferences.userNodeForPackage(DemoRun.class);
			userPrefers.put("teststring", "daviddai");
			userPrefers.putBoolean("testboolean", true);
			userPrefers.putByteArray("testbytes", "testbytes".getBytes());
			userPrefers.putDouble("testdouble", 88.88);
			userPrefers.putFloat("testfloat", 66.66f);
			userPrefers.putInt("testint", 18);
			userPrefers.putLong("testlong", Long.valueOf("88888888888"));
			int runCount = userPrefers.getInt("runcount", 0);
			runCount++;
			userPrefers.putInt("runcount", runCount);
			for (String key : userPrefers.keys()) {
				System.out.println(key + " => " +userPrefers.get(key, null));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 计算字母各个字母数量,使用treeMap自带排序效果
	 */
	public static void countChars() {
		List<String> ls = new ArrayList<String>(new CollectionData<String>(
				new RandomGen(1).getString(), 52));
		Collections.sort(ls);
		Map<String, Integer> hashMap = new TreeMap<String, Integer>();
		for (String item : ls) {
			if (!hashMap.containsKey(item)) {
				hashMap.put(item, 1);
			} else {
				hashMap.put(item, hashMap.get(item) + 1);
			}
		}
		System.out.println(ls.toString());
		StringUtil.printSplitLines();
		System.out.print(hashMap.toString());
		System.out.println();
		StringUtil.printSplitLines();
		Element root = new Element("Chars");
		// root.setNamespaceURI("http://weibo.com/daviddlw/");
		root.addNamespaceDeclaration("david.declaration",
				"http://weibo.com/daviddlw/"); // 添加命名控件声明
		for (String key : hashMap.keySet()) {
			root.appendChild(toCharXml(key, hashMap.get(key).intValue()));
		}
		Document doc = new Document(root);
		try {
			format(System.out, doc);
			format(new BufferedOutputStream(new FileOutputStream(xml_cal_path)),
					doc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static Element toCharXml(String name, Integer value) {
		Element cElement = new Element(name);
		cElement.addAttribute(new Attribute("Count", value.toString()));
		return cElement;
	}

	/*
	 * 读取xml返回实体类集合
	 */
	public static void readFromXmlFile() {
		List<SimpleObject> ls = new ArrayList<SimpleObject>();
		try {
			Document doc = new Builder().build(xml_path);
			Element root = doc.getRootElement();
			Elements elements = root.getChildElements();
			for (int i = 0; i < elements.size(); i++) {
				int id = Integer.valueOf(elements.get(i)
						.getFirstChildElement("Id").getValue());
				String name = elements.get(i).getFirstChildElement("Name")
						.getValue();
				ls.add(new SimpleObject(id, name));
			}
			for (SimpleObject item : ls) {
				System.out.println(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 序列化简单对象
	 */
	public static void serializeSimpleObjectToXml() {
		List<SimpleObject> ls = Arrays.asList(new SimpleObject(1, "daviddai"),
				new SimpleObject(2, "redis"), new SimpleObject(3, "mongodb"));
		Element root = new Element("SimpleObjectList");

		for (SimpleObject item : ls) {
			root.appendChild(toXML(item));
		}

		Document doc = new Document(root);
		try {
			format(System.out, doc);
			format(new BufferedOutputStream(new FileOutputStream(xml_path)),
					doc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static Element toXML(SimpleObject obj) {

		Element so = new Element("SimpleObject");
		Element id = new Element("Id");
		Element name = new Element("Name");
		id.appendChild(String.valueOf(obj.id()));
		name.appendChild(obj.name());
		Element objType = new Element("SimpleType");
		Element type = new Element("Type");
		type.appendChild(obj.simpleType().type());
		objType.appendChild(type);

		so.appendChild(id);
		so.appendChild(name);
		so.appendChild(objType);

		return so;
	}

	/*
	 * 格式化xml数据
	 */
	private static void format(OutputStream out, Document doc) throws Exception {
		Serializer serializer = new Serializer(out, "GBK");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	public static void serialObjectDemo() {
		serializeObject();
		serializeObjectByExternal();
	}

	/*
	 * 通过实现Externalizable接口实现序列化，需要自己重写readExternal与writeExternal方法
	 */
	public static void serializeObjectByExternal() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(persistence_path));
			out.writeObject(new SimpleObjectExternal(1, "daviddai"));
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					persistence_path));
			SimpleObjectExternal soe = (SimpleObjectExternal) in.readObject();
			in.close();
			System.out.println(soe.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 测试序列化简单对象
	 */
	public static void serializeObject() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(persistence_path));

			out.writeObject(new SimpleObject(1, "daviddai"));
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					persistence_path));

			SimpleObject obj = (SimpleObject) in.readObject();
			in.close();
			System.out.println(obj.toString());

			// System.out.println("---------------序列化数组----------------");
			// String persistence_array_path = "simpleArrayObj.data";
			// ObjectOutputStream outArr = new ObjectOutputStream(
			// new FileOutputStream(persistence_array_path));
			// outArr.writeObject(new SimpleObject[] {
			// new SimpleObject(2, "mongodb"),
			// new SimpleObject(3, "redis") });
			// outArr.close();
			//
			// ObjectInputStream inArr = new ObjectInputStream(new
			// FileInputStream(
			// persistence_path));
			//
			// SimpleObject[] objArr = (SimpleObject[]) inArr.readObject();
			// inArr.close();
			// for (SimpleObject item : objArr) {
			// System.out.println(item);
			// }

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void zipCompressDemo() {
		try {
			ZipCompress.zipCompress();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void lockingMappedFileDemo() {
		try {
			LockingMappedFile.fc = new RandomAccessFile("lock.dat", "rw")
					.getChannel();
			MappedByteBuffer out = LockingMappedFile.fc.map(MapMode.READ_WRITE,
					0, LockingMappedFile.LENGTH);
			for (int i = 0; i < LockingMappedFile.LENGTH; i++) {
				out.put((byte) 'x');
			}
			System.out.println(String.format("%d~%d", 0,
					LockingMappedFile.LENGTH / 3));
			System.out.println(String.format("%d~%d",
					LockingMappedFile.LENGTH / 2, LockingMappedFile.LENGTH / 2
							+ LockingMappedFile.LENGTH / 4));

			new LockingMappedFile.LockAndModify(out, 0,
					LockingMappedFile.LENGTH / 3);

			new LockingMappedFile.LockAndModify(out,
					LockingMappedFile.LENGTH / 2, LockingMappedFile.LENGTH / 2
							+ LockingMappedFile.LENGTH / 4);

			// LockingMappedFile.fc.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void testFramework() {
		for (Tester test : MappedIO.Tester.tests) {
			test.runTest();
		}
	}

	public static void readFileByChannel() {
		new FileChannelClass().readFileByChannel();
	}

	public static void executeBufferPutAndGet() {
		fcc.bufferPutAndGet();
	}

	public static void executeIntBufferPutAndGet() {
		fcc.intBufferPutAndGet();
	}

	public static void viewBuffersDemo() {
		vb.viewBuffers();
	}

	public static void bigEndianOrlittleEndianDemo() {
		vb.bigEndianOrLittleEndian();
	}

	public static void switchNeighborByteElementDemo() {
		vb.switchNeighborByteElement();
	}

	public static void getChannel() {
		try {
			fcc.getChannelDemo();
			// fc.getChannelByCharBufferDemo();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void byteBufferSlice() {
		ByteBuffer buffer = ByteBuffer.wrap("this is a buffer string"
				.getBytes());
		System.out.println(buffer.capacity());
		buffer.position(5);
		System.out.println(buffer.slice().capacity()); // slice为当前limit/capacity
		// - position
	}

	public static void covertToInt() {
		Integer i = Integer.valueOf("8888");
		System.out.println(i);
	}
}
