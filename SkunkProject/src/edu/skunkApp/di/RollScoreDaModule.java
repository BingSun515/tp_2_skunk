package edu.skunkApp.di;

import dagger.Provides;
import dagger.Module;
import edu.skunkApp.businessobject.IGameRulesEngine;
import edu.skunkApp.businessobject.IRoll;
import edu.skunkApp.businessobject.Implementation.GameRulesEngine;
import edu.skunkApp.businessobject.Implementation.Roll;
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
	
	@Provides IGameRulesEngine provideGameRulesEngine() {
		return new GameRulesEngine();
	}
	
	@Provides IRoll provideRoll() {
		return new Roll();
	}
}
