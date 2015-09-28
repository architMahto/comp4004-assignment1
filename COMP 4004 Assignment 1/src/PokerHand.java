import java.util.HashMap;
import java.util.Map;


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
	
	// toString() method
	public String toString() {
		String finalHand = this.hand[0].toString();
		
		for (int i = 1; i < 5; i++)
			finalHand += " " + this.hand[i].toString();
		
		return finalHand;
	}
	/*
	 * Check if hands are invalid
	 */
	
	public void invalidHandTest() {
		if (invalidCardTest() || duplicateCardTest())
			this.invalidHand = true;
	}
	
	// check if hand contains invalid card
	private boolean invalidCardTest() {
		for (int i = 0; i < this.hand.length; i++) {
			if (this.hand[i].getRank() == null || this.hand[i].getSuit() == null)
				return true;
		}
		return false;
	}
	
	// check if hand contains duplicate cards
	private boolean duplicateCardTest() {		
		for (int i = 0; i < this.hand.length; i++) {
			for (int j = i + 1; j < this.hand.length; j++) {
				if (this.hand[i].isEqual(this.hand[j]))
						return true;
			}
		}
		return false;
	}
	
	/*
	 * Functions to check poker hands
	*/
	
	// check Royal Flush
	public boolean checkRoyalFlush() {
		if (checkFlush() && checkStraight() && checkRoyal())
			return true;
		return false;
	}
	
	// check Straight Flush
	public boolean checkStraightFlush() {
		if (checkFlush() && checkStraight())
			return true;
		return false;
	}
	
	// check Four of a Kind
	public boolean checkFourOfAKind() {
		if (checkNumberOfRepeatingCards(4))
			return true;
		return false;
	}
	
	// check Full House
	public boolean checkFullHouse() {
		if (checkNumberOfRepeatingCards(3) && checkNumberOfRepeatingCards(2))
			return true;
		return false;
	}
	
	// check Flush
	public boolean checkFlush() {
		if (this.hand[0].getSuit() == this.hand[1].getSuit() &&
			this.hand[1].getSuit() == this.hand[2].getSuit() &&
			this.hand[2].getSuit() == this.hand[3].getSuit() &&
			this.hand[3].getSuit() == this.hand[4].getSuit())
			return true;
		
		return false;
	}
	
	// check Straight
	public boolean checkStraight() {
		int maxDifference = 1, difference = 0;
		Card tempCard = null;
		
		for (Card c : this.hand) {
			if (tempCard != null) {
				difference = Math.abs(tempCard.getRank() - c.getRank());
				if (difference > maxDifference)
					return false;
			}
			tempCard = c;
		}
		
		return true;
	}
	
	// check Three Of A Kind
	public boolean checkThreeOfAKind() {
		if (checkNumberOfRepeatingCards(3))
			return true;
		return false;
	}
	
	// check Two Pair
	public boolean checkTwoPair() {
		if (checkNumberOfPairs(2))
			return true;
		return false;
	}
	
	// check One Pair
	public boolean checkOnePair() {
		if (checkNumberOfPairs(1))
			return true;
		return false;
	}
	
	// check if hand if full of high cards
	private boolean checkRoyal() {
		if (this.hand[0].getRank() > 9)
			return true;
		
		return false;
	}
	
	// check number of similar ranked cards in hand
	private boolean checkNumberOfRepeatingCards(int n) {
		Map<Integer,Integer> repetitionMap = getRepetitionMap();
		
		for (Map.Entry<Integer,Integer> e : repetitionMap.entrySet()) {
			if (e.getValue() == n)
				return true;
		}
		return false;
	}
	
	// returns map containing number of repeating cards
	private Map<Integer,Integer> getRepetitionMap() {
		Map<Integer,Integer> repetitionMap = new HashMap<Integer,Integer>();
		for (Card c : this.hand) {
			if (repetitionMap.containsKey(c.getRank())) {
				repetitionMap.put(c.getRank(), repetitionMap.get(c.getRank()));
			} else {
				repetitionMap.put(c.getRank(), 1);
			}
		}
		return repetitionMap;
	}
	
	// check number of pairs in hand
	private boolean checkNumberOfPairs(int numberOfPairs) {
		Card tempCard = null;
		int count = 0;
		
		for (Card c : this.hand) {
			if (tempCard != null && (tempCard.getRank() == c.getRank()))
				count++;
			tempCard = c;
		}
		
		if (count == numberOfPairs)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		Card[] duplicateHand = new Card[5];
		
		duplicateHand[0] = new Card("TwoHearts");
		duplicateHand[1] = new Card("ThreeHearts");
		duplicateHand[2] = new Card("FourHearts");
		duplicateHand[3] = new Card("FiveHearts");
		duplicateHand[4] = new Card("SevenDiamonds");
		
		PokerHand hand = new PokerHand(duplicateHand);
		
		System.out.println(hand.checkStraight());
	}
	
}
