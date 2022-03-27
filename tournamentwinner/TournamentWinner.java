import java.util.*;

class TournamentWinner {

  public String tournamentWinner(
    ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		
		//HTML = 6
	  //Python = 9 ...
    Map<String,Integer> rank = new HashMap<String,Integer>();
		
		for( int i = 0; i < results.size(); i++ )  {
			if(results.get(i) == 0){
				ArrayList<String> composition = competitions.get(i);
				Integer points = rank.get(composition.get(1));
				if(points == null) {
					points = 0;
				}
				rank.put(composition.get(1), points + 3);
			} else {
				ArrayList<String> composition = competitions.get(i);
				Integer points = rank.get(composition.get(0));
				if(points == null) {
					points = 0;
				}
				rank.put(composition.get(0), points + 3);
			}
		}
		
		Map.Entry<String, Integer> maxEntry = null;
		
		
		String result = "";
		for (Map.Entry<String, Integer> entry : rank.entrySet()) {
    	if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
				result = entry.getKey();
			}
		}	
		
		return result;
  }
}

