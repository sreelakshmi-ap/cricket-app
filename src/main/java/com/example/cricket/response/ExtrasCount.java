package com.example.cricket.response;

public class ExtrasCount {
	private int wide;
	private int noBall;
	private int legBye;
	private int bye;
	
	
	
	public ExtrasCount() {
		
	}
	
	public ExtrasCount(int wide, int noBall, int legBye, int bye) {
		super();
		this.wide = wide;
		this.noBall = noBall;
		this.legBye = legBye;
		this.bye = bye;
	}
	
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	public int getNoBall() {
		return noBall;
	}
	public void setNoBall(int noBall) {
		this.noBall = noBall;
	}
	public int getLegBye() {
		return legBye;
	}
	public void setLegBye(int legBye) {
		this.legBye = legBye;
	}
	public int getBye() {
		return bye;
	}
	public void setBye(int bye) {
		this.bye = bye;
	}
	
	

}
