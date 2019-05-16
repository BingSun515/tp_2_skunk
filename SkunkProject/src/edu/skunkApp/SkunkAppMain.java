package edu.skunkApp;

import edu.skunkApp.controller.GameController;
import edu.skunkApp.di.SkunkAppComponent;
import edu.skunkApp.di.DaggerSkunkAppComponent;

public class SkunkAppMain {

	public static void main(String[] args)
	{
		
		SkunkAppComponent skunkAppComponent = DaggerSkunkAppComponent.builder().build();
				
		
		GameController gameController = new GameController();
		gameController.StartGame();
	}
}
