package com.elenai.elenaiaccessories.capability.xp;

public class Xp implements IXp {

	private int xp = 0;

	@Override
	public void increase(int xp) {
		this.xp += xp;
	}

	@Override
	public void decrease(int xp) {
		this.xp -= xp;
	}

	@Override
	public void set(int xp) {
		this.xp = xp;
	}

	@Override
	public int getXp() {
		return this.xp;
	}

}
