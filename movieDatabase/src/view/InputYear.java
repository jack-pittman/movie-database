package view;

import java.util.Scanner;

public class InputYear extends Input{

	public String inputYear() {
		printStatement();
		return super.getInput();
	}
	
	public void printStatement() {
		System.out.print("Enter year: "); 
	}
}
