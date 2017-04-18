package codility.timecomplexity;



import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {
	
	public int solution(int X, int Y, int D) {
		if (X > Y)
			return 0;

		double ceil = Math.ceil((Y - X) / Double.valueOf(D));

		return (int) ceil;

	}
	 
	 @Test
	 public void test() {
		 int X = 10;
		 int Y = 85;
		 int D = 30;
		 
		 Assert.assertEquals(solution(X, Y, D), 3);
		 
	 }
	 
	 

	
	
}
