package com.mytech.dependency.editors;

public class JpgFIleEditor {
	public String openFile(String fileName) {
		return "JpgFileEditor::openFile" + fileName;
	}
	
	public String editFile(String fileName) {
		return "JpgFileEditor::editFile" + fileName;
	}
	
	public String saveFile(String fileName) {
		return "JpgFileEditor::saveFile" + fileName;
	}
}
