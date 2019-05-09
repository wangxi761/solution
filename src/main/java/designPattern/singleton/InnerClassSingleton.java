package designPattern.singleton;

public class InnerClassSingleton {
	private InnerClassSingleton() {}
	private static class InnerClassSingletonBuilder {
		public static final InnerClassSingleton instance=new InnerClassSingleton();
	}
	public static InnerClassSingleton getInstance() {
		return InnerClassSingletonBuilder.instance;
	}
}
