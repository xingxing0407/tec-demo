package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	Return all such possible sentences.
	
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
	
	A solution is ["cats and dog", "cat sand dog"].
	
	
 * @author Administrator
 *
 */
public class WordBreakII140 {
	public static boolean wordBreakcheck(String s ,Set<String> dict){
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for(int i=0;i<s.length();i++){
			StringBuffer str = new StringBuffer(s.substring(0, i + 1));
			for(int j=0;j<=i;j++){
				
				if(res[j] && dict.contains(str.toString())){
					res[i + 1] = true;
					break;
				}
				
				str.deleteCharAt(0);
				
			}
		}
		return res[s.length()];
	}
	public static List<String> wordBreak(String s,Set<String> wordDict){
		ArrayList<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return res;
		if(wordBreakcheck(s,wordDict)){
			helper(s,wordDict,0,"",res);
		}
		return res;
	}
	private static void helper(String s, Set<String> wordDict, int start,
			String item, ArrayList<String> res) {
		if(start >= s.length()){
			res.add(item);
			return;
		}
		
		StringBuffer str = new StringBuffer();
		for(int i=start;i<s.length();i++){
			str.append(s.charAt(i));
			if(wordDict.contains(str.toString())){
				String newItem = new String();
				if(item.length() > 0){
					newItem = item + " " + str.toString();
				}else{
					newItem = str.toString();
				}
				helper(s, wordDict, start, newItem, res);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
