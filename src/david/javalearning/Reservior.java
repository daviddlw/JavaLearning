package david.javalearning;

public class Reservior {
	public int total = 0;

	public Reservior(int total) {
		this.total = total;
	}

	/*
	 * ���������Ʊ�ͽ�������
	 */
	public synchronized boolean sellTickets() {
		if (this.total > 0) {
			this.total = this.total - 1;
			return true;
		} else {
			return false;
		}
	}
}
