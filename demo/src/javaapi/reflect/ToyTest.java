package javaapi.reflect;
/**
 * java 编程思想 中文第四版  P316 
 * @author Administrator
 *
 */
public class ToyTest {
	static void printInfo(Class cc){
		System.out.println("Class name:" + cc.getName());

		System.out.println("is interface :" + cc.isInterface());

		System.out.println("simple name:" + cc.getSimpleName());
		

		System.out.println("canonical name:" + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("javaapi.reflect.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("can not find fancyToy");
			System.exit(1);
		}
		
		printInfo(c);
		
		for(Class face : c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		
		Object obj = null;
		
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("can not instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("can not access");
			System.exit(1);
		}
		
		printInfo(obj.getClass());
	}

}
