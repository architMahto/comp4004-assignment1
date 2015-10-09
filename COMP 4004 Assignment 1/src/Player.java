
public class Player {
	
	private String ID;
	private PokerHand pokerHand;
	private String handType;
	
	public Player (String playerInfo) {
		String[] playerInfoSplit = playerInfo.split(" ");
		
		if (playerInfoSplit.length != 6)
			throw new IllegalArgumentException("Input does not contain player id or right number of cards");
		
		this.ID = playerInfoSplit[0];
		
		Card[] hand = new Card[5];
		for (int i = 0, j = 1; j < playerInfoSplit.length; i++, j++) {
			hand[i] = new Card(playerInfoSplit[j]);
		}		
		this.pokerHand = new PokerHand(hand);
	}
	
	public String getID() {
		return this.ID;
	}
	
	public void setHandType() {
		if (this.pokerHand.checkRoyalFlush()) {
			this.handType = "Royal Flush";
		} else if (this.pokerHand.checkStraightFlush()) { 
			this.handType = "Straight Flush";
		} else if (this.pokerHand.checkFourOfAKind()) {
			this.handType = "Four of a Kind";
		} else if (this.pokerHand.checkFullHouse()) {
			this.handType = "Full House";
		} else if (this.pokerHand.checkFlush()) {
			this.handType = "Flush";
		} else if (this.pokerHand.checkStraight()) {
			this.handType = "Straight";
		} else if (this.pokerHand.checkThreeOfAKind()) {
			this.handType = "Three of a Kind";
		} else if (this.pokerHand.checkTwoPair()) {
			this.handType = "Two Pair";
		} else if (this.pokerHand.checkOnePair()) {
			this.handType = "One Pair";
		} else {
			this.handType = "High Card";
		}
	}
	
	public String getHandType() {
		return this.handType;
	}
}
