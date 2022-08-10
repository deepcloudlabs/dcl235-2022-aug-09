package com.example.application;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudyDecoratorPatternInJavaIO {

	public static void main(String[] args) throws IOException {
		Rectangle rect = new Rectangle(10, 10, 0, 0);
		File file = new File("c:/tmp","myrect.dat");
		try( // try-with-resources
			FileOutputStream os = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(os);	
			ObjectOutputStream oos = new ObjectOutputStream(bos);
		){
			oos.writeObject(rect);
		}
	
	}

}

@SuppressWarnings("serial")
class Rectangle implements Serializable {
	int width, height;
	int topX, topY;

	public Rectangle(int width, int height, int topX, int topY) {
		this.width = width;
		this.height = height;
		this.topX = topX;
		this.topY = topY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTopX() {
		return topX;
	}

	public void setTopX(int topX) {
		this.topX = topX;
	}

	public int getTopY() {
		return topY;
	}

	public void setTopY(int topY) {
		this.topY = topY;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", topX=" + topX + ", topY=" + topY + "]";
	}

}