package com.mercadolibre.mutant.entity;

public class Stat {
	private int humans;
	private int mutants;
	private double ratio;
	
	public Stat(int humans, int mutants, double ratio) {
		super();
		this.humans = humans;
		this.mutants = mutants;
		this.ratio = ratio;
	}
	
	public int getHumans() {
		return humans;
	}
	public void setHumans(int humans) {
		this.humans = humans;
	}
	public int getMutants() {
		return mutants;
	}
	public void setMutants(int mutants) {
		this.mutants = mutants;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}
