package com.mytech.imageapp.editor;

import java.io.Serializable;

import jakarta.enterprise.inject.Alternative;
@Alternative
public class JpgFileEditor implements ImageFileEditor, Serializable {

	private static final long serialVersionUID = -3938891640352240425L;

	@Override
	public String openFile (String filename) {
		return "JpgFileEditor::openFile" + filename;
	}
	
	@Override
	public String editFile (String filename) {
		return "JpgFileEditor::editFile" + filename;
	}
	
	@Override
	public String saveFile (String filename) {
		return "JpgFileEditor::saveFile" + filename;
	}
}
