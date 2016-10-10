package javaapi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 */
public class RefectDemo {
	/**
	 * 通过一个对象获取完整包名和类名
	 * @return
	 */
	public String demo1(){
		RefDemo refDemo = new RefDemo();
		String name = refDemo.getClass().getName();
		System.out.println(name);
		return name;
	}
	
	/**
	 * 所有实例都是class对象
	 */
	public void demo2(){
		Class<?> cls1 = null;
		Class<?> cls2 = null;
		Class<?> cls3 = null;
		
		try {
			cls1 = Class.forName("javaapi.reflect.RefDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		cls2 = new RefDemo().getClass();
		
		cls3 = RefDemo.class;
		
		System.out.println(cls1.getName());
		System.out.println(cls2.getName());
		System.out.println(cls3.getName());
	}
	
	/**
	 * 通过class调用其它类的构造函数
	 */
	public void demo3(){
		Class<?> person = null;
		
		try {
			person = Class.forName("javaapi.reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person.getName());
		Person per1 = null;
		Person per2 = null;
		Person per3 = null;
		Person per4 = null;
		try {
			Constructor<?> cons[] = person.getConstructors();
			System.out.println(Arrays.toString(cons));//Constructor<?> cons[]=demo.getConstructors()
													//中对Person的构造函数进行倒叙封装的
			per4 = (Person)cons[0].newInstance("mmm",6556);
			per1 = (Person)cons[1].newInstance(45);
			per2 = (Person)cons[2].newInstance("nnnn");
			per3 = (Person)cons[3].newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(per1);
		System.out.println(per2);
		System.out.println(per3);
		System.out.println(per4);
		
	}
	/**
	 * 通过反射调用其他类中的方法
	 * public Object invoke(Object obj,Object args[])
	 * 1.obj - 从中调用底层的方法  必须是实例化的对象
	 * 2.args[] 调用方法的参数，可以是多个
	 * 注意：1.args[] 可以为空，表示方法没有参数
	 *     2.obj 可以为空，但必须为null 表示同类中的公用方法(不理解)
	 */
	public void demo4(){
		Class<?> person = null;
		
		try {
			person = Class.forName("javaapi.reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Method method = person.getMethod("sayChina");
			method.invoke(person.newInstance());
			
			
			method = person.getMethod("sayHello", String.class,int.class);
			String result = (String)method.invoke(person.newInstance(),"sayHello",20);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RefectDemo d = new RefectDemo();
		//d.demo2();
		d.demo4();
	}

}

class RefDemo{
	
}

class Person{
	private String name;
	private int age;
	public Person() {
    }
    public Person(String name){
        this.name=name;
    }
    public Person(int age){
        this.age=age;
    }
    public Person(String name, int age) {
        this.age=age;
        this.name=name;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void sayChina(){
		System.out.println("sayChina");
	}
	
	public String sayHello(String str,int m){
		System.out.println(str + m);
		return str + m;
	}
	public void demo3(){
		System.out.println("demo3");
	}
}
