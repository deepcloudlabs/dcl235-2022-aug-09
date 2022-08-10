package com.example.service;

import java.util.Collection;
import java.util.function.Predicate;

import com.example.domain.Shape;
import com.example.domain.Square;

public class ShapeService {
	public double getTotalArea(Collection<Shape> shapes) {
//		double sum=0.;
//		for (Shape shape : shapes)
//		    if (shape instanceof Square)
//			sum += shape.area();
//		return sum;
		 Predicate<? super Shape> isSquare = shape->shape instanceof Square;
		return shapes.stream()
				      .parallel()
				      .filter(isSquare.negate() )
				      .mapToDouble(Shape::area)
				      .sum();
	}
}
