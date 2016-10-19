package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the nums of zero.
 *  
 *  问题：在数字里查找相加为0的三个数
 * 
 *  输出：例如
 *  [
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 * @author Administrator
 *
 */
public class leet15 {
	
	public static List<List<Integer>> threenums1(int[] nums){
		
		HashSet<List<Integer>> s = new HashSet<List<Integer>>();
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		
		 if(nums.length<3||nums == null)
           return result;
		
		Arrays.sort(nums);
		
		for (int i = 0;i <= nums.length - 3;i++){
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high){
				int sum = nums[i] + nums[high] + nums[low];
				if(sum == 0){
					ArrayList<Integer> unit = new ArrayList<Integer>();
					unit.add(nums[i]);
					unit.add(nums[low]);
					unit.add(nums[high]);
					
					if(!s.contains(unit)){
						s.add(unit);
						result.add(unit);
					}
					
					low ++;
					high --;
				}else if (sum > 0){
					high --;
				}else{
					low ++;
				}
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,0};
		
		List<List<Integer>> threenums = threenums1(nums);
		
		System.out.println(JSON.toJSON(threenums));
	}
}
