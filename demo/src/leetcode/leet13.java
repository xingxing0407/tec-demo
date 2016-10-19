package leetcode;

import java.util.Date;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 * 将罗马数字转换成数字
 * @author Administrator
 *
 */
public class leet13 {
	/**
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s){
		
		int res = 0;
		for(int i=s.length()-1;i>=0;i--){
			char c = s.charAt(i);
			switch (c){
			case 'I':
				res += (res >= 5 ? -1:1);
				break;
			case 'V':
				res += 5;
				break;
			case 'X':
				res += 10 * (res >= 50 ? -1:1);
				break;
			case 'L':
				res += 50;
				break;
			case 'C':
				res += 100 * (res >= 500?-1 : 1);
				break;
			case 'D':
				res += 500;
				break;
			case 'M':
				res += 1000;
				break;
			}
		}
		
		return res;
	}
	@Test(timeout=5)
	public void testDemo(){
		romanToInt("MMMDLXXXVI");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date s = new Date();
		System.out.println(romanToInt("MMMDLXXXVI"));
		Date e = new Date();
		System.out.println(e.getTime());
		System.out.println(e.getTime() - s.getTime());
	}

}
