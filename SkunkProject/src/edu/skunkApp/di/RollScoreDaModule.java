package edu.skunkApp.di;

import dagger.Provides;
import dagger.Module;
import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.Implementation.GameRulesEngineBoImpl;
import edu.skunkApp.businessobject.Implementation.RollBoImpl;
import edu.skunkApp.businessobject.Implementation.RoundBoImpl;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.dataAccess.Implementation.KittyDaImpl;
import edu.skunkApp.dataAccess.Implementation.PlayerDaImpl;
import edu.skunkApp.dataAccess.Implementation.RollScoreDaImpl;

/**TODO
 * Can the modules be on their own package? 
 * */
@Module
public class RollScoreDaModule {
	
	@Provides IRollScoreDa provideRollScore() {
		return new RollScoreDaImpl();
	}
	
	@Provides IPlayerDa providePlayer() {
		return new PlayerDaImpl();
	}
	
	@Provides IKittyDa provideKitty() {
		return new KittyDaImpl();
	}
	
	@Provides IGameRulesEngineBo provideGameRulesEngine() {
		return new GameRulesEngineBoImpl();
	}
	
	@Provides IRollBo provideRoll() {
		return new RollBoImpl();
	}
	
	@Provides IRoundBo provideRound()
	{
		return new RoundBoImpl();
	}
}
