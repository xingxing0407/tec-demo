package leetcode;

import java.util.Arrays;

/**
 * ��һ�����飬�����ҳ�3��������ʹ�����������ĺ���ӽ�������Ŀ������
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class leet16 {
	public static int threeSumClosest(int[] nums,int target){
		int result = 0;
		int d;
		int minD = Integer.MAX_VALUE;
		
		int len = nums.length;
		Arrays.sort(nums);
		for(int i=0;i<len; i++){
			int high = len - 1;
			int low = i + 1;
			
			while(low < high){
				int sum = nums[i] + nums[low] + nums[high];
				
				d = Math.abs(sum - target);
				
				if(d == 0){
					return sum;
				}else if(d <= minD){
					minD = d;
					result = sum;
				}
				
				if(sum <= target){
					low ++;
				}else{
					high --;
				}
			}
		}
		return result;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(threeSumClosest(nums,1));
	}

}
