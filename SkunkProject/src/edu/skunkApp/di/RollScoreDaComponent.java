package edu.skunkApp.di;

import dagger.Component;
import edu.skunkApp.dataAccess.IRollScoreDa;

@Component(modules = {RollScoreDaModule.class})
interface RollScoreDaComponent {
	IRollScoreDa rollScoreDa();
}
