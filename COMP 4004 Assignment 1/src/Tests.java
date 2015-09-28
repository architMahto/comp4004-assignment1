import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class Tests {

	private Card c1;
	private Card c2;
	private Card c3;
	private Card c4;
	private Card c5;
	private Card c6;
	private Card c7;
	private Card c8;
	private Card cNull = null;
	private Integer c1Rank = 2, c2Rank = 3, c3Rank = 12, c4Rank = 14, c5Rank = null, c6Rank = null;
	private String c1CardRank = "Two", c2CardRank = "Three", c3CardRank = "Queen", c4CardRank = "Ace";
	private String c1Suit = "Diamonds", c2Suit = "Spades", c3Suit = "Clubs", c4Suit = "Hearts", c7Suit = null, c8Suit = null;
	private PokerHand ph1;
	private PokerHand ph2;
	
	@Before
	public void setUp() throws Exception {
		cNull = new Card();
		c1 = new Card("TwoDiamonds");
		c2 = new Card("ThreeSpades");
		c3 = new Card("QueenClubs");
		c4 = new Card("AceHearts");
		c5 = new Card("FifteenClubs");
		c6 = new Card("OneDiamond");
		c7 = new Card("QueenJays");
		c8 = new Card("AceMcCloud");
		
		Card[] hand1 = new Card[5];
		hand1[0] = new Card("TwoHearts");
		hand1[1] = new Card("AceSpades");
		hand1[2] = new Card("KingClubs");
		hand1[3] = new Card("ThreeDiamonds");
		hand1[4] = new Card("SevenJays");
		ph1 = new PokerHand(hand1);
		
		Card[] hand2 = new Card[5];
		hand2[0] = new Card("TwoHearts");
		hand2[1] = new Card("AceSpades");
		hand2[2] = new Card("TwoHearts");
		hand2[3] = new Card("ThreeDiamonds");
		hand2[4] = new Card("SevenSpades");
		ph2 = new PokerHand(hand2);
	}

	@After
	public void tearDown() throws Exception {
		cNull = null;
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		c5 = null;
		c6 = null;
		c7 = null;
		c8 = null;
		
		ph1 = null;
		ph2 = null;
	}

	public void testCardConstructors() {
		assertNull("Card was not null as expected", cNull);
		assertNotNull("Card was not instantiated as expected",c2);
	}
	
	@Test
	public void testPokerHandConstructor() {
		assertNotNull("Hand was not instantiated as expected",ph1);	
	}

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
	public void testGetCardSuit() {
		assertEquals("Card suit was not initialized as expected", c1.getSuit(), c1Suit);
		assertEquals("Card suit was not initialized as expected", c2.getSuit(), c2Suit);
		assertEquals("Card suit was not initialized as expected", c3.getSuit(), c3Suit);
		assertEquals("Card suit was not initialized as expected", c4.getSuit(), c4Suit);
	}
	
	@Test
	public void testInvalidCardRank() {
		assertEquals("Card rank was not given null for invalid rank", c5.getRank(), c5Rank);
		assertEquals("Card rank was not given null for invalid rank", c6.getRank(), c6Rank);
	}
	
	@Test
	public void testInvalidCardSuit() {
		assertEquals("Card suit was not given null for invalid suit", c7.getSuit(), c7Suit);
		assertEquals("Card suit was not given null for invalid suit", c8.getSuit(), c8Suit);
	}
	
	@Test
	public void testToString() {
		String c1String = c1.toString();
		assertTrue("c1String toString does not contain cardRank", c1String.contains(c1.getCardRank()));
		assertTrue("c1String toString does not contain suit", c1String.contains(c1.getSuit()));
	}

}
