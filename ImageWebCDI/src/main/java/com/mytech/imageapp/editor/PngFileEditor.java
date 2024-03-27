package com.mytech.imageapp.editor;

import java.io.Serializable;

import jakarta.enterprise.inject.Default;

@Default
public class PngFileEditor implements ImageFileEditor, Serializable{

	private static final long serialVersionUID = -4185531470245061560L;

	@Override
	public String openFile (String filename) {
		return "PngFileEditor::openFile" + filename;
	}
	
	@Override
	public String editFile (String filename) {
		return "PngFileEditor::editFile" + filename;
	}
	
	@Override
	public String saveFile (String filename) {
		return "PngFileEditor::saveFile" + filename;
	}
}
