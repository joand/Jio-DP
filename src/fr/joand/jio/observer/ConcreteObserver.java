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
public class ConcreteObserver implements Observer, Runnable {
	private String threadName;
	private Thread thread;

	private ConcreteSubject subject = null;
	private Object state = null;

	public ConcreteObserver(String threadName) {
		this.threadName = threadName;
		this.thread = new Thread(this, this.threadName);
	}

	@Override
	public void update() {
		System.out.println("ConcreteObserver " + threadName + " update()");
		state = subject.getState();
	}

	public ConcreteSubject getSubject() {
		System.out.println("ConcreteObserver getSubject()");
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		System.out
				.println("ConcreteObserver setSubject(ConcreteSubject subject)");
		this.subject = subject;
	}

	public Object getState() {
		System.out.println("ConcreteObserver getState()");
		return state;
	}

	public void setState(Object state) {
		System.out.println("ConcreteObserver setState(Object state)");
		this.state = state;
	}

	public String getThreadName() {
		return threadName;
	}

	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {
		System.out.println("ConcreteObserver " + this.threadName + " run()");
		this.update();
	}

}
