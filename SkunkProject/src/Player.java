public class Player {
	
	private Boolean isActive;
	private String playerName;
	
	public Player(String name)
	{
		this.playerName = name;
	}
	
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	public boolean isPlayerActive() {
		return isActive;
	}
	
	public void setActivePlayer() {
		isActive = true;
	}
}
