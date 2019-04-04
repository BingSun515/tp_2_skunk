import java.lang.StringBuilder;

public class GameResult {

	final char NEWLINE = '\n';
	Player activePlayer;
	Roll lastRoll;

	GameResult(Player player, Roll roll)
	{
		this.activePlayer = player;
		this.lastRoll = roll;
	}
	
	public String getRollScore()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.activePlayer.getPlayerName());
		sb.append(this.NEWLINE);
		sb.append(this.lastRoll.getDiceDisplay());
		sb.append(this.NEWLINE);
		
		return sb.toString();
	}
	
	private void displayTurnScore()
	{
		
	}
}
