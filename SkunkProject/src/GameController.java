import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

class GameController {
	
	private Turn turn;
	private ArrayList<Player> players = null;
	private GameStatusEnum status = GameStatusEnum.INPROGRESS;
	private GameResult result;
	private int playerCount = 0;
	
	private static Hashtable<String, String> uiMessages;

	GameController()
	{
		this.loadUiMessages();
	}
	
	public void setPlayer(String playerName)
	{
		if (this.players == null) 
		{
			this.players = new ArrayList<Player>();
		}
		this.players.add(new Player(playerName));
	}

	public Player getPlayer()
	{
		return this.players.get(0);
	}
	
	public String getPlayerName()
	{
		return this.getPlayer().getPlayerName();
	}
	
	void startGame()
	{
		this.getPlayersCountInput();
		this.initializePlayers();
		this.startTurns();
		this.displayGameSummary();
	}
	
//	
//	void setPlayerTurn()
//	{
//		if (this.turn == null)
//		{
//			this.turn = new Turn();
//		}
//	}
	
	private void initializePlayers()
	{
		for(int i = 0; i < this.playerCount - 1; i++)
		{
			String playerName = SkunkAppUi.getPlayerNameFromInput(String.valueOf(i));
			this.setPlayer(playerName); // TODO: PERFORM VALIDATE PLAYER NAME
		}
	}
	
	private void startTurns()
	{
		Iterator<Player> player = this.players.iterator();
		while(player.hasNext())
		{
			this.startTurn();
		}
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
		Score score = this.turn.getTurnScore();
		String message = this.result.getGameSummary(score);
		SkunkAppUi.displayResults(message);
	}
	
	private void getPlayersCountInput()
	{
		String inputMessage =  GameController.getUiMessage("playerInput");
		this.playerCount = SkunkAppUi.getPlayerNumericInput(inputMessage);
	}

// STATIC METHODS	
	private void loadUiMessages()
	{
		GameController.addMessage("playerInput", "Enter the # of players : ");
	}
	
	private static void addMessage(String key, String value)
	{
		GameController.uiMessages.put(key, value);
		//(new SimpleEntry<String, String>("playerInput", "Enter the number of players"))
	}

	private static String getUiMessage(String key)
	{
		return GameController.uiMessages.get(key);
	}
}
