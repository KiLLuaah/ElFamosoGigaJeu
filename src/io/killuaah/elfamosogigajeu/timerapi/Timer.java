package io.killuaah.elfamosogigajeu.timerapi;

import java.lang.reflect.Method;

public class Timer extends Thread {

	// The currentTimeMillis when the timer is launched
	private long startMS;

	private String timerId;

	private volatile long currentMS;

	private volatile long remainingMS;

	public volatile boolean isTerminated;

	private volatile int loopMade = 0;

	private long secToWait;

	private TimerMode timerMode;

	private TimeUnit timeUnit;

	// The autoexec part
	private boolean isAutoExec;
	private Method toAutoExec;

	//TODO: The main constructor of the timer
	public Timer(long secToWait, TimerMode timerMode, TimeUnit timeUnit) {
		super();
		this.secToWait = secToWait;
		this.timerMode = timerMode;
		this.timeUnit = timeUnit;
		this.isTerminated = false;
		this.isAutoExec = false;
		this.toAutoExec = null;
		this.timerId = null;
	}

	//TODO: Advanced constructor of the timer, not usable on the v1.0
	public Timer(long secToWait, TimerMode timerMode, TimeUnit timeUnit, Method toAutoExec, String timerId) {
		super();
		this.secToWait = secToWait;
		this.timerMode = timerMode;
		this.timeUnit = timeUnit;
		this.isTerminated = false;
		this.isAutoExec = true;
		this.toAutoExec = toAutoExec;
		this.timerId = timerId;
	}

	public void runTimer() {
		this.startMS = System.currentTimeMillis();
		super.start();
	}

	@Override
	public void start() {
		System.out.println("Error ! You can't start a Timer from this void !");
	}

	@Override
	@SuppressWarnings("deprecation")
	public void run() {
		getSecsToWait();
		while (true) {
			if (System.currentTimeMillis() - startMS - secToWait == 0) {
				this.loopMade++;
				this.isTerminated = true;
				switch (this.timerMode) {
				case ONE_LAUNCH:
					this.isTerminated = false;
					this.stop();
					break;
				case WHILE:
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					this.isTerminated = false;
					this.startMS = System.currentTimeMillis();

					break;
				default:
					break;

				}
			}
		}
	}

	private void getSecsToWait() {
		secToWait *= timeUnit.getDivider();
	}

	/**
	 * @return the startMS
	 */
	public long getStartMS() {
		return startMS;
	}

	/**
	 * @return the timerId
	 */
	public String getTimerId() {
		return timerId;
	}

	/**
	 * @return the currentMS
	 */
	public long getCurrentMS() {
		return currentMS;
	}

	/**
	 * @return the remainingMS
	 */
	public long getRemainingMS() {
		return remainingMS;
	}

	/**
	 * @return the isTerminated
	 */
	public boolean isTerminated() {
		return isTerminated;
	}

	/**
	 * @return the loopMade
	 */
	public int getLoopMade() {
		return loopMade;
	}

	/**
	 * @return the secToWait
	 */
	public long getSecToWait() {
		return secToWait;
	}

	/**
	 * @return the timerMode
	 */
	public TimerMode getTimerMode() {
		return timerMode;
	}

	/**
	 * @return the timeUnit
	 */
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	/**
	 * @return the isAutoExec
	 */
	public boolean isAutoExec() {
		return isAutoExec;
	}

	/**
	 * @return the toAutoExec
	 */
	public Method getToAutoExec() {
		return toAutoExec;
	}
	
}
