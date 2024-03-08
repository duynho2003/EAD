package com.mytech.uppercase.ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class UpperCaseBean
 */
@Stateless
@LocalBean
public class UpperCaseBean implements UpperCaseBeanRemote {

    public UpperCaseBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String transformToUpperCase(String message) {
		if (message == null) return "Hello";
		
		StringBuffer upperCaseMessage = new StringBuffer(message);
		for (int i = 0; i< message.length(); i++) {
			if(Character.isLowerCase(message.charAt(i))) {
				upperCaseMessage.setCharAt(i, Character.toUpperCase(message.charAt(i)));
			}else {
				upperCaseMessage.setCharAt(i, Character.toLowerCase(message.charAt(i)));
			}
		}
		return upperCaseMessage.toString();
	}

	

}
