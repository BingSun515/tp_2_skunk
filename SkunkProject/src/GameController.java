import java.util.ArrayList;

public class GameController {
	
	ArrayList<Player> players = null;
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
		return this.players.get(0);
	}
	
	public String getPlayerName()
	{
		return this.getPlayer().getPlayerName();
	}
}
