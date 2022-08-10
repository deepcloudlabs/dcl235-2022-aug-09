package com.example.world.domain;

import java.util.List;

public class Country implements Statistics {
	private String code; // iso3
	private String name;
	private City capital;
	private List<City> cities;

	public Country() {
	}

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return cities.stream().mapToLong(Statistics::getPopulation).sum();
	}

	public double getSurfaceArea() {
		return cities.stream().mapToDouble(Statistics::getSurfaceArea).sum();
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public double getGnp() {
		return cities.stream().mapToDouble(Statistics::getGnp).sum();
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", population=" + getPopulation() + ", surfaceArea="
				+ getSurfaceArea() + ", capital=" + capital + "]";
	}

}
