package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;

import edu.skunkApp.data.Store;
import edu.skunkApp.dataAccess.IKittyDa;

public class KittyDaImpl implements IKittyDa {

	private ArrayList<Integer> _chips = Store.getKitty();

	public int getChipCount() {
		return this._chips.stream()
				.mapToInt(chip -> chip.intValue())
				.sum();
	}

	public void setChipCount(int chipCount) {
		this._chips.add(chipCount);		
	}

}
