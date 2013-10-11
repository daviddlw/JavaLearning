package david.generic;

public class ThreeTuple<Benz, String, Cadillac> extends TwoTuple<Benz, String> {
	public final Cadillac third;
	
	public ThreeTuple(Benz a, String b, Cadillac c) {
		super(a, b);
		this.third = c;
	}
	
	@Override
	public java.lang.String toString() {
		// TODO Auto-generated method stub
		return first.toString() + "_" + second.toString() + "_" + third.toString();
	}

}
