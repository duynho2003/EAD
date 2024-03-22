package com.mytech.dependency.processor;

import com.mytech.dependency.editors.JpgFIleEditor;
import com.mytech.dependency.editors.PngFIleEditor;
import com.mytech.dependency.log.TimeLogger;

public class ImageFileProccessor {
	
	// private JpgFIleEditor fileEditor;
	private PngFIleEditor fileEditor;
	private TimeLogger timeLogger;
	
	public ImageFileProccessor() {
		fileEditor = new PngFIleEditor();
		timeLogger = new TimeLogger();
	}
	
	public String proccessingFile(String fileName) {
		System.out.println(fileEditor.openFile(fileName) + "at " + timeLogger.getTime());
		System.out.println(fileEditor.editFile(fileName) + "at " + timeLogger.getTime());
		System.out.println(fileEditor.saveFile(fileName) + "at " + timeLogger.getTime());
		
		return "proccessing done";
	}
}
