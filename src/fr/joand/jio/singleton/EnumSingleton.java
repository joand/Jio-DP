package fr.joand.jio.singleton;

/** Source : http://stackoverflow.com/questions/10250799/regarding-singleton-design-pattern
 * */
public enum EnumSingleton {
	/** Implicitly declared as 
	 * 	public static final EnumSingleton
	 * */
	INSTANCE;
	
	private Object singletonData;

	public Object getSingletonData() {
		return singletonData;
	}

	public void setSingletonData(Object singletonData) {
		this.singletonData = singletonData;
	}
	
	/** Operation(s) on singletonData */
	public void singletonOperation(Object singletonData){
		// Do whatever you want here
		this.setSingletonData(singletonData);
	}
}
