package guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

public class DemoTest {
	@Test
	  public void testVerySmallDoubleValues() throws Exception {
	//	Assert.assertTrue(true);
	      RateLimiter rateLimiter = RateLimiter.create(Double.MIN_VALUE);
	      Assert.assertTrue("Should acquire initial permit", rateLimiter.tryAcquire());
	      Assert.assertFalse("Should not acquire additional permit", rateLimiter.tryAcquire());
	      Thread.sleep(6000);
	      Assert.assertFalse("Should acquire new permit after 5 sec,", rateLimiter.tryAcquire());
	 }
		 
}
