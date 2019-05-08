package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;

import edu.skunkApp.dataAccess.IKittyDa;

public class KittyDaImpl implements IKittyDa {

	@Inject
	private ArrayList<Integer> _chips = new ArrayList<>();

	public int getChipCount() {
		return this._chips.stream()
				.mapToInt(chip -> chip.intValue())
				.sum();
	}

	public void setChipCount(int chipCount) {
		this._chips.add(chipCount);		
	}

}
