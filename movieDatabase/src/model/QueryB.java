package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * QUERY B CLASS - Prints a list of all unique directors from the imdb_movies_cast file. 
 * 
 * @author J. Pittman
 */

public class QueryB extends DirectorQuery{

	public void executeQuery() {
		
		ArrayList<ArrayList<String>> data = super.gatherData(0);
		
		ArrayList<String> directors = super.uniqueDirectors(super.allDirectors(data));
		
		printResults(directors);
	}

	public void printResults(ArrayList<String> directors) {

		System.out.println("Showing All Directors.");
		
		for (int i = 0; i < directors.size(); i++) {
			System.out.println(directors.get(i));
		}
	}
}
