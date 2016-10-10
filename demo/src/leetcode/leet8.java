package leetcode;
/**
 * 题目：实现atoi函数      字符串转换成整形数字
 * 
 * 注意：各种边界条件的判断
 * @author Administrator
 *
 */
public class leet8 {
	public static int myAtoi(String str){
		
		if(str == "" || str.length() < 1){
			return 0;
		}
		
		str = str.trim();
		
		char flag = '+';
		
		int i = 0;
		if(str.charAt(0) == '-'){
			flag = '-';
			i++;
		}else if(str.charAt(0) == '+'){
			i++;
		}
		
		double result = 0;
		
		while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
			result = result * 10 + (str.charAt(i) - '0');
			i++;
			
		}
		
		if(flag == '-'){
			result = -result;
		}
		
		if(result > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}
		
		if(result < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("fsdfas"));
		System.out.println(myAtoi("45654"));
		System.out.println(myAtoi("0"));
		System.out.println(myAtoi("133213218888"));
	}
}
