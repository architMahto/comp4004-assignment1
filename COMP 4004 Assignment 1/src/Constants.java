import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Constants {
	
	// card ranks
	Map<Integer,String> ranks = new TreeMap<>();
	// list of suits
	ArrayList<String> suits = new ArrayList<>();
	// combination of cards
	String[] deckOfCards = new String[52];
	Map<String, Integer> scoreOfHands = new TreeMap<>();
	
	
	public Constants() {
		
		// Inserting value of ranks
		ranks.put(2, "Two"); ranks.put(3, "Three"); ranks.put(4, "Four"); ranks.put(5, "Five");
		ranks.put(6, "Six"); ranks.put(7, "Seven"); ranks.put(8, "Eight"); ranks.put(9, "Nine");
		ranks.put(10, "Ten"); ranks.put(11, "Jack"); ranks.put(12, "Queen"); ranks.put(13, "King");
		ranks.put(14, "Ace");		
		
		// Inserting list of suits
		suits.add("Clubs"); suits.add("Spades"); suits.add("Diamonds"); suits.add("Hearts");
		
		// Initializing deck of cards
		deckOfCards[0] = "AceClubs"; deckOfCards[1] = "TwoClubs"; deckOfCards[2] = "ThreeClubs"; deckOfCards[3] = "FourClubs";
		deckOfCards[4] = "FiveClubs"; deckOfCards[5] = "SixClubs"; deckOfCards[6] = "SevenClubs"; deckOfCards[7] = "EightClubs";
		deckOfCards[8] = "NineClubs"; deckOfCards[9] = "TenClubs"; deckOfCards[10] = "JackClubs"; deckOfCards[11] = "QueenClubs";
		deckOfCards[12] = "KingClubs";
		deckOfCards[13] = "AceSpades"; deckOfCards[14] = "TwoSpades"; deckOfCards[15] = "ThreeSpades"; deckOfCards[16] = "FourSpades";
		deckOfCards[17] = "FiveSpades"; deckOfCards[18] = "SixSpades"; deckOfCards[19] = "SevenSpades"; deckOfCards[20] = "EightSpades";
		deckOfCards[21] = "NineSpades"; deckOfCards[22] = "TenSpades"; deckOfCards[23] = "JackSpades"; deckOfCards[24] = "QueenSpades";
		deckOfCards[25] = "KingSpades";
		deckOfCards[26] = "AceHearts"; deckOfCards[27] = "TwoHearts"; deckOfCards[28] = "ThreeHearts"; deckOfCards[29] = "FourHearts";
		deckOfCards[30] = "FiveHearts"; deckOfCards[31] = "SixHearts"; deckOfCards[32] = "SevenHearts"; deckOfCards[33] = "EightHearts";
		deckOfCards[34] = "NineHearts"; deckOfCards[35] = "TenHearts"; deckOfCards[36] = "JackHearts"; deckOfCards[37] = "QueenHearts";
		deckOfCards[38] = "KingHearts";
		deckOfCards[39] = "AceDiamonds"; deckOfCards[40] = "TwoDiamonds"; deckOfCards[41] = "ThreeDiamonds"; deckOfCards[42] = "FourDiamonds";
		deckOfCards[43] = "FiveDiamonds"; deckOfCards[44] = "SixDiamonds"; deckOfCards[45] = "SevenDiamonds"; deckOfCards[46] = "EightDiamonds";
		deckOfCards[47] = "NineDiamonds"; deckOfCards[48] = "TenDiamonds"; deckOfCards[49] = "JackDiamonds"; deckOfCards[50] = "QueenDiamonds";
		deckOfCards[51] = "KingDiamonds";
		
		// Initializing the score for each hand
		scoreOfHands.put("High Card",1); scoreOfHands.put("One Pair",2); scoreOfHands.put("Two Pair",3); scoreOfHands.put("Three of a Kind",4);
		scoreOfHands.put("Straight",5); scoreOfHands.put("Flush",6); scoreOfHands.put("Full House",7); scoreOfHands.put("Four of a Kind",7);
		scoreOfHands.put("Straight Flush",9); scoreOfHands.put("Royal Flush",10); 
	}
	
}
