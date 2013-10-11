package david.generic;

public class TwoTuple<Benz, String> {
	public final Benz first;
	public final String second;
	
	public TwoTuple(Benz a, String b){
		this.first = a;
		this.second = b;
	}
	
	@Override
	public java.lang.String toString() {
		// TODO Auto-generated method stub
		return first.toString() + "_" + second.toString();
	}
}
