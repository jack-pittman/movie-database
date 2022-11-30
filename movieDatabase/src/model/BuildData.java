package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuildData {
	
	public ArrayList<ArrayList<String>> buildData(int fileNum) {
		// GET DESIRED FILE
		String fileName = fileNameFromNum(fileNum);
		
		return readFile(fileName);
	}
	
	public ArrayList<ArrayList<String>> readFile(String fileName) {
		// CREATE ARRAYLIST:
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		// READ FILE, WRITE TO ARRAY
		File file = new File("resources/imdb_movies_"+fileName+".txt");
		
		Scanner sc = null;
        try {							// handle fileNotFound
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Invalid file");
            System.exit(-1);
        }
        
        // WRITE DATA TO ARRAYLIST
        
        int counter = 0; 
        
        while (sc.hasNextLine()) {
        	String[] tempRow = (sc.nextLine()).split("\t");
        	
        	ArrayList<String> row = new ArrayList<String>(Arrays.asList(tempRow));

        	if (counter > 0) {
                data.add(row);
        	}
        	counter++;
        }
        return data;
	}
	
	// GETS FILENAME FROM INT
	public String fileNameFromNum(int fileNum) {
		if(fileNum == 0) {
			return "cast";
		}
		if(fileNum == 1) {
			return "gross";
		}
		if(fileNum == 2) {
			return "toprated";
		}
		if(fileNum == 3) {
			return "test1";
		}
		return "no file for num";
	}
}
