import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class Tests {

	private Integer c1Rank = 2, c2Rank = 3, c3Rank = 12, c4Rank = 14;
	private String c1CardRank = "Two", c2CardRank = "Three", c3CardRank = "Queen", c4CardRank = "Ace";
	private String c1Suit = "Diamonds", c2Suit = "Spades", c3Suit = "Clubs", c4Suit = "Hearts";
	private Card c1;
	private Card c2;
	private Card c3;
	private Card c4;
	private Card c5;
	private Card c6;
	private Card c7;
	private Card c8;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Card("TwoDiamonds");
		c2 = new Card("ThreeSpades");
		c3 = new Card("QueenClubs");
		c4 = new Card("AceHearts");
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		c5 = null;
		c6 = null;
		c7 = null;
		c8 = null;
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
		c5 = new Card("FifteenClubs");
		c6 = new Card("OneDiamond");
		c7 = new Card("QueenJays");
		c8 = new Card("AceMcCloud");
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

}
