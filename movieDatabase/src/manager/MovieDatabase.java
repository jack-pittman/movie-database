package manager;

import view.InputQuery;

/*
 * MOVIE DATABASE - the World Controller. Manages and regulates all affairs. Answers only to Main. 
 * 
 * @author J. Pittman
 */

public class MovieDatabase {

	public void movieDatabase() {
		// call handleInput class (From view) 
		String queryLet = new InputQuery().selectQuery();
			
		// initiate query given buildData (from model) 
		new QueryManager().startQuery(queryLet);
	}
}
