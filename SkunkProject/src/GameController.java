import java.util.ArrayList;

public class GameController {
	
	Turn turn;
	ArrayList<Player> players = null;
	GameStatus status;

	GameController()
	{
	}
	
	public void setPlayer(Player player)
	{
		if (this.players == null) 
		{
			this.players = new ArrayList<Player>();
		}
		this.players.add(player);
	}

	public Player getPlayer()
	{
		//todo: remove index and find alternative approach
		return this.players.get(0);
	}
	
	public String getPlayerName()
	{
		return this.getPlayer().getPlayerName();
	}
	
	public void startGame()
	{
		if (turn == null)
		{
			turn = new Turn();
		}
		this.getPlayer().isPlayerActive(true);
		status = GameStatus.INPROGRESS;
		this.startTurn();
	}
	
	private void startTurn()
	{
		while(status != GameStatus.DECLINED_TO_ROLL)
		{
			switch(status)
			{
				case INPROGRESS:
					turn.rollAndSetScore();
					//todo: remove. Temporary to stop the loop
					status = GameStatus.DECLINED_TO_ROLL;
					break; 
				default:
						break;
			}
		}
		//A Turn starts with asking the player by name if they wish to roll and ends after 
		//either a decline-to-roll response or throwing a Skunk
	}
}
