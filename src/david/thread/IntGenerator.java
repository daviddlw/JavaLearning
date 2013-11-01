package david.thread;

public abstract class IntGenerator {

	private volatile boolean isCancel = false;

	public abstract int next();

	public boolean isCanceled() {
		return isCancel;
	}

	public void cancel() {
		isCancel = true;
	}
}
