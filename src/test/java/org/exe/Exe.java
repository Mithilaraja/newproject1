package org.exe;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.pageexe.BookAHotelExe;
import org.pageexe.LoginPageExe;
import org.pageexe.RadioButtonExe;
import org.pageexe.SearchHotelExe;

@RunWith(Suite.class)
	@SuiteClasses({LoginPageExe.class,SearchHotelExe.class,RadioButtonExe.class,BookAHotelExe.class})
	

	public class Exe extends BookAHotelExe{
	public static void main(String[] args) throws IOException {
	launch();
	UserName();
	city("");
	hotel("");
	roomType("");
	numOfRoom("");
	adults("");
	child("");
	click();
	

	}

	
	}

	
	



