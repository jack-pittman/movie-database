package view;
import java.util.Scanner;

/*
 * SELECT QUERY CLASS - handles query selection. What kind of information are we trying to get? 
 * 
 * @author J. Pittman
 */

public class InputQuery extends Input{
	
	public String selectQuery() {
		printStatement();
		return super.getInput();
	}
	
	public void printStatement() {
		
		System.out.println("Welcome to the Movie Database!\n\n"
				+ "Select desired query:\n" 
				+ "\t(A) - Total box office earnings (by year)\n" // gross
				+ "\t(B) - Give a list of all the directors of movies in the database.\n"			   // cast
				+ "\t(C) - Give a list of some number of directors who appear most in the database.\n"// cast
				+ "\t(D) - Tell the director or cast members who starred in a movie, given the movie’s\n"
				+ "\t    rating rank or money rank. \n"
				+ "\t(E) - Show a list of movies within a user-selected rating range."); // cast + gross
	}
}
