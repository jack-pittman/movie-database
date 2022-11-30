package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import view.InputNumber;
import view.InputYear;

/*
 * QUERY C CLASS - Prints a list (user-determined length) of unique directors from the 
 * 				   imdb_movies_cast file, ranked by their frequency. 
 * 
 * @author J. Pittman
 */

public class QueryC extends DirectorQuery{

	public void executeQuery() {
		
		ArrayList<ArrayList<String>> data = gatherData(0);
		ArrayList<String> allDirectors = allDirectors(data);
		
		ArrayList<String> sortDirectorFreqs = sortDirectorFreq(uniqueDirectors(allDirectors), directorFreq(allDirectors));
		
		int numRows = new InputNumber().inputNumber(); 
		
		printResults(sortDirectorFreqs, numRows);
	}

	//Counts how many times a director appears and stores it as the value in a dictionary
	public HashMap<String, Integer> directorFreq(ArrayList<String> allDirectors) {
		
		HashMap<String, Integer> directorRank = new HashMap<String, Integer>();
		
		for (String director : allDirectors) {
			
			if (!directorRank.containsKey(director)) {
				directorRank.put(director, 1);
			}
			else {
				int currentCount = directorRank.get(director);

				directorRank.put(director, currentCount + 1);
			}
		}
		return directorRank;
	}
	
	// turns the dictionary into an arraylist and formats it
	public ArrayList<String> sortDirectorFreq(ArrayList<String> uniqueDirectors, HashMap<String, Integer> directorFreq) {
		ArrayList<String> sortDirectorFreq = new ArrayList<String>();
		
		for (int i = 0; i < uniqueDirectors.size(); i++) {
			String currDirector = uniqueDirectors.get(i);
			String currFreq = Integer.toString(directorFreq.get(currDirector));
			
			sortDirectorFreq.add(currFreq + " - " + currDirector);
		}
		
		
		Collections.sort(sortDirectorFreq);
		Collections.reverse(sortDirectorFreq);
		
		return sortDirectorFreq;
	}

	public void printResults(ArrayList<String> sortDirectorFreqs, int numRows) {

		System.out.println("\nShowing "+numRows+" Directors, Ranked by Frequency:");
		
		for (int i = 0; i < numRows; i++) {
			System.out.println(sortDirectorFreqs.get(i));
		}
	}
}
