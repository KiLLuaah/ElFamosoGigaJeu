package io.killuaah.elfamosogigajeu.timerapi;


import io.killuaah.elfamosogigajeu.timerapi.units.MillisTimeUnit;
import io.killuaah.elfamosogigajeu.timerapi.units.MinutesTimeUnit;
import io.killuaah.elfamosogigajeu.timerapi.units.SecondsTimeUnit;

public abstract class Time {

	/*
	 * This class is a wrapper class, you don't need to create a new instance of a timeunit class
	 */
	
	public static TimeUnit SECONDS() {
		return new SecondsTimeUnit();
	}
	
	public static TimeUnit MINUTES() {
		return new MinutesTimeUnit();
	}
	
	public static TimeUnit MILLIS() {
		return new MillisTimeUnit();
	}
	
}
