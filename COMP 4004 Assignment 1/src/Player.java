
public class Player {
	
	String playerID;
	PokerHand pokerHand = new PokerHand();
	Integer playerRanking;
	Constants constants = new Constants();

	public Player(String input) {
		String[] inputSplit = input.split(" ");
		
		playerID = inputSplit[0];
		
		for (int i = 0, j = 1; i < inputSplit.length; i++, j++)
			pokerHand.hand[i] = new Card(inputSplit[j]);
	}
	
	public void setRanking() {
		if (this.pokerHand.checkRoyalFlush()) {
			this.playerRanking = 1;
		} else if (this.pokerHand.checkStraightFlush()) {
			this.playerRanking = 2;
		} else if (this.pokerHand.checkFourOfAKind()) {
			this.playerRanking = 3;
		} else if (this.pokerHand.checkFullHouse()) {
			this.playerRanking = 4;
		} else if (this.pokerHand.checkFlush()) {
			this.playerRanking = 5;
		} else if (this.pokerHand.checkStraight()) {
			this.playerRanking = 6;
		} else if (this.pokerHand.checkThreeOfAKind()) {
			this.playerRanking = 7;
		} else if (this.pokerHand.checkTwoPair()) {
			this.playerRanking = 8;
		} else if (this.pokerHand.checkOnePair()) {
			this.playerRanking = 9;
		}
	}
	
	public Integer getRanking() {
		return this.playerRanking;
	}

}
