package leetcode;

import java.util.Arrays;


/**
 * Write a function to find the longest common prefix String amongst an array of strings
 * 寻找最长的公共前缀
 * @author Administrator
 *
 */
public class leet14 {
	public static String longestCommonPrefix(String[] strs){
		if(strs == null)
			return null;
		if(strs.length == 0)
			return "";
		
		Arrays.sort(strs);
		
		char[] first = strs[0].toCharArray();
		char[] last = strs[strs.length - 1].toCharArray();
		
		int i = 0;
		int len = Math.min(first.length, last.length);
		while(i < len && first[i] == last[i]) i++;
		return strs[0].substring(0, i);
	}
	public static void main(String[] args) {
		String[] strs = {"12398564","123698","123547"};
		System.out.println(longestCommonPrefix(strs));
	}
}
