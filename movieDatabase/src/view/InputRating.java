package view;

public class InputRating extends Input{
	
	public double inputRating(String message) {
		printStatement(message);
		return Double.parseDouble(super.getInput());
	}
	
	public void printStatement(String message) {
		System.out.print(message); 
	}
}
