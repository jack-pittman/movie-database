package view;

import java.util.Scanner;

public class InputNumber extends Input{

	public int inputNumber() {
		printStatement();
		return Integer.parseInt(super.getInput());
	}
	
	public void printStatement() {
		System.out.print("Enter Integer: "); 
	}
}
