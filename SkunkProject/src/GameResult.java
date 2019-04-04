import org.apache.commons.text.TextStringBuilder;

public class GameResult {

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
		TextStringBuilder tb = new TextStringBuilder();
		tb.appendln(this.activePlayer.getPlayerName());
		tb.appendln(this.lastRoll.getDiceDisplay());
		
		if (this.lastRoll.isSkunk())
		{
			this.getSkunkRollMessage(tb);
		}
		return tb.toString();
	}
	
	public String getGameSummary(Score score)
	{
		TextStringBuilder tb = new TextStringBuilder().appendln("");
		tb.appendln("********** GAME SUMMARY **********");
		tb.appendln("turn score :: " + score.getTurnScore());
		tb.appendln("chip change :: " + score.getChipChangeScore());
		tb.appendln("kitty change :: " + score.getKittyChangeScore());
		
		return tb.toString();
	}
	
	public GameStatusEnum getGameStatus()
	{
		return this.gameStatus = this.lastRoll.isSkunk() ? GameStatusEnum.TURN_COMPLETED : GameStatusEnum.INPROGRESS;
	}
	
	private void getSkunkRollMessage(TextStringBuilder tb)
	{
		if (this.lastRoll.isSingleSkunk())
		{
			tb.appendln("Last roll was a single skunk");
		}
		else if (this.lastRoll.isDoubleSkunk())
		{
			tb.appendln("Last roll was a double skunk");
		}
		else if (this.lastRoll.isDeuceSkunk())
		{
			tb.appendln("Last roll was a Deuce skunk");
		}
	}
}
