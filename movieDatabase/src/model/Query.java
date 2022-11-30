package model;

import java.util.ArrayList;

/*
 * QUERY SUPERCLASS - saves repeated code by holding all shared properties. 
 * 
 * @author J. Pittman
 */

public class Query { // refactor to extend query
	
	public ArrayList<ArrayList<String>> gatherData(int fileNum) {		
		// Build Data (Always do this first)
		BuildData bd = new BuildData();	
		return bd.buildData(fileNum);
	}
}
