package junitdemo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TestAssertThat {
	@Test
	public void testDemo(){
		int num = 6;
		Assert.assertThat(num,Matchers.is(8));
		
	}
}
