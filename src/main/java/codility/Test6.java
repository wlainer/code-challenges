package codility;

public class Test6 {
	
	public static void main(String[] args) {
		int[] A = new int[] {-1, 1, 3, 3, 3, 2 ,1, 0};
		
//		int[] A = new int[1000000];
//		for (int x = 0; x < 1000000; x++) {
//			A[x] = x;
//		}
		
		Test6 test6 = new Test6();
		int solution = test6.solution(A);
		
		System.out.println(solution);
		
	}
	
	public int solution(int[] A) {
		int numbersCount = A.length;
		if(A == null || numbersCount < 3)
            return 0;
		
        int numberSlices = 0;
        int startSlice = 0;

       while (startSlice < A.length -2) {
    	   int endSlice = startSlice + 1;
    	   
    	   int arithmeticDifference = A[endSlice] - A[startSlice];	
    	   
    	   while(endSlice < numbersCount-1 && A[endSlice+1] - A[endSlice] == arithmeticDifference) {
               endSlice++;
           }
    	   
    	   int lengthSlice = endSlice - startSlice + 1;

			if(lengthSlice >= 3){
               numberSlices += ((lengthSlice-2)*(lengthSlice-1)/2);
           }

			startSlice = endSlice;
		}

		return (numberSlices > 1000000000) ? -1 : numberSlices;
    }
	
	private int calculateSlices(int n){
        return (n-1)*(n-2)/2;
    }

}
