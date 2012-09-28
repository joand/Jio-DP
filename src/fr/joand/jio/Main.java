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
package fr.joand.jio;

import fr.joand.jio.adapter.AdapterComposition;
import fr.joand.jio.adapter.AdapterInheritance;
import fr.joand.jio.adapter.Client;
import fr.joand.jio.adapter.Target;
import fr.joand.jio.observer.ConcreteObserver;
import fr.joand.jio.observer.ConcreteSubject;
import fr.joand.jio.observer.Subject;
import fr.joand.jio.singleton.EnumSingleton;
import fr.joand.jio.singleton.Singleton;

public class Main {

	/**
	 * I will use the main method to showcase how I use the design patterns (in
	 * a really simplistic way ...)
	 * 
	 * @author Joel ANDRIAMANAMPISOA joelandria@gmail.com
	 * @param args
	 */
	public static void main(String[] args) {
		// ADAPTER
		System.out.println("********* ADAPTER *********\n");

		Target target = new AdapterComposition();
		Client client = new Client(target);
		client.getTarget().request();

		target = new AdapterInheritance();
		client = new Client(target);
		client.getTarget().request();

		// OBSERVER
		System.out.println("********* OBSERVER *********\n");

		Subject subject = new ConcreteSubject();
		for (int index = 0; index < 3; index++) {
			// This method will also setSubject(...)
			subject.attach(new ConcreteObserver());
		}

		subject.notifyObservers();

		// SINGLETON
		System.out.println("********* SINGLETON *********\n");

		Singleton singleton = Singleton.getInstance();
		singleton.singletonOperation("SomeData");

		// This cannont be done : 
		// singleton = new Singleton();
		
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.singletonOperation("SomeData");

		// This cannont be done : 		
		// enumSingleton = new EnumSingleton();
	}

}
