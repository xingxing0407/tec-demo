package leetcode;
/**
 * Determine whether an integer is a palindrome,Do this whisout extra space
 * 判断整形数值是不是回文
 * @author Administrator
 *
 */
public class leet9 {
	public static boolean isPalindrome(int x){
		if(x < 0 || (x!=0 && x%10 == 0))
			return false;
		
		if(x == 0){
			return true;
		}
		
		long v = 0;
		int y = x;
		while(x != 0){
			v = v*10 + x%10;
		
			x = x/10;
		}
		
		if(v > Integer.MAX_VALUE){
			return false;
		}
		
		if((int)v == y){
			return true;
		}else{
			return false;
		}
	}
		public static boolean isPalindrome1(int x){
			if(x < 0 || (x!=0 && x%10 == 0))
				return false;
			
			if(x == 0){
				return true;
			}
			
			int v = 0;
			while(x != 0){
				v = v*10 + x%10;
				x = x/10;
				if(v >= x)
					break;
			}
			
			if(v > Integer.MAX_VALUE){
				return false;
			}
			
			if(v == x || v/10 == x){
				return true;
			}else{
				return false;
			}
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome1(123456));
		System.out.println(isPalindrome1(123321));
		System.out.println(isPalindrome1(12321));
		System.out.println(isPalindrome1(1234554321));
	}
}
