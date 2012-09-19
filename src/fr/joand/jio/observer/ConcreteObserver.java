package fr.joand.jio.observer;

public class ConcreteObserver implements Observer {

	private ConcreteSubject subject = null;
	private Object state = null;
	
	@Override
	public void update() {
		state = subject.getState();
	}

	public ConcreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}

	
}
