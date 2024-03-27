package com.mytech.imageapp;

import java.io.Serializable;

import com.mytech.imageapp.processor.ImageFileProcessor;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("imageMgmtBean")
@SessionScoped
public class imageManageBean implements Serializable{

	private static final long serialVersionUID = -8185339406305021009L;
	@Inject
	private ImageFileProcessor processor;
	
	public String getInforOpen() {
		return processor.processOpen("myfile.png");
	}
	
	public String getInforEdit() {
		return processor.processEdit("myfile.png");
	}
	
	public String getInforSave() {
		return processor.processSave("myfile.png");
	}
}
