
public class Card {
	
	Integer rank;
	String suit;

	public Card(String cardName) {
		
		for (Integer r : Constants.ranks.keySet()) {
			if (cardName.indexOf(Constants.ranks.get(r)) != -1) {
				this.rank = r;
				break;
			}
		}
		
		for (String s : Constants.suits) {
			if (cardName.indexOf(s) != -1) {
				this.suit = s;
				break;
			}
		}
		
	}

	public Integer getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
}
