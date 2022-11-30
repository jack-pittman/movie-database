package manager;
import model.QueryA;
import model.QueryB;
import model.QueryC;
import model.QueryD;
import model.QueryE;

public class QueryManager {
	/*
	 * QUERY MANAGER CLASS - the kingpin in the query industry. If a query needs to be made, 
	 * 						 this guy is the one behind it. 
	 * @author J. Pittman
	 */
	
	public void startQuery(String queryLet) {
		if (queryLet.equals("A")) {
			new QueryA().executeQuery();
		}
		if (queryLet.equals("B")) {
			new QueryB().executeQuery();
		}
		if (queryLet.equals("C")) {
			new QueryC().executeQuery();	
		}
		if (queryLet.equals("D")) {
			new QueryD().executeQuery();	
		}
		if (queryLet.equals("E")) {
			new QueryE().executeQuery();	
		}
	}
	
	
}
