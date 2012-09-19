package fr.joand.jio.observer;

public interface Observer {
	public void update();

	public void setSubject(ConcreteSubject subject);
}
