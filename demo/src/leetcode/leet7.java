package leetcode;
/**
 * ��Ŀ��int������ֵ��ת     eg:input  123     output  321
 * 					  input -561     output  -156
 * ע�⣺1.����Ϊ0��ʱ�����ҲΪ0
 * 	   2.�������ݳ���int���ͷ�Χʱ���Ϊ0
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
