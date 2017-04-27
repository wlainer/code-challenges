package challenge.others;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

import challenge.TestInterface;

public class Test2 implements TestInterface {

	@Override
	public Object run() {
		Test2 test2 = new Test2();
		return null;

	}

	 public int solution(Point3D[] A) {
	        BitSet results = new BitSet();
	        for(int i=0;i<A.length;i++) {
	        	int total = (int) (Math.pow(A[i].x, 2) + Math.pow(A[i].y, 2) + Math.pow(A[i].z, 2));
	            results.set(total);
	        }
	        return results.cardinality();
	    }
	    public static void main(String[] args) {
	    	Test2 solution = new Test2();
	        Point3D[] ex1 = new Point3D[] {
	            new Point3D( 0, 5, 4),
	            new Point3D( 0, 0,-3),
	            new Point3D(-2, 1,-6),
	            new Point3D( 1,-2, 2),
	            new Point3D( 1, 1, 1),
	            new Point3D( 4,-4, 3)
	        };
	        int result = solution.solution(ex1);
	        System.out.println(result);
	    }
}

class Point3D {
	public int x;
	public int y;
	public int z;
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
