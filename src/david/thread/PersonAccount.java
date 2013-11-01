package david.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class PersonAccount implements Runnable {
	private volatile static int balance = 500;
	private ReentrantLock lock = new ReentrantLock();

	public void init() {
		balance = 500;
	}

	public PersonAccount() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 支付方法
	 */
	public void pay(int num) {
		lock.lock();
		balance = balance - num;
		lock.unlock();
		Thread.yield();
	}

	/*
	 * 充值
	 */
	public void recharge(int num) {
		lock.lock();
		balance = balance + num;
		lock.unlock();
		Thread.yield();
	}

	@Override
	public void run() {
		Random rand = new Random();
		Random randMoney = new Random();
		// TODO Auto-generated method stub
		while (balance > 0) {
			boolean isPay = rand.nextInt() % 2 == 0; // 随机数判断是支付还是充值
			if (isPay) {
				int num = randMoney.nextInt(100);
				pay(num);
				System.out.println(Thread.currentThread().getName() + "=>支付了"
						+ num + ",余额为" + balance);
			} else {
				int num = randMoney.nextInt(100);
				recharge(num);
				System.out.println(Thread.currentThread().getName() + "=>充值了"
						+ num + ",余额为" + balance);
			}
		}
		System.out.println(Thread.currentThread().getName()
				+ "=>当前个人账户余额不足....剩下" + balance + "元");
	}
}
