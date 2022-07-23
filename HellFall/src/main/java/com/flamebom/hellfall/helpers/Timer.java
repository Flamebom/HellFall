package com.flamebom.hellfall.helpers;

import net.minecraft.world.level.Level;

public class Timer {
	private float seconds;

	public Timer(Level level) {
		seconds = level.getGameTime() % 20F;
	}

	public Timer(float seconds) {
		this.seconds = seconds;
	}

	public float getTime() {
		return seconds;
	}

	public void subtractTime(float change) {
		seconds -= change;
	}

	public boolean hasTime() {
		return seconds > 0;
	}
}
