import java.lang.StringBuilder;

public class GameResult {

	final char NEWLINE = '\n';
	Player activePlayer;
	Roll lastRoll;
	GameStatusEnum gameStatus;

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
		
		if (this.lastRoll.isSkunk())
		{
			this.getSkunkRollMessage(sb);
		}
		return sb.toString();
	}
	
	public GameStatusEnum getGameStatus()
	{
		return this.gameStatus = this.lastRoll.isSkunk() ? GameStatusEnum.TURN_COMPLETED : GameStatusEnum.INPROGRESS;
	}
	
	private void getSkunkRollMessage(StringBuilder sb)
	{
		if (this.lastRoll.isSingleSkunk())
		{
			sb.append("Last roll was a single skunk");
		}
		else if (this.lastRoll.isDoubleSkunk())
		{
			sb.append("Last roll was a double skunk");
		}
		else if (this.lastRoll.isDeuceSkunk())
		{
			sb.append("Last roll was a Deuce skunk");
		}
		else if (this.lastRoll.isDeuceSkunk())
		{
			sb.append("Last roll was a Deuce skunk");
		}
	}
}
