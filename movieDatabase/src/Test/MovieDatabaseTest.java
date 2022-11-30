package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.BuildData;
import model.DirectorQuery;
import model.QueryA;
import model.QueryD;
import model.QueryE;

public class MovieDatabaseTest {

	@Test
	public void testA() {
		ArrayList<ArrayList<String>> data = new BuildData().buildData(1);
		
		double actualTotal = 4661025071.0;
		String year = "2009";
		
		double testTotal = new QueryA().totalEarnings(year, data);
				
		assertEquals(actualTotal, testTotal, 0);
		
	}
	
	@Test
	public void testAllDirectors() {
		ArrayList<ArrayList<String>> data = makeNestedArray("Quentin Tarantino", "Christopher Nolan", "Wes Anderson", 3);
		
		ArrayList<String> actualAnswer = new ArrayList<String>();
		actualAnswer.add("Christopher Nolan");
		actualAnswer.add("Quentin Tarantino");
		actualAnswer.add("Wes Anderson");
		
		ArrayList<String> tempAnswer = new DirectorQuery().allDirectors(data);
		
		for (int i = 0; i < 3; i++) {
			assertEquals(tempAnswer.get(i), actualAnswer.get(i));
		}
	}
	
	@Test
	public void testUniqueDirectors() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Christopher Nolan");
		data.add("Christopher Nolan");
		data.add("Wes Anderson");
		
		ArrayList<String> actualAnswer = new ArrayList<String>();
		actualAnswer.add("Christopher Nolan");
		actualAnswer.add("Wes Anderson");
		
		ArrayList<String> tempAnswer = new DirectorQuery().uniqueDirectors(data);
		for (int i = 0; i < 2; i++) {
			assertEquals(tempAnswer.get(i), actualAnswer.get(i));
		}
	}
	
	@Test
	public void testLetterToFileNum() {
		int tempResult = new QueryD().letterToFileNum("R");
		assertEquals(tempResult, 2);
	}

	@Test
	public void testMoviesWithinRange() {
		ArrayList<ArrayList<String>> data = new BuildData().buildData(2);
		
		ArrayList<String> actualAnswer = new ArrayList<String>();
		actualAnswer.add("The Shawshank Redemption");
		actualAnswer.add("The Godfather");
		
		String dad = "The Shawshank Redemption";
		
		ArrayList<String> tempAnswer = new QueryE().moviesWithinRange(9.1, 9.2, data); 
		
		assertEquals(actualAnswer.get(0), tempAnswer.get(0));
	}
	
	public ArrayList<ArrayList<String>> makeNestedArray (String dir1, String dir2, String dir3, int column) {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		String[] items = {dir1, dir2, dir3};
		for (int i = 0; i < 3; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < 4; j++) {
				if (j == column) {
					row.add(items[i]);
				}
				else {
					row.add("");
				}
			}
			data.add(row);
		}
		return data; 
	}
}
