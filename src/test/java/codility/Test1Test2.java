package codility;

import org.junit.Assert;
import org.junit.Test;

public class Test1Test2 {
	
	@Test
	public void shouldRunTest() {
		TestBase test1 = new TestBase();
		Object run = test1.run();
		
		Assert.assertEquals(run, "Hello");
		
	}

}
