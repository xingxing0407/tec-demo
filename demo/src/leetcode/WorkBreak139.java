package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	给定一个字典和一个字符串，能否切分字符串使得所有的字符串都在字典里面
 * @author Administrator
 *
 */
public class WorkBreak139 {
	public static boolean wordBreak(String s,Set<String> wordDict){
		
		if(s == null || s.length() == 0){
			return true;
		}
		
		boolean[] res = new boolean[s.length() + 1];
		
		res[0] = true;
		
		for(int i=0;i<s.length();i++){
			StringBuffer str = new StringBuffer(s.substring(0, i+1));
			for(int j=0;j<=i;j++){
				if(res[j] && wordDict.contains(str.toString())){
					res[i+1] = true;
					break;
				}
				
				str.deleteCharAt(0);
			}
		}
		
		return res[s.length()];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		System.out.println(wordBreak("leetcode",set));
	}

}
