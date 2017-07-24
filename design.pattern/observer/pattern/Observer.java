package observer.pattern;

public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
