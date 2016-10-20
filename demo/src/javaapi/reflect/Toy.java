package javaapi.reflect;

/**
 * java 编程思想 中文第四版  P316 
 *
 */
interface HasBatteris{}
interface Waterproff{}
interface Shoots{}
public class Toy {
	
	Toy(){}
	Toy(int i){}
	public static void main(String[] args) {

	}

}

class FancyToy extends Toy implements HasBatteris,Waterproff,Shoots{
	FancyToy(){super(1);}
}
