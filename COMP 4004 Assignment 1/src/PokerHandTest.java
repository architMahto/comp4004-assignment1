import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PokerHandTest {
	
	private PokerHand ph1;
	private PokerHand ph2;
	
	@Before
	public void setUp() throws Exception {
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
		ph1 = null;
		ph2 = null;
	}

	@Test
	public void testConstructor() {
		assertNotNull("Hand was not instantiated as expected",ph1);	
	}
	
	public void testInvalidHands() {
		assertTrue(ph1.invalidCardTest());
		assertTrue(ph2.invalidCardTest());
	}

}
