package com.example.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudyDecoratorPatternInJavaIOReadObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("c:/tmp","myrect.dat");
		try(FileInputStream is = new FileInputStream(file); 
		ObjectInputStream ois = new ObjectInputStream(is);){
			var rect = (Rectangle) ois.readObject();
			System.out.println(rect);
		}
	
	}

}
