package edu.skunkApp.di;

import dagger.Component;
import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;

@Component(modules = {SkunkAppModule.class})
public interface SkunkAppComponent {
	IRollScoreDa rollScoreDa();
	IRollScoreBo rollScoreBo();
	IPlayerBo playerBo();
	IPlayerDa  playerDa();
}
