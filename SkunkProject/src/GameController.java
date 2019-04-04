import java.util.ArrayList;

public class GameController {
	
	Turn turn;
	ArrayList<Player> players = null;
	GameStatusEnum status = GameStatusEnum.INPROGRESS;
	GameResult result;

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
		if (this.turn == null)
		{
			this.turn = new Turn();
		}
		this.getPlayer().setActivePlayer();
		this.startTurn();
		this.displayGameSummary();
	}

	private void startTurn()
	{
		while(this.status != GameStatusEnum.GAME_COMPLETED)
		{
			switch(this.status)
			{
				case INPROGRESS:
					this.turn.rollAndSetScore();
					this.result = new GameResult(this.getPlayer(), this.turn.getLastRoll());
					SkunkAppUi.displayResults(this.result.getRollScore());
					this.status = this.result.getGameStatus();
					break; 

				case TURN_COMPLETED:
					this.status = GameStatusEnum.GAME_COMPLETED;
					break;
				default:
						break;
			}
			
			if (this.status == GameStatusEnum.INPROGRESS && !SkunkAppUi.getPlayerRollChoice())
			{
				//DECLINED_TO_ROLL
				this.status = GameStatusEnum.TURN_COMPLETED;
			}
		}
	}
	
	private void displayGameSummary()
	{
		//todo
	}
}
