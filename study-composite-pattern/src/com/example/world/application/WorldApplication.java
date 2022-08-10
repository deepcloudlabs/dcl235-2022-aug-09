package com.example.world.application;

import java.util.List;

import com.example.world.domain.City;
import com.example.world.domain.Continent;
import com.example.world.domain.Country;
import com.example.world.domain.World;

public class WorldApplication {

	public static void main(String[] args) {
		Country turkey = new Country("tur", "turkey");
		City ankara= new City("ankara", true, 6000000, 23442356);
		City istanbul= new City("istanbul", false, 21000000, 123442356);
		turkey.setCapital(ankara);
		turkey.setCities(List.of(ankara,istanbul));
		Continent asia = new Continent("asia");
		asia.addCountry(turkey);
		World world = new World();
		world.addContinent(asia);
		System.err.println("World population: "+world.getPopulation());
		System.err.println("World surface area: "+world.getSurfaceArea());
		System.err.println("World GNP: "+world.getGnp());
	}

}
