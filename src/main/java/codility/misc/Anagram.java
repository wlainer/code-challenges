package codility.misc;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Anagram {

	public Boolean solution(String wordA, String wordB) {
		wordA = wordA.toLowerCase().replace(" ", "");
		wordB = wordB.toLowerCase().replace(" ", "");
		
		char[] arrA = wordA.toCharArray();
		char[] arrB = wordB.toCharArray();
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		for (int i = 0; i < arrA.length; i++) 
			if (arrA[i] != arrB[i]) return Boolean.FALSE;
		
		return Boolean.TRUE;
	}

	@Test
	public void test() {

		String word1 = "William Shakespeare";
		String word2 = "I am a weakish speller";
		
		Assert.assertEquals(solution(word1, word2), Boolean.TRUE);
	}

}
