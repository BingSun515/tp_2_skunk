package edu.skunkApp.di;

import dagger.Provides;
import dagger.Module;
import edu.skunkApp.dataAccess.RollScoreDaImpl;
import edu.skunkApp.dataAccess.IRollScoreDa;

/**TODO
 * Can the modules be on their own package? 
 * */
@Module
public class RollScoreDaModule {
	
	@Provides IRollScoreDa provideRollScore() {
		return new RollScoreDaImpl();
	}
}
