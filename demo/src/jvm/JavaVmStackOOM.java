package jvm;

import java.util.ArrayList;
import java.util.List;

public class JavaVmStackOOM {
	
	private void dontStop(){
		while(true){
			
		}
	}
	public static void main(String[] args) {
		List list = new ArrayList<String>();
		int i  = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}

}
