package david.thread;

public class SerialNumberChecker implements Runnable {
	private CircularSet cs = new CircularSet(10000);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			int serial = new SerialNumberGenerator().next();
			if(cs.contains(serial)){
				System.out.println("”–÷ÿ∏¥÷µ"+serial);
				System.exit(0);
			}
			cs.add(serial);
		}		
	}

}
