package david.generic;

public class FourTuple<Benz, String, Cadillac, Ford> extends ThreeTuple<Benz, String, Cadillac> {

	public final Ford fourth;
	
	public FourTuple(Benz a, String b, Cadillac c, Ford d) {
		super(a, b, c);
		this.fourth = d;
	}
	
	@Override
	public java.lang.String toString() {
		// TODO Auto-generated method stub
		return first.toString() + "_" + second.toString() + "_" + third.toString();
	}

}
