package com.mytech.imageapp.processor;

import java.io.Serializable;

import com.mytech.imageapp.editor.ImageFileEditor;
import com.mytech.imageapp.editor.JpgFileEditor;
import com.mytech.imageapp.logger.TimeLogger;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;

@SessionScoped
@Default
public class ImageFileProcessor implements Serializable {

	private static final long serialVersionUID = -8567941040364201196L;

	@Inject
	private ImageFileEditor fileEditor;

	@Inject
	private TimeLogger timeLogger;

	public ImageFileProcessor() {

	}

	public String processOpen(String fileName) {
		return fileEditor.openFile(fileName) + "at" + timeLogger.getTime();
	}

	public String processSave(String fileName) {
		return fileEditor.saveFile(fileName) + "at" + timeLogger.getTime();

	}

	public String processEdit(String fileName) {
		return fileEditor.editFile(fileName) + "at" + timeLogger.getTime();

	}

	public String processingFile(String filename) {
		System.out.println(fileEditor.openFile(filename) + "at" + timeLogger.getTime());
		System.out.println(fileEditor.editFile(filename) + "at" + timeLogger.getTime());
		System.out.println(fileEditor.saveFile(filename) + "at" + timeLogger.getTime());
		return "processing File done";

	}
}
