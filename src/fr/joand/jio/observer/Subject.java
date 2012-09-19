package fr.joand.jio.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

	public List<Observer> observers = new ArrayList<Observer>();

	public boolean attach(Observer newObserver);

	public boolean detach(Observer observer);

	public void notifyObservers();

}
