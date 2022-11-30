package view;

public class InputRank extends InputNumber {
	public int inputRank() {
		return inputNumber();
	}
	
	@Override 
	public void printStatement() {
		System.out.print("Enter Rank: "); 
	}
}
