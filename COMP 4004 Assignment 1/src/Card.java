
public class Card {
	
	private Integer rank;
	private String suit;
	private String cardRank;
	Constants constants = new Constants();
	
	public Card() {
		
	}

	public Card(String cardName) {
		
		for (Integer r : constants.ranks.keySet()) {
			if (cardName.indexOf(constants.ranks.get(r)) != -1) {
				this.rank = r;
				this.cardRank = constants.ranks.get(r);
				break;
			}
		}
		
		for (String s : constants.suits) {
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
	
	public String getCardRank() {
		return this.cardRank;
	}
	
	protected boolean isEqual(Card otherCard) {
		if (this.rank == otherCard.rank && this.suit == otherCard.suit)
			return true;
		return false;
	}
	
	public String toString() {
		return this.cardRank + this.suit;
	}
	
}
