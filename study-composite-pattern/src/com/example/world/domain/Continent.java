package com.example.world.domain;

import java.util.ArrayList;
import java.util.List;

public class Continent implements Statistics {
	private String name;

	private List<Country> countries = new ArrayList<>();

	public Continent(String name) {
		this.name = name;
	}

	public void addCountry(Country country) {
		countries.add(country);
	}

	public String getName() {
		return name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	@Override
	public long getPopulation() {
		return countries.stream().mapToLong(Statistics::getPopulation).sum();	}

	@Override
	public double getSurfaceArea() {
		return countries.stream().mapToDouble(Statistics::getSurfaceArea).sum();
	}

}
