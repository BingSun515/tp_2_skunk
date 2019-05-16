package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import edu.skunkApp.dataAccess.IKittyDa;

public class KittyDaImpl implements IKittyDa {

	//TODO: inject
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
