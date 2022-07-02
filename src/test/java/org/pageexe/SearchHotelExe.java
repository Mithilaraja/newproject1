package org.pageexe;

import org.basecls.BaseCls;
import org.junit.Test;

import org.locators.SearchHotel;

public class SearchHotelExe extends SearchHotel {
	@Test
	public void search() {
		BaseCls.sendKeys(findElementById(SearchHotel.city), "");
		BaseCls.sendKeys(findElementById(SearchHotel.hotel), "");
		BaseCls.sendKeys(findElementById(SearchHotel.roomType),"" );
		BaseCls.sendKeys(findElementById(SearchHotel.datepickin),"" );
		BaseCls.sendKeys(findElementById(SearchHotel.datepickout), "");
		BaseCls.sendKeys(findElementById(SearchHotel.numOfRoom),"" );
		BaseCls.sendKeys(findElementById(SearchHotel.adults),"");
		BaseCls.sendKeys(findElementById(SearchHotel.child), "");
		
		
	}
	

}
