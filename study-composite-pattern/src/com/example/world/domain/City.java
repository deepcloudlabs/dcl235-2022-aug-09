package com.example.world.domain;

public class City implements Statistics {
	private String name;
	private boolean isCapital;
	private long population;
	private double surfaceArea;

	public City() {
	}

	public City(String name, boolean isCapital, long population, double surfaceArea) {
		this.name = name;
		this.isCapital = isCapital;
		this.population = population;
		this.surfaceArea = surfaceArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCapital() {
		return isCapital;
	}

	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", isCapital=" + isCapital + ", population=" + population + ", surfaceArea="
				+ surfaceArea + "]";
	}
	
}
