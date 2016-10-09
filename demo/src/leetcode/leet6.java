package leetcode;

public class leet6 {
	public String convert(String s ,int row){
		if (row == 1){
			return s;
		}
		int offset = 2 * row - 2;
		StringBuffer result = new StringBuffer();
		for(int i=0;i<row;i++){
			
			for (int j=0;j*offset + i < s.length();j++){
				
				result.append(s.charAt(j * offset + i));
				
				if(i != 0 && i != row - 1 && (j+1)*offset - i < s.length()){
					result.append(s.charAt((j+1)* offset - i ));
				}
				
			}
			
			
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		leet6 leet = new leet6();
		String convert = leet.convert("0123456789", 3);
		System.out.println(convert);
	}
}
