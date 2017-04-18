package codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class GenomicRangeQuery {
	
	public int[] solution(String S, int[] P, int[] Q) {
		
		int N = S.length();
		int M = P.length;
		
		int[] posOfA = new int[N+1]; 
		int[] posOfC = new int[N+1]; 
		int[] posOfG = new int[N+1]; 
		int[] posOfT = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			switch (S.charAt(i)) {
			case 'A': posOfA[i+1]++; break;
			case 'C': posOfC[i+1]++; break;
			case 'G': posOfG[i+1]++; break;
			case 'T': posOfT[i+1]++; break;
			default: break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			posOfA[i+1] += posOfA[i];
			posOfC[i+1] += posOfC[i];
			posOfG[i+1] += posOfG[i];
			posOfT[i+1] += posOfT[i];
		}
		
		int[] res = new int[M];
		for (int i = 0; i < res.length; i++) {
			if (posOfA[Q[i]+1] - posOfA[P[i]] != 0) res[i] = 1;
			else if (posOfC[Q[i]+1] - posOfC[P[i]] != 0) res[i] = 2;
			else if (posOfG[Q[i]+1] - posOfG[P[i]] != 0) res[i] = 3;
			else if (posOfT[Q[i]+1] - posOfT[P[i]] != 0) res[i] = 4;
		}
		
		return res;
	}
	
	@Test
	public void test() {
		String S = "CAGCCTA";
		int[] P = new int[] {2,5,0};
		int[] Q = new int[] {4,5,6};
		
		Assert.assertArrayEquals(solution(S, P, Q), new int[] {2,4,1});
				
	}

}
