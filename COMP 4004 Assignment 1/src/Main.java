

public class Main {

	public static void main(String[] args) {
		Player p1 = new Player("p1 TenHearts JackHearts QueenHearts KingHearts AceHearts");
		Player p2 = new Player("p2 TwoDiamonds TwoClubs ThreeSpades ThreeDiamonds SevenHearts");
		Player p3 = new Player("p3 TenSpades TenDiamonds AceSpades AceClubs AceDiamonds");
		Player p4 = new Player("p4 TwoHearts ThreeClubs FourDiamonds FiveSpades SixClubs");
		
		Player[] players = {p1, p2, p3, p4};
		
		Game game = new Game(players);
		
		game.assignRanking();
		
		game.printRankings();
	}

}
