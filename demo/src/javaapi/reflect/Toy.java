package javaapi.reflect;

/**
 * java ���˼�� ���ĵ��İ�  P316 
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
