package david.thread;

public class Money {
    private volatile int balance;

    public Money(int balance) {
	// TODO Auto-generated constructor stub
	this.balance = balance;
    }

    public int getBalance() {
	return balance;
    }
}
