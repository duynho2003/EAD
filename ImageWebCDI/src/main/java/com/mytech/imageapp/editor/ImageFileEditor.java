package com.mytech.imageapp.editor;

public interface ImageFileEditor {
	String openFile(String fileName);
	String editFile(String fileName);
	String saveFile(String fileName);
}
