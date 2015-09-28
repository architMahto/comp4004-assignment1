import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CardTest {
	
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
	private String c1Suit = "Diamonds", c2Suit = "Spades", c3Suit = "Clubs", c4Suit = "Hearts", c7Suit = null, c8Suit = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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
	}

	public void testConstructors() {
		assertNull("Card was not null as expected", cNull);
		assertNotNull("Card was not instantiated as expected",c2);
	}

	@Test
	public void testGetCardRank() {
		assertEquals("Card rank was not initialized as expected", c1.getRank(), c1Rank);
		assertEquals("Card rank was not initialized as expected", c2.getRank(), c2Rank);
		assertEquals("Card rank was not initialized as expected", c3.getRank(), c3Rank);
		assertEquals("Card rank was not initialized as expected", c4.getRank(), c4Rank);
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
}
