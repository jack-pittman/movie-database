package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import view.InputYear;

public class QueryA extends Query{
	
	public void executeQuery() {
		ArrayList<ArrayList<String>> data = super.gatherData(1);
		
		String year = new InputYear().inputYear();
		
		double result = Double.valueOf(totalEarnings(year, data));
		
		printResults(year, result);
	}
	
	// returns total box office earnings (int) given a specified year
	public double totalEarnings(String year, ArrayList<ArrayList<String>> data) {
		double total = 0; 
		
		for (ArrayList<String> i : data) {
			
			if (i.get(2).equals(year)) {
				double boxOffice = Double.parseDouble(i.get(3));
				total = total + boxOffice;
			}
		}
		return total; 
	}
	
	public void printResults(String year, double result) {

		String formattedResult = String.format("%,.0f", result);
		
		System.out.println("Total box office earnings for "+ year + ": $" + formattedResult + ".");
	}
}
