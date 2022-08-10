package com.example;

public class Exercise04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// violates ISP
interface ArithmeticCalculator {
	double add(double x,double y);
	double sub(double x,double y);
	double mul(double x,double y);
	double div(double x,double y);
}

interface UnitCalculator {
	double kilometer2Mile(double km);
	double newtonToKilogram(double nw);
}

interface TriCalculator {
	double sin(double rad);
	double cos(double rad);
}

class StandardCalculator implements ArithmeticCalculator {

	@Override
	public double add(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sub(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mul(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double div(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface ScientificCalculator extends ArithmeticCalculator, UnitCalculator, TriCalculator {} 
