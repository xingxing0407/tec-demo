package leetcode;
/**
 * 题目：int类型数值反转     eg:input  123     output  321
 * 					  input -561     output  -156
 * 注意：1.输入为0的时候输出也为0
 * 	   2.输入数据超过int类型范围时输出为0
 * @author Administrator
 *
 */
public class leet7 {
	public static Integer reverse(int x){
		long result = 0;
		while(x != 0){
			result =  result * 10 + x%10;
			x = x / 10;
		}
		System.out.println(result);
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
			return 0;
		}
		return (int)result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
