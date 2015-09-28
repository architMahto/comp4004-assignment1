import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Constants {
	
	// card ranks
	Map<Integer,String> ranks = new TreeMap<>();
	// list of suits
	ArrayList<String> suits = new ArrayList<>();
	
	public Constants() {
		
		ranks.put(2, "Two");
		ranks.put(3, "Three");
		ranks.put(4, "Four");
		ranks.put(5, "Five");
		ranks.put(6, "Six");
		ranks.put(7, "Seven");
		ranks.put(8, "Eight");
		ranks.put(9, "Nine");
		ranks.put(10, "Ten");
		ranks.put(11, "Jack");
		ranks.put(12, "Queen");
		ranks.put(13, "King");
		ranks.put(14, "Ace");		
		
		suits.add("Clubs");
		suits.add("Spades");
		suits.add("Diamonds");
		suits.add("Hearts");
		
	}
	
}
