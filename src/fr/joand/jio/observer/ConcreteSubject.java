/*
Copyright (c) 2012, Joel ANDRIAMANAMPISOA joelandria@gmail.com
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted
provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions
and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
and the following disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR 
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package fr.joand.jio.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Java implementation of Observer
 * 
 * "Define a one-to-many dependency between objects so that when one object
 * changes state, all its dependents are notified and updated automatically."
 * 
 * You can find others Java implementation of design patterns on github
 * https://github.com/joand/Jio-DP
 * 
 * @author Joel ANDRIAMANAMPISOA joelandria@gmail.com
 * */
public class ConcreteSubject implements Subject {

	private List<Observer> observers;

	private Object state;

	public ConcreteSubject() {
		System.out.println("ConcreteSubject()");
		observers = new ArrayList<Observer>();
		state = null;
	}

	@Override
	public boolean attach(Observer newObserver) {
		System.out.println("ConcreteSubject attach(Observer newObserver)");
		newObserver.setSubject(this);
		return observers.add(newObserver);
	}

	@Override
	public boolean detach(Observer observer) {
		System.out.println("ConcreteSubject detach(Observer observer)");
		return observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println("ConcreteSubject notifyObservers()");
		for (Observer observer : observers) {
			// observer.update();
			observer.getThread().start();
		}
	}

	public Object getState() {
		System.out.println("ConcreteSubject getState()");
		return state;
	}

	// Observers must not access this method, only controllers can (MVC)
	private void setState(Object state) {
		System.out.println("ConcreteSubject setState(Object state)");
		this.state = state;
		notifyObservers();
	}

	@Override
	public List<Observer> getObservers() {
		System.out.println("ConcreteSubject getObservers()");
		return this.observers;
	}

}
