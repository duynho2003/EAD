package com.mytech.dependency.editors;

public class PngFIleEditor {
	public String openFile(String fileName) {
		return "PngFileEditor::openFile" + fileName;
	}
	
	public String editFile(String fileName) {
		return "PngFileEditor::editFile" + fileName;
	}
	
	public String saveFile(String fileName) {
		return "PngFileEditor::saveFile" + fileName;
	}
}
