package edu.skunkApp.di;

import dagger.Provides;
import dagger.Module;
import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.businessobject.Implementation.GameRulesEngineBoImpl;
import edu.skunkApp.businessobject.Implementation.PlayerBoImpl;
import edu.skunkApp.businessobject.Implementation.RollBoImpl;
import edu.skunkApp.businessobject.Implementation.RollScoreBoImpl;
import edu.skunkApp.businessobject.Implementation.RoundBoImpl;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.dataAccess.IRoundDa;
import edu.skunkApp.dataAccess.Implementation.KittyDaImpl;
import edu.skunkApp.dataAccess.Implementation.PlayerDaImpl;
import edu.skunkApp.dataAccess.Implementation.RollScoreDaImpl;
import edu.skunkApp.dataAccess.Implementation.RoundDaImpl;

@Module
public class SkunkAppModule {
	
	@Provides IRollScoreDa provideRollScore() {
		return new RollScoreDaImpl();
	}
	
	@Provides IPlayerDa providePlayer() {
		return new PlayerDaImpl();
	}
	
	@Provides IKittyDa provideKitty() {
		return new KittyDaImpl();
	}
	
	@Provides IRoundDa providesRoundDaImpl(){
		return new RoundDaImpl();
	}
	
	@Provides IGameRulesEngineBo provideGameRulesEngineImpl() {
		return new GameRulesEngineBoImpl();
	}

	@Provides IPlayerBo providePlayerBo()
	{
		return new PlayerBoImpl();
	}
	
	@Provides IRollBo provideRoll() {
		return new RollBoImpl();
	}
	
	@Provides IRoundBo provideRound()
	{
		return new RoundBoImpl();
	}

	@Provides IRollScoreBo providesRollScoreBo() {
		return new RollScoreBoImpl();
	}
}
