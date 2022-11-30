package model;

import java.util.ArrayList;

import view.InputRating;

public class QueryE extends Query {
	
	public void executeQuery() {
		ArrayList<ArrayList<String>> data = super.gatherData(2);
		
		double startRating = new InputRating().inputRating("Enter lower bounds for rating: ");
		double endRating = new InputRating().inputRating("Enter lower bounds for rating: ");
		
		ArrayList<String> moviesWithinRange = moviesWithinRange(startRating, endRating, data);
		
		printResults(moviesWithinRange);
	}
	
	public ArrayList<String> moviesWithinRange(double startRating, double endRating, ArrayList<ArrayList<String>> data) {
		ArrayList<String> movieResults = new ArrayList<String>();
		
		for (ArrayList<String> row : data) {
			double rating = Double.parseDouble(row.get(3));
			String title = row.get(1);
			
			//System.out.println("rating: " + rating);
			
			if (rating >= startRating && rating <= endRating) {
				movieResults.add(title);
			}
		}
		
		return movieResults; 
	}
	
	public void printResults(ArrayList<String> movieResults) {

		int size = movieResults.size();
		
		System.out.println("\nShowing all movies within range. " + size + " results...\n");
		
		for (int i = 0; i < movieResults.size(); i++) {
			System.out.println(movieResults.get(i));
		}
	}

}
