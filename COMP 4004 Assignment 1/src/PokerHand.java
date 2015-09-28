
public class PokerHand {
	
	public Card[] hand = new Card[5];
	private boolean invalidHand;

	public PokerHand() {
	}
	
	public PokerHand(Card[] hand) {
		for (int i = 0; i < 5; i++)
			this.hand[i] = hand[i];
		
		this.invalidHand = false;
	}
	
	public void invalidHandTest() {
		if (invalidCardTest() || dualCardTest())
			this.invalidHand = true;
	}
	
	public boolean invalidCardTest() {
		for (int i = 0; i < this.hand.length; i++) {
			if (this.hand[i].getRank() == null || this.hand[i].getSuit() == null)
				return true;
		}
		return false;
	}
	
	private boolean dualCardTest() {		
		for (int i = 0; i < this.hand.length; i++) {
			for (int j = i + 1; j < this.hand.length; j++) {
				if (this.hand[i].isEqual(this.hand[j]))
						return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String finalHand = this.hand[0].toString();
		
		for (int i = 1; i < 5; i++)
			finalHand += " " + this.hand[i].toString();
		
		return finalHand;
	}
	
	public static void main(String[] args) {
		Card[] duplicateHand = new Card[5];
		
		duplicateHand[0] = new Card("AceHearts");
		duplicateHand[1] = new Card("ThreeHearts");
		duplicateHand[2] = new Card("TwoSpades");
		duplicateHand[3] = new Card("SevenClubs");
		duplicateHand[4] = new Card("SevenClubs");
		
		PokerHand hand = new PokerHand(duplicateHand);
		hand.invalidHandTest();
		
		System.out.println(hand.invalidHand);
	}
	
}
