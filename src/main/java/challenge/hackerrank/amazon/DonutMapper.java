package challenge.hackerrank.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DonutMapper {

	public static void main(String[] args) {
		String[][] donut = new String[][] { 
				{ "cruller", "vegan" },
				{ "cafe", "coffe" },
				{ "sweet", "sugar" },
				{ "candy", "sugar" },
				{ "beef", "meat" },
				{ "eclair", "chocolate"} 
		};

		String[][] person = new String[][] { 
				{ "john", "chocolate" }, 
				{ "jose", "vegan" },
				{ "maria", "*"},
				{ "mariana", "*"}
		};

		String[][] matchDonuts = matchDonuts(donut, person);
	}

	static String[][] matchDonuts(String[][] donutConstraintPairs, String[][] candidateConstraintPairs) {
		
		Map<String, List<String>> donuts = new TreeMap();
		for (int x = 0; x < donutConstraintPairs.length; x++) {
			List<String> listDonuts = null;
			if (donuts.containsKey(donutConstraintPairs[x][1])) 
				listDonuts = donuts.get(donutConstraintPairs[x][1]);
			else
				listDonuts = new ArrayList();
			
			listDonuts.add(donutConstraintPairs[x][0]);
			donuts.put(donutConstraintPairs[x][1], listDonuts);
		}
		
		Map<String, List<String>> candidates = new TreeMap();
		for (int x = 0; x < candidateConstraintPairs.length; x++) {
			candidates.put(candidateConstraintPairs[x][0], donuts.get(candidateConstraintPairs[x][1]));
		}
		
		int candidatesSize = candidates.size() + 1;
		int donutsSize = donuts.size() + 1;
		
		int numberCandidatesWhoLikesAll = 0;
		Set<String> keySet = candidates.keySet();
		for (String key : keySet) {
			List<String> list = candidates.get(key);
			if (list == null)
				numberCandidatesWhoLikesAll++;
		}
		
		int numberRow = (numberCandidatesWhoLikesAll * donutsSize) + (candidatesSize - numberCandidatesWhoLikesAll);

		String[][] toReturn = new String[numberRow][2] ;
		Set<String> keySet2 = candidates.keySet();
		
		int cont = 0;
		for (String key : keySet2) {
			List<String> list = candidates.get(key);
			if (list != null) {
				Collections.sort(list);
				for (String string : list) {
					toReturn[cont][0] = key;
					toReturn[cont][1] = string;
					cont++;
				}
			} else {
				Set<String> keySet3 = donuts.keySet();
				List<String> allDonuts = new ArrayList<String>();
				for (String string : keySet3) {
					List<String> list2 = donuts.get(string);
					for (String aux : list2) {
						allDonuts.add(aux);
					}
				}
				Collections.sort(allDonuts);
				for (String string2 : allDonuts) {
					toReturn[cont][0] = key;
					toReturn[cont][1] = string2;
					cont++;
				}
			}
		}
			
		return toReturn;
	}

}
