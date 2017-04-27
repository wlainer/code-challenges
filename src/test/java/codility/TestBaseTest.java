package codility;

import org.junit.Assert;
import org.junit.Test;

import challenge.TestBase;

public class TestBaseTest {
	
	@Test
	public void shouldRunTest() {
		TestBase test1 = new TestBase();
		Object run = test1.run();
		
		Assert.assertEquals(run, "Hello");
		
	}

}
