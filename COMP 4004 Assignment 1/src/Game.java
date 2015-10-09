
public class Game {
	
	Player[] players;
	
	public Game(Player[] players) {
		if (invalidNumberOfPlayers(players))
			throw new IllegalArgumentException("Game has too many or too little players.");
		
		if (checkIdenticalPlayers(players))
			throw new IllegalArgumentException("Game has some identical players");
		
		this.players = new Player[players.length];
		for (int i = 0; i < players.length; i++)
			this.players[i] = players[i];
	}
	
	private boolean invalidNumberOfPlayers(Player[] players) {
		return (players.length < 2 || players.length > 4);
	}
	
	@SuppressWarnings("unused")
	private boolean checkIdenticalPlayers(Player[] players) {
		if (players.length == 2)
			return players[0].getPlayerInfo().equals(players[1].getPlayerInfo());
		
		for (int i = 0; i < players.length; i++)
			for (int j = 1; j < players.length; j++)
				return players[i].getPlayerInfo().equals(players[j].getPlayerInfo());
		return false;
	}
	
}
