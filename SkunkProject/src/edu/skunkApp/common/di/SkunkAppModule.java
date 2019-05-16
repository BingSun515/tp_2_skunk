package edu.skunkApp.common.di;

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

public class SkunkAppModule {

	final static IRollScoreDa IRollScoreDaSingleton = new RollScoreDaImpl();
	final static IPlayerDa IPlayerDaSingleton = new PlayerDaImpl();
	final static IKittyDa IKittyDaSingleton = new KittyDaImpl();
	final static IRoundDa IRoundDaSingleton = new RoundDaImpl();
	final static IGameRulesEngineBo IGameRulesEngineBoSingleton = new GameRulesEngineBoImpl();
	final static IPlayerBo IPlayerBoSingleton = new PlayerBoImpl();
	final static IRollBo IRollBoSingleton = new RollBoImpl();
	final static IRoundBo IRoundBoSingleton = new RoundBoImpl();
	final static IRollScoreBo IRollScoreBoSingleton = new RollScoreBoImpl();
	
	
	public static IRollScoreDa provideRollScoreDa() {
		return IRollScoreDaSingleton;
	}
	
	public static IPlayerDa providePlayerDa() {
		return IPlayerDaSingleton;
	}
	
	public static IKittyDa provideKittyDa() {
		return IKittyDaSingleton;
	}
	
	public static IRoundDa provideRoundDa(){
		return IRoundDaSingleton;
	}
	
	public static IGameRulesEngineBo provideGameRulesEngineBo() {
		return IGameRulesEngineBoSingleton;
	}

	public static IPlayerBo providePlayerBo() {
		return IPlayerBoSingleton;
	}
	
	public static IRollBo provideRollBo() {
		return IRollBoSingleton;
	}	
	
	public static IRoundBo provideRoundBo() {
		return IRoundBoSingleton;
	}

	public static IRollScoreBo provideRollScoreBo() {
		return IRollScoreBoSingleton;
	}
	
}
