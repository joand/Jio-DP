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
package fr.joand.jio.singleton;

/**
 * Java implementation of Singleton
 * 
 * "This design pattern ensure that a class have only one instance."
 * 
 * Source :
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 * 
 * You can find others design patterns on github https://github.com/joand/Jio-DP
 * 
 * @author Joel ANDRIAMANAMPISOA joelandria@gmail.com
 * */
public class Singleton {

	/** The Singleton's data - You can use anything you want here */
	private Object singletonData;

	/** The Singleton's single instance */
	private static volatile Singleton instance = null;

	/** The not so visible constructor */
	private Singleton() {
		System.out.println("Singleton()");
		this.singletonData = null;
	}

	/** From outside, the only way to retrieve the Singleton's instance */
	public static Singleton getInstance() {
		System.out.println("Singleton getInstance()");
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out.println("Singleton instance = new Singleton()");
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	/** The singletonData's getter */
	public Object getSingletonData() {
		System.out.println("Singleton getSingletonData()");
		return this.singletonData;
	}

	/** The singletonData's setter */
	private void setSingletonData(Object singletonData) {
		System.out.println("Singleton setSingletonData(Object singletonData)");
		this.singletonData = singletonData;
	}

	/** Operation(s) on singletonData */
	public void singletonOperation(Object singletonData) {
		System.out
				.println("Singleton singletonOperation(Object singletonData)");
		// Do whatever you want here
		this.setSingletonData(singletonData);
	}

}
