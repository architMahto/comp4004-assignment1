
public class Player {
	
	public String ID;
	public PokerHand pokerHand;
	public String handType;
	public String playerInfo;
	public String[] playerInfoArray;
	
	public Player (String playerInfo) {
		this.playerInfo = playerInfo;
		this.playerInfoArray = playerInfo.split(" ");
		
		if (playerInfoArray.length != 6)
			throw new IllegalArgumentException("Input does not contain player id or right number of cards");
		
		this.ID = playerInfoArray[0];
		
		Card[] hand = new Card[5];
		for (int i = 0, j = 1; j < playerInfoArray.length; i++, j++) {
			hand[i] = new Card(playerInfoArray[j]);
		}		
		this.pokerHand = new PokerHand(hand);
		this.handType = setHandType();
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String setHandType() {
		if (this.pokerHand.checkRoyalFlush()) 
			return "Royal Flush";
		
		if (this.pokerHand.checkStraightFlush()) 
			return "Straight Flush";
		
		if (this.pokerHand.checkFourOfAKind()) 
			return "Four of a Kind";
		
		if (this.pokerHand.checkFullHouse()) 
			return "Full House";
		
		if (this.pokerHand.checkFlush()) 
			return "Flush";
		
		if (this.pokerHand.checkStraight()) 
			return "Straight";
		
		if (this.pokerHand.checkThreeOfAKind()) 
			return "Three of a Kind";
		
		if (this.pokerHand.checkTwoPair()) 
			return "Two Pair";
		
		if (this.pokerHand.checkOnePair()) 
			return "One Pair";
			
		return "High Card";
	}
	
	public String getHandType() {
		return this.handType;
	}

	public String getPlayerInfo() {
		return this.playerInfo;
	}

	public String[] getPlayerInfoArray() {
		return this.playerInfoArray;
	}
}
