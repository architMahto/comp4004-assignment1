
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
	
	public static void main(String[] args) {
		Card c1 = new Card("TwoDiamonds");
		Card c2 = new Card("ThreeSpades");
		Card c3 = new Card("QueenClubs");
		Card c4 = new Card("AceHearts");
		Card c5 = new Card("FifteenDiamonds");
		
		System.out.println(c1.toString() + " => " + c1.getRank() + ", " + c1.getSuit());
		System.out.println(c2.toString() + " => " + c2.getRank() + ", " + c2.getSuit());
		System.out.println(c3.toString() + " => " + c3.getRank() + ", " + c3.getSuit());
		System.out.println(c4.toString() + " => " + c4.getRank() + ", " + c4.getSuit());
		System.out.println(c5.toString() + " => " + c5.getRank() + ", " + c5.getSuit());
	}
	
}
