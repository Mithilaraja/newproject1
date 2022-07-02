package org.pageexe;

import java.io.IOException;

import org.basecls.BaseCls;
import org.junit.Test;
import org.locators.BookAHotel;
import org.locators.SearchHotel;

public class BookAHotelExe extends BookAHotel {
	@Test
	public void bookhot() throws IOException {

		BaseCls.sendKeys(findElementById("first_name"), xcell(4, 0));
		BaseCls.sendKeys(findElementById("last_name"), xcell(5, 0));
		BaseCls.sendKeys(findElementById("address"), xcell(6, 0));
		BaseCls.sendKeys(findElementById("cc_num"), xcell(7, 0));
        BaseCls.sendKeys(findElementById("creditType"), xcell(8, 0));

	}

}
