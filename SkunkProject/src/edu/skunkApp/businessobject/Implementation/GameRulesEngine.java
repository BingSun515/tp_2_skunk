package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;

import edu.skunkApp.businessobject.IGameRulesEngine;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;
/**
 * TODO: https://stthomas.instructure.com/courses/23037/assignments/216762
 * Game rules live here
 * Any number can play. [Assume at least two players!]
 * The suggested number of chips to start is 50.
 * There are sufficient chips in the box to allow 8 players to 
 * start with 50 chips by placing a par value of "one" on white chips, 
 * 5 for 1 on red chips and 10 for 1 on the blue chips.
 * 
 * The first player to accumulate a total of 100 or more points can continue 
 * to score as many points over 100 as he believes 
 * is needed to win. 
 * 
 * When he decides to stop, his total score is the “goal.” 
 *  
 * DO CONTROLLER LAYER 
 * -------------------
 * Each succeeding player receives one more chance to better the 
 * goal and end the game.
 * 
 * DONE: moveChips
 * The winner of each game collects all chips in "kitty" and in addition five chips from 
 * each losing player or 10 chips from any player without a score.
 * **/
public class GameRulesEngine implements IGameRulesEngine {
	private final int WINNING_SCORE = 100;
	
	public boolean getGameStatus(int roundTotal)
	{
		return roundTotal >= this.WINNING_SCORE;
	}
	
	public void moveChips(RollScoreDm rollScoreDm, ArrayList<PlayerDm> losers)
	{
		losers.forEach(loser -> {
				if (loser.Score == 0)
				{
					loser.chipCount -= 10;
					rollScoreDm.chipChange += 10;
				}
				else 
				{
					loser.chipCount -= 5;
					rollScoreDm.chipChange += 5;
				}
			});
	}
	
	//START: SKUNK
	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm, boolean hasWinner)
	{
		//TODO: how to set game status
		rollScoreDm.roll.diceTotal = rollScoreDm.roll.die1 + rollScoreDm.roll.die2;
		if (this.isRollSingleSkunk(rollScoreDm.roll))
		{
			rollScoreDm.rollStatus = SkunkEnum.SINGLESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.TURN_COMPLETED;
			rollScoreDm.chipChange = -1;
			rollScoreDm.kittyChange = 1;
			rollScoreDm.turnTotal = 0;
		}
		else if (this.isRollDoubleSkunk(rollScoreDm.roll))
		{
			rollScoreDm.rollStatus = SkunkEnum.DOUBLESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.ROUND_COMPLETED;
			rollScoreDm.chipChange = -4;
			rollScoreDm.kittyChange = 4;
			rollScoreDm.turnTotal = 0;
		}
		else if (this.isRollDeuceSkunk(rollScoreDm.roll))
		{
			rollScoreDm.rollStatus = SkunkEnum.DEUCESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.TURN_COMPLETED;
			rollScoreDm.chipChange = -2;
			rollScoreDm.kittyChange = 2;
			rollScoreDm.turnTotal = 0;
		}
		else
		{
			rollScoreDm.rollStatus = SkunkEnum.NOSKUNK;
			rollScoreDm.turnTotal = previousScoreDm.turnTotal + rollScoreDm.roll.diceTotal;
			rollScoreDm.roundTotal = previousScoreDm.roundTotal + rollScoreDm.roll.diceTotal;

			if(hasWinner)
			{
				rollScoreDm.gameStatus = GameStatusEnum.CONTINUE_ROLL;
			}
			else
			{
				rollScoreDm.gameStatus = this.getGameStatus(rollScoreDm.roundTotal) ?
											GameStatusEnum.WINNER : GameStatusEnum.CONTINUE_ROLL;
			}
		}
	}
	
	public boolean isRollSingleSkunk(RollDm roll)
	{
		return ((roll.die1 == 1 && roll.die2 > 2) || (roll.die2 == 1 && roll.die1 > 2));
	}
	
	public boolean isRollDoubleSkunk(RollDm roll)
	{
		return (roll.die1 == 1 && roll.die2 == 1);
	}
	
	public boolean isRollDeuceSkunk(RollDm roll)
	{
		return (roll.die1 == 1) && (roll.die2 == 2 ) || (roll.die2 == 1 ) && (roll.die1 == 2 );
	}

}
