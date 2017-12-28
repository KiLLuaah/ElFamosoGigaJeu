package io.killuaah.elfamosogigajeu.timerapi;

public abstract class TimeUnit {
	
	int divider;
	
	String unitName;
	
	public TimeUnit(int divider, String unitName) {
		this.divider = divider;
		this.unitName = unitName;
	}

	public int getDivider() {
		return divider;
	}

	public String getUnitName() {
		return unitName;
	}
	
}
