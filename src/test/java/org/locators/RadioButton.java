package org.locators;


import org.pageexe.SearchHotelExe;

public class RadioButton extends SearchHotelExe {
	
public void radio(){
	
	clickButton(findElementById("radiobutton_0"));
	clickButton(findElementById("continue"));
}
}
