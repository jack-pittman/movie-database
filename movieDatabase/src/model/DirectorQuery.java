package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * DIRECTOR QUERY SUPERCLASS - Contains methods used by QueryB and QueryC. We hate repeated code!
 * 
 * @author J. Pittman
 */


public class DirectorQuery extends Query {
	public ArrayList<ArrayList<String>> gatherData(int fileNum) {		
		// Build Data (Always do this first)
		return super.gatherData(fileNum);
	}
	
	public ArrayList<String> allDirectors(ArrayList<ArrayList<String>> data) {
		ArrayList<String> results = new ArrayList<String>();
		
		for (ArrayList<String> i : data) {
			
			String currDirector = i.get(3);
			
				results.add(currDirector);
		}
		
		Collections.sort(results);
		
		return results;
	}
	
	public ArrayList<String> uniqueDirectors (ArrayList<String> allDirectors) {
		ArrayList<String> uniqueDirectors = new ArrayList<String>();
		
		for (String i : allDirectors) {
			if (!uniqueDirectors.contains(i)) {
				uniqueDirectors.add(i);
			}
		}
		return uniqueDirectors;
	}
	
}
