package david.deepInCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
	private String s;

	public StringAddress(String s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "_" + s;
	}
}

public class FillingList {

	public void fillList() {
		List<StringAddress> copyLs = new ArrayList<StringAddress>(
				Collections.nCopies(2, new StringAddress("daviddai")));
		System.out.println(copyLs.toString());

		Collections.fill(copyLs, new StringAddress("mongodb"));
		System.out.println(copyLs);
	}
}
