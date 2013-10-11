package david.generic;

/*
 * Ôª×éÀà
 */
public class TupleTest {
	public static TwoTuple<Benz, String> twoTuple() {
		return new TwoTuple<Benz, String>(new Benz("david.dai", 100),
				"david_string");
	}

	public static ThreeTuple<Benz, String, Cadillac> threeTuple() {
		return new ThreeTuple<Benz, String, Cadillac>(
				new Benz("david.dai", 200), "david_string", new Cadillac(
						"hellokitty", 300));
	}

	public static FourTuple<Benz, String, Cadillac, Ford> fourTuple() {
		return new FourTuple<Benz, String, Cadillac, Ford>(new Benz(
				"david.dai", 400), "david_string", new Cadillac("hellokitty",
				500), new Ford("ford_car", 600));
	}
}
