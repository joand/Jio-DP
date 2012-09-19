package fr.joand.jio.observer;

public class ConcreteSubject implements Subject {

	private Object state = null;

	public ConcreteSubject() {

	}

	@Override
	public boolean attach(Observer newObserver) {
		newObserver.setSubject(this);
		return observers.add(newObserver);
	}

	@Override
	public boolean detach(Observer observer) {
		return observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public Object getState() {
		return state;
	}

	// Observers must not access this method, only controllers can (MVC)
	private void setState(Object state) {
		this.state = state;
	}

}
