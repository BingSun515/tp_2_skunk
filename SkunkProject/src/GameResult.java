import org.apache.commons.text.TextStringBuilder;

class GameResult {

//	private Player activePlayer;
	private Roll lastRoll;
//	private Turn turn;

	GameResult(Turn turn)
	{
//		this.activePlayer = player;
//		this.turn = turn;
		this.lastRoll = turn.getLastRoll();
	}
	
	public String getRollScore()
	{
		TextStringBuilder tb = new TextStringBuilder();
		tb.appendln(this.lastRoll.getDiceDisplay());
		tb.appendln(Constants.getUiMessage("aLine"));
		if (this.lastRoll.isSkunk())
		{
			this.getSkunkRollMessage(tb);
		}
		return tb.toString();
	}
	
	String getGameSummary(Score score)
	{
		TextStringBuilder tb = new TextStringBuilder().appendln("");
		tb.appendln("********** ROUND SUMMARY **********");
		tb.appendln("turn score :: " + score.getTurnScore());
		tb.appendln("chip change :: " + score.getChipChangeScore());
		tb.appendln("kitty change :: " + score.getKittyChangeScore());
		
		return tb.toString();
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
