package edu.skunkApp.di;

import dagger.Component;
import edu.skunkApp.dataAccess.IRollScoreDa;

@Component(modules = {SkunkAppModule.class})
public interface SkunkAppComponent {
	IRollScoreDa rollScoreDa();
}
