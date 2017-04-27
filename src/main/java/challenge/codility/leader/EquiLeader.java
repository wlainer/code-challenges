package challenge.codility.leader;

import org.junit.Assert;
import org.junit.Test;

public class EquiLeader {

	public int solution(int[] A) {
		 int N = A.length;
	        if (N == 1)
	            return 0;
	        // stores the index of the leader element
	        int[] leaderIndex = new int[N];
	        int value = 0;
	        int size = 0;
	        // using the algorithm in the reading material to find the leader in
	        // O(N) time complexity
	        for (int ele : A) {
	            if (size == 0) {
	                value = ele;
	                size++;
	            } else if (value == ele) {
	                size++;
	            } else
	                size--;
	        }
	        if (size == 0)
	            return 0;
	        int countLeader = 0;
	        for (int i = 0; i < N; i++) {
	            if (A[i] == value) {
	                countLeader++;
	                leaderIndex[i] = 1;
	            }
	        }
	        if (countLeader <= N / 2)
	            return 0;
	        // using prefix sum to calculate the number of leaders before index i in
	        // O(1) time complexity
	        for (int i = 1; i < N; i++) {
	            leaderIndex[i] += leaderIndex[i-1];
	        }
	        int countEquiLeader = 0;
	        // the number of leaders in A[0] A[1] ... A[S] is leaderIndex[i]
	        // the number of leaders in A[S+1] A[S+2] ... A[N-1] is countleader - leaderIndex[i]
	        for (int i = 0; i < N - 1; i++) {
	            if (leaderIndex[i] > (i + 1) / 2 && (countLeader - leaderIndex[i]) > (N - i - 1) / 2)
	                countEquiLeader++;
	        }
	        return countEquiLeader;
	}
	
	
	@Test
	public void test() {
		int[] A = new int[]{4,3,4,4,4,2};
		Assert.assertEquals(solution(A), 2);
	}

}










