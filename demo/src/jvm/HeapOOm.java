package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOm {
	static class OOMObject{
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
		
	}

}
