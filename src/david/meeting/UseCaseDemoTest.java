package david.meeting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import david.model.Student;

public class UseCaseDemoTest {

    private UseCaseDemo useCaseDemo = new UseCaseDemo();

    @Before
    public void setUp() throws Exception {
	useCaseDemo.clear();
    }

    @Test
    public void testAdd() {
	useCaseDemo.add(2);
	useCaseDemo.add(3);
	int num = useCaseDemo.result();
	int target = 5;
	// assertTrue(num == target);
	assertTrue(String.format("num: %d, target: %d", num, target),
		num == target);
    }

    @Test
    public void testSubstract() {
	useCaseDemo.add(10);
	useCaseDemo.substract(2);
	int num = useCaseDemo.result();
	assertTrue(num == 8);
    }

    @Test
    @Ignore("该方法还未实现")
    public void testMutiply() {

    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivide() {
	useCaseDemo.divide(9, 3);
	int num = useCaseDemo.result();
	assertEquals(num, 3);

	useCaseDemo.divide(9, 0);
	int num2 = useCaseDemo.result();
	assertEquals(num2, 0);
    }

    @Test(timeout = 1000)
    public void testSquare() {
	useCaseDemo.square();
    }

    @Test
    public void testObject() {
	Student a = new Student("daviddai");
	Student b = new Student("daviddai");
	Student c = a;
	System.out.println(a.hashCode() + "|" + b.hashCode() + "|"
		+ c.hashCode());
	// assertSame(a.toString() + "|" + b.toString(), a, b);
	assertSame(a, c);
    }

    @Test
    public void testArray() {
	// assertArrayEquals(new int[] { 1 }, new int[] { 1 });
	// assertArrayEquals(new String[] { "1" }, new String[] { "1" });
	Student a = new Student("daviddai");
	Student b = new Student("daviddai");
	Student c = a;
	assertArrayEquals(new Student[] { a }, new Student[] { c });
    }
}
