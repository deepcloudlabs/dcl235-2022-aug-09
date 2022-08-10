package com.example.world.domain;

import java.util.ArrayList;
import java.util.List;

public class World implements Statistics {
	private List<Continent> continents = new ArrayList<>();

	public World() {
	}

	public void addContinent(Continent continent) {
		continents.add(continent);
	}
	
	@Override
	public long getPopulation() {
		return continents.stream().mapToLong(Statistics::getPopulation).sum();
	}

	@Override
	public double getSurfaceArea() {
		return continents.stream().mapToDouble(Statistics::getSurfaceArea).sum();
	}
	
}
