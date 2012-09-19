package fr.joand.jio.singleton;

/** Java implementation of Singleton
 * 
 * 	This design pattern ensure that a class have only one instance.
 * 
 * 	You can find others design patterns on github
 *  https://github.com/joand/Jio-DP 
 * 	@author Joel ANDRIAMANAMPISOA joelandria@gmail.com
 * */
public class Singleton {
	
	/** The Singleton's single instance */
	private static Singleton instance = null;
	/** The Singleton's data - You can use anything you want here */
	private Object singletonData;
	
	/** The protected constructor */
	private Singleton(){
		this.singletonData = null;
	}
	/** From outside, the only way to retrieve the Singleton's instance */
	synchronized public static Singleton getInstance() {
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

	/** The singletonData's getter */
	public Object getSingletonData() {
		return this.singletonData;
	}
	/** The singletonData's setter */
	private void setSingletonData(Object singletonData) {
		this.singletonData = singletonData;
	}
	
	/** Operation(s) on singletonData */
	public void singletonOperation(Object singletonData){
		// Do whatever you want here
		this.setSingletonData(singletonData);
	}
	
}
