package leetcode;

public class leet11 {
	public static int maxArea(int[] height){
		int result = 0;
		for (int i=0;i<height.length;i++){
			int height1 = height[i];
			for (int j=i+1;j<height.length;j++){
				int height2 = height[j];
				int area = height1 >= height2?(j-i)*height2:(j-i)*height1;
				if(result <= area)
					result = area;
			}
		}
		return result;
	}
	
	public static int maxArea1(int[] height){
		int i = 0;
		int j = height.length - 1;
		int area = 0;
		int result = 0;
		while(j >= i){
			area = height[i] >= (height[j])?(j - i)*height[j]:(j - i)*height[i];
			if(area >= result)
				result = area;
			if(height[i] <= height[j]){
				i++;
			}else{
				j--;
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {1,2,3,5,4,8,5,7,4,5};
		System.out.println(num.length);
		System.out.println(maxArea1(num));
	}

}
