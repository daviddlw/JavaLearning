package david.generic;

public class BoundGenericAction {

	public <T extends IFly> void genericFly(T flyAction) {
		flyAction.fly();
	}

	public <T extends IRun> void genericRun(T runAction) {
		runAction.run();
	}

	public <T extends ISwim> void genericSwim(T swinAction) {
		swinAction.swin();
	}
}
