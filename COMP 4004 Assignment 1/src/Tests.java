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
	// Poker Hands
	Card[] ph1, iph, iph2, rf, sf, foak, fh, f, s, toak, tp, op;
	PokerHand p1, p2, p3, royalFlush, straightFlush, fourOfAKind, 
			  fullHouse, flush, straight, threeOfAKind, twoPair, onePair;
	// Players
	Player pl1, plinvalid, plRoyalFlush, plStraightFlush, plFourOfAKind, plFullHouse,
		   plFlush, plStraight, plThreeOfAKind, plTwoPair, plOnePair;
	
	public void initializeHands (Card c1, Card c2, Card c3, Card c4, Card c5, Card[] p12) {
		p12[0] = c1; p12[1] = c2; p12[2] = c3; p12[3] = c4; p12[4] = c5;
	}
	
	@Before
	public void setUp() throws Exception {
		// Initializing valid cards
		c1 = new Card("TwoDiamonds"); c2 = new Card("ThreeSpades");
		c3 = new Card("QueenClubs"); c4 = new Card("AceHearts");
		c5 = new Card("TwoClubs");
		
		// Initializing poker hand 1
		ph1 = new Card[5];
		initializeHands(c1,c2,c3,c4,c5,ph1);
		
		// Initializing first invalid poker hand 
		iph = new Card[5];
		initializeHands(c1,c2,c3,c3,c5,iph);
		
		// Initializing second invalid poker hand
		iph2 = new Card[4];
		iph2[0] = c1; iph2[1] = c2; iph2[2] = c3; iph[3] = c4;
		
		// Players
		//Player pl1, plInvalid, plRoyalFlush, plStraightFlush, plFourOfAKind, plFullHouse,
			   //plFlush, plStraight, plThreeOfAKind, plTwoPair, plOnePair;
		
		// Initializing royal flush hand and player with royal flush
		rf = new Card[5];
		initializeHands(new Card("TenHearts"),new Card("JackHearts"),new Card("QueenHearts")
						,new Card("KingHearts"),new Card("AceHearts"),rf);
		royalFlush = new PokerHand(rf);
		plRoyalFlush = new Player("plRoyalFlush TenHearts JackHearts QueenHearts KingHearts AceHearts");
		
		// Initializing straight flush hand and player with straight flush
		sf = new Card[5];
		initializeHands(new Card("FiveClubs"),new Card("SixClubs"),new Card("SevenClubs")
						,new Card("EightClubs"),new Card("NineClubs"),sf);
		straightFlush = new PokerHand(sf);
		plStraightFlush = new Player("plStraightFlush FiveClubs SixClubs SevenClubs EightClubs NineClubs");
		
		// Initializing four of a kind hand
		foak = new Card[5];
		initializeHands(new Card("KingHearts"),new Card("AceClubs"),new Card("AceDiamonds")
						,new Card("AceSpades"),new Card("AceHearts"),foak);
		fourOfAKind = new PokerHand(foak);
		plFourOfAKind = new Player("plFourOfAKind KingHearts AceClubs AceDiamonds AceSpades AceHearts");
		
		// Initializing full house hand
		fh = new Card[5];
		initializeHands(new Card("KingSpades"),new Card("KingHearts"),new Card("AceDiamonds")
								 ,new Card("AceSpades"),new Card("AceHearts"),fh);
		fullHouse = new PokerHand(fh);
		plFullHouse = new Player("plFullHouse KingSpades KingHearts AceDiamonds AceSpades AceHearts");
		
		// Initializing flush hand
		f = new Card[5];
		initializeHands(new Card("TwoSpades"),new Card("SixSpades"),new Card("SevenSpades")
		 				,new Card("TenSpades"),new Card("AceSpades"),f);
		flush = new PokerHand(f);
		plFlush = new Player("plFlush TwoSpades SixSpades SevenSpades TenSpades AceSpades");
		
		// Initializing straight hand
		s = new Card[5];
		initializeHands(new Card("TwoHearts"),new Card("ThreeSpades"),new Card("FourDiamonds")
						,new Card("FiveClubs"),new Card("SixHearts"),s);
		straight = new PokerHand(s);
		plStraight = new Player("plStraight TwoHearts ThreeSpades FourDiamonds FiveClubs SixHearts");
		
		//plFlush, plStraight, plThreeOfAKind, plTwoPair, plOnePair;
		
		// Initializing three of a kind hand
		toak = new Card[5];
		initializeHands(new Card("QueenClubs"),new Card("KingSpades"),new Card("AceDiamonds")
						,new Card("AceSpades"),new Card("AceHearts"),toak);
		threeOfAKind = new PokerHand(toak);
		plThreeOfAKind = new Player("plThreeOfAKind QueenClubs KingSpades AceDiamonds AceSpades AceHearts");
		
		// Initializing two pair hand
		tp = new Card[5];
		initializeHands(new Card("QueenSpades"),new Card("KingDiamonds"),new Card("KingClubs"),
						new Card("AceSpades"),new Card("AceHearts"),tp);
		twoPair = new PokerHand(tp);
		plTwoPair = new Player("plTwoPair QueenSpades KingDiamonds KingClubs AceSpades AceHearts");
		
		// Initializing one pair hand
		op = new Card[5];
		initializeHands(new Card("JackDiamonds"),new Card("QueenSpades"),new Card("KingHearts")
		,new Card("AceSpades"),new Card("AceHearts"),op);
		onePair = new PokerHand(op);
		plOnePair = new Player("plOnePair JackDiamonds QueenSpades KingHearts AceSpades AceHearts");
		
		// Initializing players
		pl1 = new Player("p1 TwoSpades SixSpades SevenSpades TenSpades AceSpades");
	}

	@After
	public void tearDown() throws Exception {
		c1 = null; c2 = null; c3 = null; c4 = null;
	}
	
	/*
	 * Testing constructors for Card class
	 */
	public void testCardConstructors() {
		assertNotNull("Card was not instantiated as expected", c1);
		assertNotNull("Card was not instantiated as expected", c2);
		assertNotNull("Card was not instantiated as expected", c3);
		assertNotNull("Card was not instantiated as expected", c4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidCardConstructors() {
		new Card("FifteenClubs"); new Card("OneDiamond");
		new Card("QueenJays"); new Card("AceMcCloud");
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
		p3 = new PokerHand(iph2);
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
	
	/*
	 * Testing Player class constructors
	 */
	
	public void testPlayerConstructor() {
		assertNotNull("Player was not instantiated as expected", pl1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testInvalidPlayerConstructor() {
		new Player("p2 JackDiamonds QueenSpades AceSpades AceHearts");
	}

	/*
	 * Testing getters of Player class
	 */
	
	//Player pl1, plInvalid, plRoyalFlush, plStraightFlush, plFourOfAKind, plFullHouse,
	   //plFlush, plStraight, plThreeOfAKind, plTwoPair, plOnePair;
	
	public void testGetID() {
		assertEquals("Player ID was not initialized as expected", plRoyalFlush.getID(), "plRoyalFlush");
		assertEquals("Player ID was not initialized as expected", plStraightFlush.getID(), "plStraightFlush");
		assertEquals("Player ID was not initialized as expected", plFourOfAKind.getID(), "plFourOfAKind");
		assertEquals("Player ID was not initialized as expected", plFullHouse.getID(), "plFullHouse");
		assertEquals("Player ID was not initialized as expected", plFlush.getID(), "plFlush");
		assertEquals("Player ID was not initialized as expected", plStraight.getID(), "plStraight");
		assertEquals("Player ID was not initialized as expected", plThreeOfAKind.getID(), "plThreeOfAKind");
		assertEquals("Player ID was not initialized as expected", plTwoPair.getID(), "plTwoPair");
		assertEquals("Player ID was not initialized as expected", plOnePair.getID(), "plOnePair");
	}
	
	public void testGetSetHandType() {
		plRoyalFlush.setHandType();
		assertEquals("Hand type was not set as expected", "Royal Flush", plRoyalFlush.getHandType());
		plStraightFlush.setHandType();
		assertEquals("Hand type was not set as expected", "Straight Flush", plStraightFlush.getHandType());
		plFourOfAKind.setHandType();
		assertEquals("Hand type was not set as expected", "Four of a Kind", plFourOfAKind.getHandType());
		plFullHouse.setHandType();
		assertEquals("Hand type was not set as expected", "Full House", plFullHouse.getHandType());
		plFlush.setHandType();
		assertEquals("Hand type was not set as expected", "Flush", plFlush.getHandType());
		plStraight.setHandType();
		assertEquals("Hand type was not set as expected", "Straight", plStraight.getHandType());
		plThreeOfAKind.setHandType();
		assertEquals("Hand type was not set as expected", "Three of a Kind", plThreeOfAKind.getHandType());
		plTwoPair.setHandType();
		assertEquals("Hand type was not set as expected", "Two Pair", plTwoPair.getHandType());
		plOnePair.setHandType();
		assertEquals("Hand type was not set as expected", "One Pair", plOnePair.getHandType());
	}
}
