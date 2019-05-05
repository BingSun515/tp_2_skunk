package edu.skunkApp.data;

import java.util.UUID;

/**
 * in-memory table
 * */
public class Player {
	UUID playerId;
	String name;
	int chipCount; //TODO: should the chipCount be tracked here?
}
