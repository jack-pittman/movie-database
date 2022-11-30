package model;

import java.util.ArrayList;

import view.InputDirOrCast;
import view.InputRank;
import view.InputRatOrMoney;

public class QueryD extends Query {
	public void executeQuery() {
		
		
		int rank = new InputRank().inputRank();
		
		// Get user choice between rating or money ranking; determines which file to pull from 
		String ratingOrMoney = new InputRatOrMoney().inputRatOrMoney();	
		int fileNum = letterToFileNum(ratingOrMoney);
		
		ArrayList<ArrayList<String>> rankData = super.gatherData(fileNum);
		ArrayList<ArrayList<String>> castData = super.gatherData(0);
		
		String directorOrCast = new InputDirOrCast().inputDirOrCast();
		
		String movieName = movieNameGivenRank(rank, fileNum, rankData);
		
		String movieCredits = creditsGivenChoice(movieName, directorOrCast, castData);
		
		printResults(movieName, rank, movieCredits, ratingOrMoney);
		
	}

	public void printResults(String movieName, int rank, String movieCredits, String ratingOrMoney) {

		System.out.print("\n" + movieName + " is ranked " + rank + " in ");
		
		if (ratingOrMoney.equals("R")) {
			System.out.print("IMDB rating.\n");
		}
		if (ratingOrMoney.equals("M")) {
			System.out.print("box office.\n");
		}
		
		
		System.out.println(movieCredits);

	}
	
	public String movieNameGivenRank(int rank, int fileNum, ArrayList<ArrayList<String>> data) {
		
		return data.get(rank).get(1);
	}
	
	public String creditsGivenChoice(String movieName, String directorOrCast, ArrayList<ArrayList<String>> castData) {
		String credits = "";
		
		for (ArrayList<String> row : castData) {
			if (row.get(1).equals(movieName) && directorOrCast.equals("T")) {
				credits = credits + row.get(3); 
			}
			if (row.get(1).equals(movieName) && directorOrCast.equals("C")) {
				
				credits = credits + row.get(4);
				
				for (int i = 5; i <= 8; i++) {
					credits = credits + ", " + row.get(i);
				}
				return credits; 
			}
		}
		return credits;
	}
	
	public int letterToFileNum(String ratingOrMoney) {
		if (ratingOrMoney.equals("R")) {
			return 2;
		}
		if (ratingOrMoney.equals("M")) {
			return 1;
		}
		else return -1;
	}
}
