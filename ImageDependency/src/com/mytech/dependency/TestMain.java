package com.mytech.dependency;

import com.mytech.dependency.processor.ImageFileProccessor;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("Context and DI");
		ImageFileProccessor proccessor = new ImageFileProccessor();
		String result = proccessor.proccessingFile("MY FILE");
		System.out.println("--------> " + result);
	}
}
