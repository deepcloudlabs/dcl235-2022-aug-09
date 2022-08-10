package com.example.domain;

public class Square implements Shape {
	private double edge;

	public Square(double edge) {
		this.edge = edge;
	}

	public double getEdge() {
		return edge;
	}

	@Override
	public double area() {
		return edge * edge;
	}

}
