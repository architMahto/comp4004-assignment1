import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Tests {

	private Integer c1Rank = 2, c2Rank = 3, c3Rank = 12, c4Rank = 14;
	private String c1CardRank = "Two", c2CardRank = "Three", c3CardRank = "Queen", c4CardRank = "Ace";
	private String c1Suit = "Diamonds", c2Suit = "Spades", c3Suit = "Clubs", c4Suit = "Hearts";
	// Valid cards
	private Card c1, c2, c3, c4, c5;
	// Invalid cards
	private Card ic1, ic2, ic3, ic4;
	Card[] ph1, iph, rf, sf, foak, fh, f, s, toak, tp, op;
	PokerHand p1, p2, royalFlush, straightFlush, fourOfAKind, 
			  fullHouse, flush, straight, threeOfAKind, twoPair, onePair;
	
	public void initializeHands (Card c1, Card c2, Card c3, Card c4, Card c5, Card[] p12) {
		p12[0] = c1; p12[1] = c2; p12[2] = c3; p12[3] = c4; p12[4] = c5;
	}
	
	@Before
	public void setUp() throws Exception {
		// Initializing valid cards
		c1 = new Card("TwoDiamonds"); c2 = new Card("ThreeSpades");
		c3 = new Card("QueenClubs"); c4 = new Card("AceHearts");
		c5 = new Card("TwoClubs");
		
		// Initializing invalid cards
		ic1 = null; ic2 = null; ic3 = null; ic4 = null;
		
		// Initializing poker hand 1
		ph1 = new Card[5];
		initializeHands(c1,c2,c3,c4,c5,ph1);
		
		// Initializing invalid poker hand
		iph = new Card[5];
		initializeHands(c1,c2,c3,c3,c5,iph);
		
		// Initializing royal flush hand
		rf = new Card[5];
		initializeHands(new Card("TenHearts"),new Card("JackHearts"),new Card("QueenHearts")
						,new Card("KingHearts"),new Card("AceHearts"),rf);
		royalFlush = new PokerHand(rf);
		
		// Initializing straight flush hand
		sf = new Card[5];
		initializeHands(new Card("FiveClubs"),new Card("SixClubs"),new Card("SevenClubs")
						,new Card("EightClubs"),new Card("NineClubs"),sf);
		straightFlush = new PokerHand(sf);
		
		// Initializing four of a kind hand
		foak = new Card[5];
		initializeHands(new Card("KingHearts"),new Card("AceClubs"),new Card("AceDiamonds")
						,new Card("AceSpades"),new Card("AceHearts"),foak);
		fourOfAKind = new PokerHand(foak);
		
		// Initializing full house hand
		fh = new Card[5];
		initializeHands(new Card("KingSpades"),new Card("KingHearts"),new Card("AceDiamonds")
								 ,new Card("AceSpades"),new Card("AceHearts"),fh);
		fullHouse = new PokerHand(fh);
		
		// Initializing flush hand
		f = new Card[5];
		initializeHands(new Card("TwoSpades"),new Card("SixSpades"),new Card("SevenSpades")
		 				,new Card("TenSpades"),new Card("AceSpades"),f);
		flush = new PokerHand(f);
		
		// Initializing straight hand
		s = new Card[5];
		initializeHands(new Card("TwoHearts"),new Card("ThreeSpades"),new Card("FourDiamonds")
						,new Card("FiveClubs"),new Card("SixHearts"),s);
		straight = new PokerHand(s);
		
		// Initializing three of a kind hand
		toak = new Card[5];
		initializeHands(new Card("KingSpades"),new Card("KingHearts"),new Card("AceDiamonds")
						,new Card("AceSpades"),new Card("AceHearts"),toak);
		threeOfAKind = new PokerHand(toak);
		
		// Initializing two pair hand
		tp = new Card[5];
		initializeHands(new Card("QueenSpades"),new Card("KingDiamonds"),new Card("KingClubs"),
						new Card("AceSpades"),new Card("AceHearts"),tp);
		twoPair = new PokerHand(tp);
		
		// Initializing one pair hand
		op = new Card[5];
		initializeHands(new Card("JackDiamonds"),new Card("QueenSpades"),new Card("KingHearts")
		,new Card("AceSpades"),new Card("AceHearts"),op);
		onePair = new PokerHand(op);
	}

	@After
	public void tearDown() throws Exception {
		c1 = null; c2 = null; c3 = null; c4 = null;
		ic1 = null; ic2 = null; ic3 = null; ic4 = null;
	}
	
	/*
	 * Testing constructors for Card class
	 */
	@Test
	public void testCardConstructors() {
		assertNotNull("Card was not instantiated as expected", c1);
		assertNotNull("Card was not instantiated as expected", c2);
		assertNotNull("Card was not instantiated as expected", c3);
		assertNotNull("Card was not instantiated as expected", c4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCardConstructors() {
		ic1 = new Card("FifteenClubs"); ic2 = new Card("OneDiamond");
		ic3 = new Card("QueenJays"); ic4 = new Card("AceMcCloud");
	}
	
	/*
	 * Testing getters and toString() method for Card class
	 */
	@Test
	public void testGetRank() {
		assertEquals("Card rank was not initialized as expected", c1.getRank(), c1Rank);
		assertEquals("Card rank was not initialized as expected", c2.getRank(), c2Rank);
		assertEquals("Card rank was not initialized as expected", c3.getRank(), c3Rank);
		assertEquals("Card rank was not initialized as expected", c4.getRank(), c4Rank);
	}
	
	@Test
	public void testGetCardRank() {
		assertEquals("Card rank was not initialized as expected", c1.getCardRank(), c1CardRank);
		assertEquals("Card rank was not initialized as expected", c2.getCardRank(), c2CardRank);
		assertEquals("Card rank was not initialized as expected", c3.getCardRank(), c3CardRank);
		assertEquals("Card rank was not initialized as expected", c4.getCardRank(), c4CardRank);
	}
	
	@Test
	public void testGetSuit() {
		assertEquals("Card suit was not initialized as expected", c1.getSuit(), c1Suit);
		assertEquals("Card suit was not initialized as expected", c2.getSuit(), c2Suit);
		assertEquals("Card suit was not initialized as expected", c3.getSuit(), c3Suit);
		assertEquals("Card suit was not initialized as expected", c4.getSuit(), c4Suit);
	}
	
	@Test
	public void testToString() {

		String c1String = c1.toString();
		assertTrue("c1String toString does not contain cardRank", c1String.contains(c1.getCardRank()));
		assertTrue("c1String toString does not contain suit", c1String.contains(c1.getSuit()));
	}

	/*
	 * Testing constructors for PokerHand class
	 */
	
	@Test
	public void testPokerHandConstructor() {
		p1 = new PokerHand(ph1);
		assertNotNull("Poker hand not instantiated as expected", p1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testInvalidPokerHandConstructor() {
		p2 = new PokerHand(iph);
		//assertNotNull("Poker hand not instantiated as expected", p2);
	}
	
	/*
	 * Testing pokerHands
	 */
	
	@Test
	public void testCheckRoyalFlush() {
		assertTrue("royalFlush is not a Royal Flush", royalFlush.checkRoyalFlush());
	}
	
	@Test
	public void testCheckStraightFlush() {
		assertTrue("straightFlush is not a Straight Flush", straightFlush.checkStraightFlush());
	}
	
	@Test
	public void testCheckFourOfAKind() {
		assertTrue("fourOfAKind is not Four of a Kind", fourOfAKind.checkFourOfAKind());
	}
	
	@Test
	public void testCheckFullHouse() {
		assertTrue("fullHouse is not a Full House", fullHouse.checkFullHouse());
	}
	
	@Test
	public void testCheckFlush() {
		assertTrue("flush is not a Flush", flush.checkFlush());
		
	}
	
	@Test
	public void testCheckStraight() {
		assertTrue("straight is not a Straight", straight.checkStraight());
	}
	
	@Test
	public void testCheckThreeOfAKind() {
		assertTrue("threeOfAKind is not Three of a Kind", threeOfAKind.checkThreeOfAKind());
	}
	
	@Test
	public void testCheckTwoPair() {
		assertTrue("twoPair is not a Two Pair", twoPair.checkTwoPair());
	}
	
	@Test
	public void testCheckOnePair() {
		assertTrue("onePair is not a One Pair", onePair.checkOnePair());
	}
}
