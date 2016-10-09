
package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bTraceDemo{
	
	
    public int  add (int a, int b) {
    	System.out.println("1111111111111111111");
    	
        return a+b;
    }
    
    public static void main(String[] argStrings) throws IOException{
        
    	bTraceDemo bTraceTest = new bTraceDemo();
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int a = (int)Math.round(Math.random()*1000);
            int b = (int)Math.round(Math.random()*1000);
         //   System.out.println(bTraceTest.add(a, b));
            for(int i=100000;i>0;i--);
        }
        
    }
}

/* BTrace Script Template 
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {
     put your code here 
    @OnMethod(
        clazz="demo.bTraceDemo",
        method="add",
        location=@Location(Kind.RETURN)
    )
    public static void func(@Self demo.bTraceDemo instance, int a, int b, @Return int result)
    {
        println(strcat("方法结果: ",str(result)));
    }
    
}*/