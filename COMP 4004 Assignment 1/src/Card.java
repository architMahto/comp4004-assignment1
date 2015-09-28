
public class Card {
	
	private Integer rank;
	private String suit;
	Constants constants = new Constants();
	
	public Card() {
		
	}

	public Card(String cardName) {
		
		for (Integer r : constants.ranks.keySet()) {
			if (cardName.indexOf(constants.ranks.get(r)) != -1) {
				this.rank = r;
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
	
	public static void main(String[] args) {
		Card c1 = new Card("TwoDiamonds");
		Card c2 = new Card("ThreeSpades");
		Card c3 = new Card("QueenClubs");
		Card c4 = new Card("AceHearts");
		Card c5 = new Card("FifteenDiamonds");
		
		System.out.println("TwoDiamonds => " + c1.getRank() + ", " + c1.getSuit());
		System.out.println("ThreeSpades => " + c2.getRank() + ", " + c2.getSuit());
		System.out.println("QueenClubs => " + c3.getRank() + ", " + c3.getSuit());
		System.out.println("AceHearts => " + c4.getRank() + ", " + c4.getSuit());
		System.out.println("FifteenJays => " + c5.getRank() + ", " + c5.getSuit());
	}
	
}
