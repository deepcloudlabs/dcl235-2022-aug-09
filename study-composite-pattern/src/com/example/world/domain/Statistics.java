package com.example.world.domain;

public interface Statistics {
	long getPopulation();
	double getSurfaceArea();
	default double getGnp() {
		return Double.NaN;
	}
}
